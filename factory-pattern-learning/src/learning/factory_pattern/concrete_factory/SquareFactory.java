package learning.factory_pattern.concrete_factory;

import learning.factory_pattern.abstract_factory.Factory;
import learning.factory_pattern.abstract_product.Shape;
import learning.factory_pattern.concrete_product.Square;

public class SquareFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Square();
    }
}
