package com.example.study.design_pattern.builder;

public class CoolBuilder implements IBuilder{
    private Computer computer = new Computer();
    @Override
    public void createMainBoard(String mainBoard) {
        computer.setCpu("cool:"+mainBoard);
    }

    @Override
    public void createCpu(String cpu) {
        computer.setCpu("cool:"+cpu);
    }

    @Override
    public void createhardDisk(String hardDisk) {
        computer.setCpu("cool:"+hardDisk);
    }

    @Override
    public void createMemory(String memory) {
        computer.setCpu("cool:"+memory);
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
