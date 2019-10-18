package learning.simple_factory_pattern.factory;

import learning.simple_factory_pattern.concrete_product.Circle;
import learning.simple_factory_pattern.concrete_product.Rectangle;
import learning.simple_factory_pattern.concrete_product.Square;
import learning.simple_factory_pattern.product.Shape;

public class ShapeFactory {

    /**
     * 使用 getShape 方法获取形状类型的对象
     */
    public static Shape getShape(String shapeType) {
        if (null == shapeType) {
            return null;
        }
        if ("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        }
        return null;
    }

}
