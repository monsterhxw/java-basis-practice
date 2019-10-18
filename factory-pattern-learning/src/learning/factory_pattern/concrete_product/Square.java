package learning.factory_pattern.concrete_product;

import learning.factory_pattern.abstract_product.Shape;

public class Square implements Shape {

    public Square() {
        System.out.println("Square");
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
