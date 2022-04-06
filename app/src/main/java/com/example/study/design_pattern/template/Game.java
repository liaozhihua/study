package com.example.study.design_pattern.template;

/**
 * 模板抽象父类
 */
public abstract class Game {
//    对于需要子类实现的抽象方法，一般声明为protected，使得这些方法对外部客户端不可见
    protected abstract void initialize();
    protected abstract void startPlay();
    protected abstract void endPlay();
    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
