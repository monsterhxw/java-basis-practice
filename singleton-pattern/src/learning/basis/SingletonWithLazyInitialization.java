package learning.basis;

/**
 * 懒汉模式（需要用时候才创建实例对象）
 *
 * 只适用于单线程，多线程下，会破坏单例模式，多个线程获取不同的实例
 *
 * @author HuangXuewei
 */
public class SingletonWithLazyInitialization {

    /**
     * 定义类的实例为 static
     */
    private static SingletonWithLazyInitialization instance;

    /**
     * 将构造方法私有化
     */
    private SingletonWithLazyInitialization() {
    }

    /**
     * 定义唯一获取实例的方法
     *
     * @return instance
     */
    public static SingletonWithLazyInitialization getInstance() {
        if (null == instance) {
            instance = new SingletonWithLazyInitialization();
        }
        return instance;
    }
}
