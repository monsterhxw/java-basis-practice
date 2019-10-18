package learning.basis;

/**
 * 饿汉模式（Singleton 类的实例是在类加载时创建的）
 *
 * @author HuangXuewei
 */
public class SingletonWithEagerInitialization {

    /**
     * 定义类的实例为 static final，让其在类加载时创建
     */
    private static final SingletonWithEagerInitialization instance = new SingletonWithEagerInitialization();

    /**
     * 将构造方法私有化
     */
    private SingletonWithEagerInitialization() {
    }

    /**
     * 定义唯一获取实例的方法
     *
     * @return instance
     */
    public static SingletonWithEagerInitialization getInstance() {
        return instance;
    }
}
