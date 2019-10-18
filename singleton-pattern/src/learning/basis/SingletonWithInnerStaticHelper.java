package learning.basis;

/**
 * 静态内部辅助类懒汉模式
 *
 * @author HuangXuewei
 */
public class SingletonWithInnerStaticHelper {

    /**
     * 将构造方法私有化
     */
    private SingletonWithInnerStaticHelper() {
    }

    /**
     * 私有内部静态类包含 Singleton 类实例。
     *
     * 当 Singleton 类被加载，SingletonHelper 类没有加载到内存中
     *
     * 只有当调用 getInstance 方法，SingletonHelper 类才被加载并创建 Singleton 类的实例。
     *
     * 初始化静态数据时，Java 提供了线程安全性保证。
     */
    private static class SingletonHelper {

        private static final SingletonWithInnerStaticHelper INSTANCE = new SingletonWithInnerStaticHelper();
    }

    /**
     * 定义唯一获取实例的方法
     *
     * @return instance
     */
    public static SingletonWithInnerStaticHelper getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
