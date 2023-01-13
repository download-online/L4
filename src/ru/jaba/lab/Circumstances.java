package ru.jaba.lab;

abstract public class Circumstances extends Named{

    public Circumstances(String name){
        super(name);
    }
    abstract public String isDirection();
    abstract public String isLocation();

}
