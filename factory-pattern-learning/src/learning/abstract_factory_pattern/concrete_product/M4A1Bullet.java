package learning.abstract_factory_pattern.concrete_product;

import learning.abstract_factory_pattern.abstract_product.Bullet;

public class M4A1Bullet implements Bullet {

    @Override
    public void load() {
        System.out.println("load bullets with M4A1");
    }
}
