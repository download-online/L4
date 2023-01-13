package ru.jaba.lab;

public enum MovementType {
    come("прийти"), leave("уйти"), appear("явиться");
    private final String text;
    MovementType(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
