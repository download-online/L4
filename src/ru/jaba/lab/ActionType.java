package ru.jaba.lab;

public enum ActionType {
    GO("идти"), SKIP("не делать"), REALIZE("осознать"), SLEEP("спать"), SEE("увидеть"), COMBINED("совместить действия");
    private final String text;
    ActionType(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
