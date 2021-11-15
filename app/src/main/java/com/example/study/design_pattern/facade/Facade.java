package com.example.study.design_pattern.facade;

public class Facade {
    private CPU cpu;
    private Memory memory;
    private Hard hard;
    public Facade() {
        super();
        this.cpu = CPU.getInstance();
        this.memory = Memory.getInstance();
        this.hard = Hard.getInstance();
    }

    //封装所有打开设备
    public void open() {
        cpu.open();
        hard.open();
        memory.open();
    }
    //封装所有关闭设备
    public void down() {
        cpu.down();
        hard.down();
        memory.down();
    }
}
