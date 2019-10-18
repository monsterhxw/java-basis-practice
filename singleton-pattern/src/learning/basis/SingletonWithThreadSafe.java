package learning.basis;

/**
 * 线程安全单例模式（需要用时候才创建实例对象）
 *
 * @author HuangXuewei
 */
public class SingletonWithThreadSafe {

    /**
     * 定义类的实例为 static
     */
    private static SingletonWithThreadSafe instance;

    /**
     * 将构造方法私有化
     */
    private SingletonWithThreadSafe() {
    }

    /**
     * 定义唯一获取实例的方法，同时在方法加上 synchronized，同步方法，性能较低
     *
     * @return instance
     */
    public static synchronized SingletonWithThreadSafe getInstance() {
        if (null == instance) {
            instance = new SingletonWithThreadSafe();
        }
        return instance;
    }
}
