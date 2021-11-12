package com.example.study.design_pattern.factory;
/**
 * 抽象工厂模式的具体工厂 产生多个不同的产品
 */
public class SHQ5Factory extends AbstractFactory{
    @Override
    public Car createCar(String carType) {
        return new AodiQ5();
    }

    @Override
    public CarPaiZhao createCarPaiZhao(String zone) {
        return new ShanghaiPaiZhao();
    }
}
