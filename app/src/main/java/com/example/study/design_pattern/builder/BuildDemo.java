package com.example.study.design_pattern.builder;

/**
 *  内容讲解
 *  https://juejin.cn/post/6844903518449434638 写得非常好 尤其里面有三种写法示例的比较
 *  次要参考 https://zhuanlan.zhihu.com/p/58093669 这种其实主要说的是静态构建者模式 主要是使用上吧 上面那个境界更高 会从设计思想上考虑
 *  -----------------------------------------------
 *
 *  定义： 是创建型的
 *  1、将一个复杂对象得构建跟它的表示分离，使得同样的构造过程可以创建不同的表示，通俗的说就是：建造者模式就是如何一步步构建一个包含多个组成部件的对象，相同的构建过程可以创建不同的产品
 *  作用：
 *  主要是对用户屏蔽了创建的具体细节就能创建出想要的复杂对象
 *  结构：
 *  Builder	接口或抽象类	抽象的建造者，不是必须的
 *  ConcreateBuilder	具体的建造者	可以有多个「因为每个建造风格可能不一样」
 *  Product	普通的类	具体的产品「即被建造的对象」
 *  Director	导演也叫指挥者	统一指挥建造者去建造目标，导演不是必须的
 *  ------
 *  优点：
 *  1、使创建产品的步骤「把创建产品步骤放在不同的方法中，更加清晰直观」和产品本身分离，即使用相同的创建过程要吧创建出不同的产品
 * 2、每个建造者都是独立的互不影响，这样就达到解耦的目的，所以如果想要替换现有的建造者那非常方便，添加一个实现即可。
 * 缺点：
 * 1、只适用于产品具有相同的特点「过程和步骤」，如果产品之间差异非常大，则不适用「使用范围受限」
 * 2、万一那天产品内部发生改变，那多个建造者都要修改，成本太大
 * ---------------------------------------
 * 建造者模式 VS 简单工厂模式
 *
 */
public class BuildDemo {

    public static void main(String[] args) {
        //这种写法是经典建造者模式
        AssemblerBuilder assemblerBuilder = new AssemblerBuilder();
//        CoolBuilder assemblerBuilder = new CoolBuilder();
        Director director = new Director(assemblerBuilder);
        Computer computer = director.createComputer("cpu", "disk", "board", "memory");
//        ------------------------------------------
        //简单写法 也可以看成静态写法？
        StaticComputer staticComputer = new StaticComputer.ComputerBuilder("cpu", "disk").setCpu("cpucoll")
                .setMainBoard("main").setMemory("memory").create();
    }
}
