package learning.abstract_factory_pattern;

import learning.abstract_factory_pattern.abstract_factory.Factory;
import learning.abstract_factory_pattern.abstract_product.Bullet;
import learning.abstract_factory_pattern.abstract_product.Gun;
import learning.abstract_factory_pattern.concrete_factory.AKFactory;
import learning.factory_pattern.concrete_factory.CircleFactory;
import learning.factory_pattern.concrete_factory.RectangleFactory;
import learning.factory_pattern.concrete_factory.SquareFactory;

public class Test {

    public static void main(String[] args) {
        Factory factory = new AKFactory();

        Gun gun = factory.prduceGun();

        Bullet bullet = factory.produceBullet();

        bullet.load();

        gun.shooting();
    }
}
