package com.example.study.design_pattern.factory;

/**
 * 工厂方法 主要是生产单一产品 如果生产其他产品 那就需要使用抽象工厂
 * 优点是使用新增同一类产品类不需要修改工程类 但是需要新增具体产品类跟具体工厂 类增多  而且工厂都是单一工厂 没法生产多个产品
 */
public abstract class FactoryMethod {
    public abstract Car createCar(String carType);
}
