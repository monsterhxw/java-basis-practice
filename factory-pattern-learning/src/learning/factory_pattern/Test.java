package learning.factory_pattern;

import learning.factory_pattern.abstract_factory.Factory;
import learning.factory_pattern.abstract_product.Shape;
import learning.factory_pattern.concrete_factory.CircleFactory;
import learning.factory_pattern.concrete_factory.RectangleFactory;
import learning.factory_pattern.concrete_factory.SquareFactory;

public class Test {

    public static void main(String[] args) {
        Factory circleFactory = new CircleFactory();
        Shape circle = circleFactory.getShape();
        circle.draw();

        Factory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.getShape();
        rectangle.draw();

        Factory squareFactory = new SquareFactory();
        Shape square = squareFactory.getShape();
        square.draw();
    }
}
