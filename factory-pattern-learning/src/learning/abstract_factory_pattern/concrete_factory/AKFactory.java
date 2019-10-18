package learning.abstract_factory_pattern.concrete_factory;

import learning.abstract_factory_pattern.abstract_factory.Factory;
import learning.abstract_factory_pattern.abstract_product.Bullet;
import learning.abstract_factory_pattern.abstract_product.Gun;
import learning.abstract_factory_pattern.concrete_product.AK;
import learning.abstract_factory_pattern.concrete_product.AKBullet;

public class AKFactory implements Factory {

    @Override
    public Gun prduceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AKBullet();
    }
}
