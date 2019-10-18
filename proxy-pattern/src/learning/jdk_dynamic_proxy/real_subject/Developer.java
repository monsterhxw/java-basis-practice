package learning.jdk_dynamic_proxy.real_subject;

import learning.jdk_dynamic_proxy.subject_interface.DeveloperInterface;

public class Developer implements DeveloperInterface {

    @Override
    public void writeCode() {
        System.out.println("Real Subject: Developer write code.");
    }
}
