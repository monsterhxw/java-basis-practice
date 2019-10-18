package learning.jdk_dynamic_proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 本身帮我们实现了动态代理，只需要使用 newProxyInstance 方法
 *
 * ClassLoader loader :指定当前目标对象使用类加载器
 *
 * Class<?>[] interfaces :代理类需要实现的接口列表
 *
 * InvocationHandler h:调用处理程序,将目标对象的方法分派到该调用处理程序
 */
public class EngineerDynamicProxy implements InvocationHandler {

    /**
     * 委托对象
     */
    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
            delegate.getClass().getClassLoader(),
            delegate.getClass().getInterfaces(),
            this
        );
    }

    /**
     * invoke 方法，负责增强目标对象的方法，
     *
     * 接口类的所有方法都会走这个 invoke 方法。
     *
     * 另外 bind 方法简单封装了 JDK 的代理方法 newProxyInstance，负责返回接口类。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // JVM通过这条语句执行原来的方法(反射机制)
        Object result = method.invoke(delegate, args);

        System.out.println("Engineer Dynamic Proxy: write document.");

        return result;
    }
}
