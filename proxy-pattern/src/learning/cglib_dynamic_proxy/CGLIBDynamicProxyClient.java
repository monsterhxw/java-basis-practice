package learning.cglib_dynamic_proxy;

import learning.cglib_dynamic_proxy.proxy.EngineerDynamicCGLibProxy;
import learning.cglib_dynamic_proxy.real_subject.ProductManager;

/**
 * CGLIB 代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展。
 *
 *
 * 用 CGLIB 实现 Java 动态代理的局限性
 *
 * ---- 通过 CGLIB 成功创建的动态代理，实际是被代理类的一个子类。
 *
 * ---- 那么如果被代理类被标记成 final，也就无法通过 CGLIB 去创建动态代理。
 */
public class CGLIBDynamicProxyClient {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        EngineerDynamicCGLibProxy cgLibProxy = new EngineerDynamicCGLibProxy();

        ProductManager productManagerProxy = (ProductManager) cgLibProxy.bind(productManager);
        productManagerProxy.defineBackLog();
    }
}
