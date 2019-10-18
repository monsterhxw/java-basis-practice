package learning;

class Superclass {

    /**
     * 父类静态变量
     */
    public static String p_StaticField = "父类--静态变量";

    /**
     * 父类非静态变量
     */
    public String p_Field = "父类--非静态变量";
    protected int i = 9;
    protected int j = 0;

    /**
     * 父类静态代码块
     */
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态代码块");
    }

    /**
     * 父类非静态代码块
     */ {
        System.out.println(p_Field);
        System.out.println("父类--非静态代码块");
    }

    /**
     * 父类构造方法
     */
    public Superclass() {
        System.out.println("父类--构造方法");
        System.out.println("i=" + i + ", j=" + j);
        j = 20;
    }
}

public class Subclass extends Superclass {

    /**
     * 子类静态变量
     */
    public static String s_StaticField = "子类--静态变量";

    /**
     * 子类非静态变量
     */
    public String s_Field = "子类--非静态变量";

    /**
     * 子类静态代码块
     */
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态代码块");
    }

    /**
     * 子类非静态代码块
     */ {
        System.out.println(s_Field);
        System.out.println("子类--非静态代码块");
    }

    /**
     * 子类构造方法
     */
    public Subclass() {
        System.out.println("子类--构造方法");
        System.out.println("i=" + i + ",j=" + j);
    }

    public static void main(String[] args) {
        System.out.println("子类主函数 main 方法");
        new Subclass();
        System.out.println("-------");
        new Subclass();
    }
}