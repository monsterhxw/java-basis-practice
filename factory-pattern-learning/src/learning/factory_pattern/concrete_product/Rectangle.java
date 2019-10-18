package learning.factory_pattern.concrete_product;

import learning.factory_pattern.abstract_product.Shape;

public class Rectangle implements Shape {

    public Rectangle() {
        System.out.println("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}
