package learning.simple_factory_pattern.concrete_product;

import learning.simple_factory_pattern.product.Shape;

public class Circle implements Shape {

    public Circle() {
        System.out.println("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
