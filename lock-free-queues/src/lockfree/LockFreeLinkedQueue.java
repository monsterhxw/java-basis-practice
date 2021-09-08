package lockfree;

import lockfree.util.UnsafeUtil;

/**
 * @author XueweiHuang
 * @created 2021-09-08
 */
public class LockFreeLinkedQueue<E> implements LockFreeQueue<E> {

  private static final sun.misc.Unsafe UNSAFE;
  private static final long headOffset;
  private static final long tailOffset;

  static {
    try {
      UNSAFE = UnsafeUtil.getUnsafe();
      Class<?> k = LockFreeLinkedQueue.class;
      headOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("head"));
      tailOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("tail"));
    } catch (Exception e) {
      throw new Error(e);
    }
  }

  private static class Node<E> {
    volatile E data;
    volatile Node<E> next;

    Node(E data) {
      UNSAFE.putObject(this, dataOffset, data);
    }

    boolean casNext(Node<E> oldVal, Node<E> newVal) {
      return UNSAFE.compareAndSwapObject(this, nextOffset, oldVal, newVal);
    }

    private static final sun.misc.Unsafe UNSAFE;
    private static final long dataOffset;
    private static final long nextOffset;

    static {
      try {
        UNSAFE = UnsafeUtil.getUnsafe();
        Class<?> k = LockFreeLinkedQueue.Node.class;
        dataOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("data"));
        nextOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("next"));
      } catch (Exception e) {
        throw new Error(e);
      }
    }
  }

  private transient volatile Node<E> head;

  private transient volatile Node<E> tail;

  public LockFreeLinkedQueue() {
    Node<E> node = new Node<>(null);
    head = tail = node;
  }

  @Override
  public boolean enqueue(E e) {
    final Node<E> newNode = new Node<>(e);

    while (true) {
      // 先取 tail 和 tail.next
      Node<E> t = this.tail;
      Node<E> next = t.next;

      // 如果 tail 被移动，重新开始
      if (t != this.tail) {
        continue;
      }

      // 如果 tail.next 不为空，则 fetch 最后到 tail 给到 next
      if (next != null) {
        casTail(t, next);
        continue;
      }

      // 如果加入节点成功，则退出
      if (t.casNext(next, newNode)) {
        // 置尾结点
        casTail(t, newNode);
        return true;
      }
    }
  }

  @Override
  public E dequeue() {
    while (true) {
      // 取出 head 指针， tail 指针，和第一个元素的指针
      Node<E> h = this.head;
      Node<E> t = this.tail;
      Node<E> first = h.next;
      // head 指针如果移动，重取 head 指针
      if (h != head) {
        continue;
      }
      // 如果是空队列返回 null
      if (h == t && first == null) {
        return null;
      }
      // 如果是 tail 指针落后了
      if (h == t && first == null) {
        casTail(t, first);
        continue;
      }
      // 移动 head 指针成功，返回数据
      if (casHead(h, first)) {
        h = null;
        return first.data;
      }
    }
  }

  private boolean casTail(Node<E> oldVal, Node<E> newVal) {
    return UNSAFE.compareAndSwapObject(this, tailOffset, oldVal, newVal);
  }

  private boolean casHead(Node<E> oldVal, Node<E> newVal) {
    return UNSAFE.compareAndSwapObject(this, headOffset, oldVal, newVal);
  }
}
