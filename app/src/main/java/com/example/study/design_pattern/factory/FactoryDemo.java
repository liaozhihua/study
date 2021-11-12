package com.example.study.design_pattern.factory;

//参考 https://www.liaoxuefeng.com/wiki/1252599548343744/1281319134822433
//1、https://www.cnblogs.com/lifegoeson/p/13474404.html
//https://blog.csdn.net/carson_ho/article/details/54910287 系列
//参考设计模式书 例子看完了 源码使用要看下
//优缺点 需要完善
//下次还得再看一遍加深理解  都是创建型模式
public class FactoryDemo {

    public void simpleFactory() {
        Car a = SimpleFactory.createCar("A");
        Car b = SimpleFactory.createCar("B");
    }

    public void factoryMethod() {
        FactoryMethodImp1 factoryMethodImp1 = new FactoryMethodImp1();
        factoryMethodImp1.createCar("A");
        FactoryMethodImp2 factoryMethodImp2 = new FactoryMethodImp2();
        factoryMethodImp2.createCar("A");
    }
}
