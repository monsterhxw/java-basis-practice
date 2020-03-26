package algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/** @author monstervivi */
public class OddAndEvenPrinterUsingAtomic {
  private final int limit;

  private final AtomicInteger count = new AtomicInteger(0);

  public OddAndEvenPrinterUsingAtomic(int limit) {
    this.limit = limit;
  }

  public void printNum() {
    new Thread(
            () -> {
              while (count.get() <= limit) {
                if ((count.get() & 1) != 0) {
                  System.out.println(String.format(" odd thread, print number is %s", count.get()));
                  count.incrementAndGet();
                }
              }
            })
        .start();

    new Thread(
            () -> {
              while (count.get() <= limit) {
                if ((count.get() & 1) == 0) {
                  System.out.println(String.format("even thread, print number is %s", count.get()));
                  count.incrementAndGet();
                }
              }
            })
        .start();
  }

  public static void main(String[] args) {
    OddAndEvenPrinterUsingAtomic printer = new OddAndEvenPrinterUsingAtomic(100);
    printer.printNum();
  }
}
