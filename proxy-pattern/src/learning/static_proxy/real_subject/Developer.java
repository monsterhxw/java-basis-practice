package learning.static_proxy.real_subject;

import learning.static_proxy.subject_interface.DeveloperInterface;

public class Developer implements DeveloperInterface {

    @Override
    public void writeCode() {
        System.out.println("Real Subject: Developer write code.");
    }
}
