package ru.jaba.lab;

public enum Connection {
    AND("и "),
    A("а "),
    A_WHEN("а когда "),
    THERE_WHEN("вот когда "),
    NOTHING(""),
    THAT("что "),
    IF("если "),
    THEN("то "),
    TO("чтоб "),
    HOW("как "),
    DASH("— "),
    BECAUSE("ведь ")
    ;


    private final String text;

    Connection(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
