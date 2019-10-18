package learning.abstract_factory_pattern.concrete_product;

import learning.abstract_factory_pattern.abstract_product.Bullet;

public class AKBullet implements Bullet {

    @Override
    public void load() {
        System.out.println("load bullets with AK");
    }
}
