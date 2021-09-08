package lockfree;

/**
 * @author XueweiHuang
 * @created 2021-09-08
 */
public interface LockFreeQueue<E> {

  boolean enqueue(E e);

  E dequeue();
}
