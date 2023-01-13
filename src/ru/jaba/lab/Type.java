package ru.jaba.lab;

public enum Type {
    NORMAL(""),
    LUNAR("лунный");
    private final String text;
    Type(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
