package com.example.study.design_pattern.factory;
/**
 * 工厂方法的实现类 这个其实可以做成抽象工厂
 */
public class FactoryMethodImp2 extends FactoryMethod{
    @Override
    public Car createCar(String carType) {
        switch (carType) {
            case "A":
                Car productA = new BaoMaX5();
                productA.setName("BaoMaX5");
                return productA;
            case "B":
                Car productB = new BaoMaX7();
                productB.setName("BaoMaX7");
                return productB;
            default:
                Car product = new BaoMaX5();
                product.setName("BaoMaX5");
                return product;
        }
    }
}
