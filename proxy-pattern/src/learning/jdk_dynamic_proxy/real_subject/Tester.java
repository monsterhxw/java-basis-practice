package learning.jdk_dynamic_proxy.real_subject;

import learning.jdk_dynamic_proxy.subject_interface.TesterInterface;

public class Tester implements TesterInterface {

    @Override
    public void doTesting() {
        System.out.println("Real Subject: Tester do testing.");
    }
}
