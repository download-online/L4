package ru.jaba.lab;

public enum Amount {
    SINGLE("один"), PLURAL("много");
    private final String text;
    Amount(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
