package com.example.study.design_pattern.builder;

public class Director {
    private IBuilder iBuilder;

    public Director(IBuilder iBuilder) {
        this.iBuilder = iBuilder;
    }

    public Computer createComputer(String cpu,String hardDisk,String mainBoard,String memory){
        // 具体的工作是装机工去做
        this.iBuilder.createMainBoard(mainBoard);
        this.iBuilder.createCpu(cpu) ;
        this.iBuilder.createMemory(memory);
        this.iBuilder.createhardDisk(hardDisk);
        return this.iBuilder.createComputer() ;
    }

}
