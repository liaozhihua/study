package com.example.study.design_pattern.builder;

//充当了指挥官 抽象建造者 跟具体建造者 还有具体产品的角色
public class StaticComputer {
    private String cpu ; // cpu
    private String hardDisk ; //硬盘
    private String mainBoard ; // 主板
    private String memory ; // 内存

    public StaticComputer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.hardDisk = builder.hardDisk;
        this.mainBoard = builder.mainBoard;
        this.memory = builder.memory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
    //充当的是具体建造者
    public static class ComputerBuilder {
        private String cpu ; // cpu
        private String hardDisk ; //硬盘
        private String mainBoard ; // 主板
        private String memory ; // 内存

        //假设这2个参数是必有项
        public ComputerBuilder(String cpu, String hardDisk) {
            this.cpu = cpu;
            this.hardDisk = hardDisk;
        }


        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }

        public ComputerBuilder setMainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        public ComputerBuilder setMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public StaticComputer create() {
            return new StaticComputer(this);
        }
    }
}
