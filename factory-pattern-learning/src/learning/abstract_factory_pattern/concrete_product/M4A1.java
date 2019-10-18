package learning.abstract_factory_pattern.concrete_product;

import learning.abstract_factory_pattern.abstract_product.Gun;

public class M4A1 implements Gun {

    @Override
    public void shooting() {
        System.out.println("shooting with M4A1");
    }
}
