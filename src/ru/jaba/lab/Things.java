package ru.jaba.lab;

public class Things extends NamedAmountable implements Visible{
    public Things() {
        super("много разных интересных вещей", Amount.PLURAL);
    }
}
