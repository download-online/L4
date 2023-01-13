package ru.jaba.lab;

public enum Connection {
    AND("и "),
    A("а "),
    A_WHEN("а когда "),
    NIHIL("");

    private final String text;

    Connection(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
