package lockfree.util;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author XueweiHuang
 * @created 2021-09-08
 */
public class UnsafeUtil {

  public static Unsafe getUnsafe() {
    try {
      Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
      theUnsafeField.setAccessible(true);
      return (Unsafe) theUnsafeField.get(null);
    } catch (Exception e) {
      throw new Error(e);
    }
  }
}
