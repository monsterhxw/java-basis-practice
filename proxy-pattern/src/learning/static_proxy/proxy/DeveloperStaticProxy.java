package learning.static_proxy.proxy;

import learning.static_proxy.subject_interface.DeveloperInterface;

public class DeveloperStaticProxy implements DeveloperInterface {

    private DeveloperInterface developer;

    public DeveloperStaticProxy(DeveloperInterface developer) {
        this.developer = developer;
    }

    @Override
    public void writeCode() {
        developer.writeCode();
        System.out.println("Static proxy: Write documents.");
    }
}
