package algo.consistenthash.loadbalancer;

import algo.consistenthash.invocation.Invocation;
import algo.consistenthash.server.Server;
import java.util.List;

/**
 * @author XueweiHuang
 * @created 2021-09-02
 */
public interface LoadBalancer {

  Server select(List<Server> servers, Invocation invocation);
}
