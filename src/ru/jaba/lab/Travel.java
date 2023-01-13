package ru.jaba.lab;

public class Travel extends Process {
    public Travel(String name) {
        super(name);
    }
    @Override
    public String isDirection() {
        return "в путешествие";
    }
    @Override
    public String isLocation() {
        return "в путешествии";
    }
}
