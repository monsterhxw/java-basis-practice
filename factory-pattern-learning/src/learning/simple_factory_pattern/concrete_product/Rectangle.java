package learning.simple_factory_pattern.concrete_product;

import learning.simple_factory_pattern.product.Shape;

public class Rectangle implements Shape {

    public Rectangle() {
        System.out.println("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}
