package learning.simple_factory_pattern.concrete_product;

import learning.simple_factory_pattern.product.Shape;

public class Square implements Shape {

    public Square() {
        System.out.println("Square");
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
