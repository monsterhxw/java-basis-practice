package learning.simple_factory_pattern;

import learning.simple_factory_pattern.factory.ShapeFactory;
import learning.simple_factory_pattern.product.Shape;

public class Test {

    public static void main(String[] args) {
        // 获取 Circle 对象，并调用它的 draw 方法
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        // 获取 Rectangle 的对象，并调用它的 draw 方法
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        // 获取 Square 的对象，并调用它的 draw 方法
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();
    }
}
