package com.example.study.design_pattern.strategy;

/**
 * 标准策略模式的例子
 */
public class StrategyFactoryDemo {
    public static void main(String[] args) {
        new StrategyFactory(new OperationAdd()).executeStrategy(10,5);
    }
}
