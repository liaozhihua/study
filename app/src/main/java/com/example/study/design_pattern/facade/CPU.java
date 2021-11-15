package com.example.study.design_pattern.facade;

public class CPU {
    private static CPU cpu = new CPU();
    public static CPU getInstance() {
        return cpu;
    }

    public void open() {
        System.out.println("打开CPU");
    }

    public void down() {
        System.out.println("关闭CPU");
    }
}
