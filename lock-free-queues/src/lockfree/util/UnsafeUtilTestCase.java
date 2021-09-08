package lockfree.util;

import sun.jvm.hotspot.utilities.Assert;
import sun.misc.Unsafe;

/**
 * @author XueweiHuang
 * @created 2021-09-08
 */
public class UnsafeUtilTestCase {

  private static final Unsafe UNSAFE;

  static {
    UNSAFE = UnsafeUtil.getUnsafe();
  }

  public static void main(String[] args) {
    testGetUnsafe();
  }

  private static void testGetUnsafe() {
    System.out.println("----------testGetUnsafe----------");
    Assert.that(UNSAFE != null, "Can not get theUnsafe Object.");
  }
}
