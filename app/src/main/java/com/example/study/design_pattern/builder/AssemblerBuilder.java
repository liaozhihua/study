package com.example.study.design_pattern.builder;

public class AssemblerBuilder implements IBuilder{
    private Computer computer = new Computer();
    @Override
    public void createMainBoard(String mainBoard) {
        computer.setMainBoard(mainBoard);
    }

    @Override
    public void createCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void createhardDisk(String hardDisk) {
        computer.setHardDisk(hardDisk);
    }

    @Override
    public void createMemory(String memory) {
        computer.setMemory(memory);
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
