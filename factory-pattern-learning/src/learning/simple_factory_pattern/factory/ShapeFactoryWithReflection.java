package learning.simple_factory_pattern.factory;

import learning.simple_factory_pattern.product.Shape;

public class ShapeFactoryWithReflection {

    /**
     * 利用反射解决简单工厂每次增加新了产品类都要修改产品工厂的弊端
     */
    public static Object getClass(Class<? extends Shape> clazz) {
        Object object = null;
        try {
            object = Class.forName(clazz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}
