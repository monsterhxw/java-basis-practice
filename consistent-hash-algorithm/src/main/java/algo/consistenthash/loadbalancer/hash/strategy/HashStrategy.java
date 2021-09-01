package algo.consistenthash.loadbalancer.hash.strategy;

/**
 * @author XueweiHuang
 * @created 2021-09-02
 */
public interface HashStrategy {
    int hashCode(String origin);
}
