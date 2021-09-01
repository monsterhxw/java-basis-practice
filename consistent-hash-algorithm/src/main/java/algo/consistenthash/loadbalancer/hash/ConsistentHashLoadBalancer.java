package algo.consistenthash.loadbalancer.hash;

import algo.consistenthash.invocation.Invocation;
import algo.consistenthash.loadbalancer.LoadBalancer;
import algo.consistenthash.loadbalancer.hash.strategy.FnvHashStrategy;
import algo.consistenthash.loadbalancer.hash.strategy.HashStrategy;
import algo.consistenthash.server.Server;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author XueweiHuang
 * @created 2021-09-02
 */
public class ConsistentHashLoadBalancer implements LoadBalancer {

  private HashStrategy hashStrategy;

  private static final int VIRTUAL_NODE_SIZE = 10;
  private static final String VIRTUAL_NODE_SUFFIX = "&&";

  private final List<Server> servers;

  private final TreeMap<Integer, Server> ring;

  public ConsistentHashLoadBalancer(List<Server> servers) {
    this(new FnvHashStrategy(), servers);
  }

  public ConsistentHashLoadBalancer(HashStrategy hashStrategy, List<Server> servers) {
    this.hashStrategy = hashStrategy;
    this.servers = servers;
    this.ring = new TreeMap<>();
    putVirtualNodeToRing(this.ring, this.servers);
  }

  private void putVirtualNodeToRing(TreeMap<Integer, Server> ring, List<Server> servers) {
    for (Server srv : servers) {
      for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
        ring.put(hashStrategy.hashCode(srv.getUrl() + VIRTUAL_NODE_SUFFIX + i), srv);
      }
    }
  }

  @Override
  public Server select(List<Server> servers, Invocation invocation) {
    int hashcode = hashStrategy.hashCode(invocation.getHashKey());
    return locate(ring, hashcode);
  }

  private Server locate(TreeMap<Integer, Server> ring, int hashcode) {
    // 向右找到第一个 key
    Entry<Integer, Server> entry = ring.ceilingEntry(hashcode);
    if (entry == null) {
      // 想象为一个环，超过尾部则取第一个 key
      entry = ring.firstEntry();
    }
    return entry.getValue();
  }
}
