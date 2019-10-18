package learning.cglib_dynamic_proxy.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLIB 代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展。
 *
 *
 * 用CGLIB实现Java动态代理的局限性
 *
 * ---- 通过CGLIB成功创建的动态代理，实际是被代理类的一个子类。
 *
 * ---- 那么如果被代理类被标记成 final，也就无法通过 CGLIB 去创建动态代理。
 */
public class EngineerDynamicCGLibProxy implements MethodInterceptor {

    /**
     * 委托对象
     */
    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        Enhancer enhancer = new Enhancer();
        // 设置父类,Enhancer 需要设置目标对象为父类（因为生成的代理类需要继承目标对象）
        enhancer.setSuperclass(delegate.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = method.invoke(delegate, args);
        System.out.println("Engineer Dynamic CGLib Proxy: write documents.");
        return result;
    }
}
