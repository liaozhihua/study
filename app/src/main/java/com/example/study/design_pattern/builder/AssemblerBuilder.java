package com.example.study.design_pattern.builder;

public class AssemblerBuilder implements IBuilder{
    private Computer computer = new Computer();
    @Override
    public void createMainBoard(String mainBoard) {
        computer.setCpu(mainBoard);
    }

    @Override
    public void createCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void createhardDisk(String hardDisk) {
        computer.setCpu(hardDisk);
    }

    @Override
    public void createMemory(String memory) {
        computer.setCpu(memory);
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
