package learning.basis;

/**
 * 双重检查锁定机制的单例模式
 *
 * @author HuangXuewei
 */
public class SingletonWithDoubleCheckedLocking {

    /**
     * 定义类的实例为 static volatile
     */
    private static volatile SingletonWithDoubleCheckedLocking instance;

    /**
     * 将构造方法私有化
     */
    private SingletonWithDoubleCheckedLocking() {
    }

    /**
     * 定义唯一获取实例的方法，采用双重检测锁定机制（double-checked locking, DCL）
     *
     * @return instance
     */
    public static SingletonWithDoubleCheckedLocking getInstance() {
        // 第一次检查 instance 对象是为空
        if (null == instance) {
            // 同步代码块
            synchronized (SingletonWithDoubleCheckedLocking.class) {
                // 第二次检查 instance 对象是为空
                if (null == instance) {
                    // 若声明 instance 语句没有使用 volatile 对 instance 进行声明，
                    // 那么就有可能导致 SingletonWithThreadSafe 未构建好的对象逸出(注意不是溢出...)。
                    // instance = new SingletonWithThreadSafe(); 语句其实是分为多个 CPU 指令执行的，我们可以简化为三个步骤
                    // (1) 分配 SingletonWithDoubleCheckedLocking 类实例对象所需要的内存空间
                    // (2) 通过构造函数 SingletonWithDoubleCheckedLocking() 对 instance 对象的内存空间进行初始化
                    // (3) 将分配好的内存空间地址赋值给(指向) instance 对象
                    // 由于 CPU 和编译器在执行指令的时有可能会乱序执行 (2) 和 (3)，
                    // 如果乱序了，那么就有可能会产生一个没有构建完成的 instance 对象逸出
                    // 加上 volatile 关键字。对于变量操作就不会出现指令重排序。
                    // 注意: volatile 重排序指的是 Java 内存语义上的顺序(JVM 层面)，并不是时间上的执行顺序(物理机层面)。
                    // 所以一些说法"volatile，对于变量的操作就不可以重排序，(2) 操作一定会在 (3) 之前执行(时间上)"是不准确的。
                    // 在 JVM 内存模型中，指令顺序其实值得就是内存是否可见的顺序，而并不是真正指令执行的时间顺序
                    instance = new SingletonWithDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
