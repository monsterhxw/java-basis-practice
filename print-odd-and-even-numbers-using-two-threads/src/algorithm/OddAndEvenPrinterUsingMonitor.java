package algorithm;

/** @author monstervivi */
public class OddAndEvenPrinterUsingMonitor {
  private final Object monitor = new Object();

  private final int limit;

  private volatile int count = 0;

  public OddAndEvenPrinterUsingMonitor(int limit) {
    this.limit = limit;
  }

  public void printNums() {
    synchronized (monitor) {
      while (count <= limit) {
        System.out.println(
            String.format(
                "thread name is %s, print number is %s",
                Thread.currentThread().getName(), count++));

        monitor.notifyAll();

        try {
          if (count <= limit) {
            monitor.wait();
          }
        } catch (InterruptedException e) {
          // ignore exception
        }
      }
    }
  }

  public static void main(String[] args) {
    OddAndEvenPrinterUsingMonitor printer = new OddAndEvenPrinterUsingMonitor(10);

    new Thread(printer::printNums, "one").start();

    new Thread(printer::printNums, "two").start();
  }
}
