package learning;

public class InitialOrderDemo {

    /**
     * 静态变量
     */
    public static String staticField = "静态变量";

    /**
     * 非静态变量
     */
    public String field = "非静态变量";

    /**
     * 静态代码块
     */
    static {
        System.out.println(staticField);
        System.out.println("静态代码块");
    }

    /**
     * 非静态代码块
     */ {
        System.out.println(field);
        System.out.println("非静态代码块");
    }

    /**
     * 构造方法
     */
    public InitialOrderDemo() {
        System.out.println("构造方法");
    }

    /**
     * 静态方法
     */
    public static void print() {
        System.out.println("静态方法");
    }

    public static void main(String[] args) {
        new InitialOrderDemo();
        System.out.println("-------");
        new InitialOrderDemo();
        System.out.println("-------");
        InitialOrderDemo.print();
    }
}