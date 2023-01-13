package ru.jaba.lab;

public class Things extends NamedAmountable implements Visible{
    public Things(String name){
        super(name, Amount.PLURAL);
    }
}
