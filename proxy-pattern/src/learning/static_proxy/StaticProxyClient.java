package learning.static_proxy;

import learning.static_proxy.proxy.DeveloperStaticProxy;
import learning.static_proxy.real_subject.Developer;
import learning.static_proxy.subject_interface.DeveloperInterface;

/**
 * 静态代理方式的优点
 *
 * 1. 易于理解和实现
 *
 * 2. 代理类和真实类的关系是编译期静态决定的，和下文马上要介绍的动态代理比较起来，执行时没有任何额外开销。
 *
 *
 * 静态代理的缺点
 *
 * 1. subject 增加方法，real subject 和 static proxy 代理类需要同步维护
 *
 * 2. real subject 增加，static proxy 代理类也要增加
 */
public class StaticProxyClient {

    public static void main(String[] args) {
        Developer developer = new Developer();

        DeveloperInterface developerStaticProxy = new DeveloperStaticProxy(developer);

        // 由代理对象 developerStaticProxy 调用 developer 来写代码，然后再写文档
        developerStaticProxy.writeCode();
    }
}
