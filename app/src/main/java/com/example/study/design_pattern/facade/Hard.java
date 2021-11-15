package com.example.study.design_pattern.facade;

public class Hard {
    private static Hard hard = new Hard();
    public static Hard getInstance() {
        return hard;
    }

    public void open() {
        System.out.println("打开Hard");
    }

    public void down() {
        System.out.println("关闭Hard");
    }
}
