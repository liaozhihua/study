package com.example.study.design_pattern.factory;

/**
 * 工厂方法的实现类 这个其实可以做成抽象工厂
 */
public class FactoryMethodImp1 extends FactoryMethod{
    @Override
    public Car createCar(String carType) {
        switch (carType) {
            case "A":
                Car productA = new AodiQ5();
                productA.setName("AodiQ5");
                return productA;
            case "B":
                Car productB = new AodiQ7();
                productB.setName("AodiQ7");
                return productB;
            default:
                Car product = new AodiQ5();
                product.setName("AodiQ5");
                return product;
        }
    }
}
