package ru.jaba.lab;

abstract public class Process extends Named implements Visitable {

    public Process(String name){
        super(name);
    }
    abstract public String isDirection();
    abstract public String isLocation();
}
