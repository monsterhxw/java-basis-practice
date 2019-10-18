package learning.simple_factory_pattern;

import learning.simple_factory_pattern.concrete_product.Circle;
import learning.simple_factory_pattern.concrete_product.Rectangle;
import learning.simple_factory_pattern.concrete_product.Square;
import learning.simple_factory_pattern.factory.ShapeFactoryWithReflection;

public class TestReflection {

    public static void main(String[] args) {
        Circle circle = (Circle) ShapeFactoryWithReflection.getClass(Circle.class);
        circle.draw();

        Rectangle rectangle = (Rectangle) ShapeFactoryWithReflection.getClass(Rectangle.class);
        rectangle.draw();

        Square square = (Square) ShapeFactoryWithReflection.getClass(Square.class);
        square.draw();
    }
}
