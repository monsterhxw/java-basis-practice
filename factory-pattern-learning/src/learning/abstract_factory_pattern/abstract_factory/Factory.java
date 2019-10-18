package learning.abstract_factory_pattern.abstract_factory;

import learning.abstract_factory_pattern.abstract_product.Bullet;
import learning.abstract_factory_pattern.abstract_product.Gun;

public interface Factory {

    Gun prduceGun();

    Bullet produceBullet();
}
