package com.example.study.design_pattern.factory;

/**
 * 简单工厂 也叫静态工厂
 * 优点是使用很简单 但是新增产品就需要修改工程类 违背开闭原则
 */
public class SimpleFactory {
    public static Car createCar(String productType) {
        switch (productType) {
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
