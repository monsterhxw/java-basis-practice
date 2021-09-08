package lockfree;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author XueweiHuang
 * @created 2021-09-08
 */
public class TestCase {
  public static void main(String[] args) {
    testLockFreeLinkedQueue();
  }

  private static void testLockFreeLinkedQueue() {
    LockFreeQueue<Integer> lockFreeQueue = new LockFreeLinkedQueue<>();

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    CountDownLatch latch = new CountDownLatch(10);
    for (int i = 0; i < 10; i++) {
      int finalI = i;
      cachedThreadPool.execute(
          () -> {
            latch.countDown();
            lockFreeQueue.enqueue(finalI);
          });
    }

    try {
      latch.await();
    } catch (InterruptedException e) {
    } finally {
      System.out.println("latch getCount: " + latch.getCount());
      cachedThreadPool.shutdown();
    }

    System.out.println("end");
  }
}
