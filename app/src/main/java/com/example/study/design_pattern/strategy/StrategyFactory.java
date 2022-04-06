package com.example.study.design_pattern.strategy;

/**
 * 策略模式 属于行为型模式
 * 参考 https://www.runoob.com/design-pattern/strategy-pattern.html
 * https://blog.csdn.net/qq_37141773/article/details/100561553
 * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 *
 * 何时使用：一个系统有许多许多类，而区分它们的只是他们直接的行为。
 *
 * 如何解决：将这些算法封装成一个一个的类，任意地替换。
 *
 * 应用实例： 1、诸葛亮的锦囊妙计，每一个锦囊就是一个策略。 2、旅行的出游方式，选择骑自行车、坐汽车，每一种旅行方式都是一个策略。 3、JAVA AWT 中的 LayoutManager。
 *
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 *
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 *-----------------------------
 * 跟代理模式的区别：
 * 代理和策略：
 * 简单代理模式中，代理类知道被代理类的行为，因为代理类与被代理类实现的是同一个接口，因此代理类与被代理类的结构是相同的
 * 策略模式中，策略容器并不知道内部策略的详细信息，因为容器并没有实现与内部策略相同的接口，即容器与内部策略只是简单的组合关系，
 * 容器只是将内部策略的行为抽取出来，进行了统一的实现。
 */
public class StrategyFactory {
    private Strategy strategy = new OperationAdd();
    public StrategyFactory(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1,num2);
    }
}
