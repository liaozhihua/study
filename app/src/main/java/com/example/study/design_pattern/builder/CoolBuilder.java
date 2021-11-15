package com.example.study.design_pattern.builder;

public class CoolBuilder implements IBuilder{
    private Computer computer = new Computer();
    @Override
    public void createMainBoard(String mainBoard) {
        computer.setMainBoard("cool:"+mainBoard);
    }

    @Override
    public void createCpu(String cpu) {
        computer.setCpu("cool:"+cpu);
    }

    @Override
    public void createhardDisk(String hardDisk) {
        computer.setHardDisk("cool:"+hardDisk);
    }

    @Override
    public void createMemory(String memory) {
        computer.setMemory("cool:"+memory);
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
