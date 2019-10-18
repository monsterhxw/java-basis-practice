package learning.abstract_factory_pattern.concrete_factory;

import learning.abstract_factory_pattern.abstract_factory.Factory;
import learning.abstract_factory_pattern.abstract_product.Bullet;
import learning.abstract_factory_pattern.abstract_product.Gun;
import learning.abstract_factory_pattern.concrete_product.M4A1;
import learning.abstract_factory_pattern.concrete_product.M4A1Bullet;

public class M4A1Factory implements Factory {

    @Override
    public Gun prduceGun() {
        return new M4A1();
    }

    @Override
    public Bullet produceBullet() {
        return new M4A1Bullet();
    }
}
