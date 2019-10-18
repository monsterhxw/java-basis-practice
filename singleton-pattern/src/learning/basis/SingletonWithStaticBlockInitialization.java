package learning.basis;

/**
 * 静态代码块初始化模式类似于饿汉模式，增加类在静态代码块创建实例的异常处理。
 *
 * @author HuangXuewei
 */
public class SingletonWithStaticBlockInitialization {

    /**
     * 定义类的实例为 static
     */
    private static SingletonWithStaticBlockInitialization instance;

    /**
     * 将构造方法私有化
     */
    private SingletonWithStaticBlockInitialization() {
    }

    /**
     * 异常处理静态初始化块
     */
    static {
        try {
            instance = new SingletonWithStaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    /**
     * 定义唯一获取实例的方法
     *
     * @return instance
     */
    public static SingletonWithStaticBlockInitialization getInstance() {
        return instance;
    }
}
