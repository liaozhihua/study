package com.example.study.design_pattern.factory;

/**
 * 抽象工厂模式的抽象工厂 产生多个不同的产品
 * 优点是使用新增同一类产品类不需要修改工程类 而且 一个工厂可以创建多个产品 但是需要新增具体产品类跟具体工厂 类增多  而且新增产品还是需要修改工厂类
 */
public abstract class AbstractFactory {
    public abstract Car createCar(String carType);
    public abstract CarPaiZhao createCarPaiZhao(String zone);
}
