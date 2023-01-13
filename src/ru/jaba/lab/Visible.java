package ru.jaba.lab;

public interface Visible {
    default String describe() {
        return toString();
    }
}
