package learning.factory_pattern.concrete_product;


import learning.factory_pattern.abstract_product.Shape;

public class Circle implements Shape {

    public Circle() {
        System.out.println("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
