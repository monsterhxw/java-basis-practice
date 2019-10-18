package learning.jdk_dynamic_proxy;

import learning.jdk_dynamic_proxy.proxy.EngineerDynamicProxy;
import learning.jdk_dynamic_proxy.real_subject.Developer;
import learning.jdk_dynamic_proxy.real_subject.Tester;
import learning.jdk_dynamic_proxy.subject_interface.DeveloperInterface;
import learning.jdk_dynamic_proxy.subject_interface.TesterInterface;

/**
 * InvocationHandler 局限性：如果被代理的类未实现任何接口，那么不能采用通过
 */
public class DynamicProxyClient {

    public static void main(String[] args) {
        DeveloperInterface developer = new Developer();

        TesterInterface tester = new Tester();

        EngineerDynamicProxy engineerDynamicProxy = new EngineerDynamicProxy();

        DeveloperInterface developerProxy = (DeveloperInterface) engineerDynamicProxy.bind(developer);
        developerProxy.writeCode();

        TesterInterface testerProxy = (TesterInterface) engineerDynamicProxy.bind(tester);
        testerProxy.doTesting();
    }
}
