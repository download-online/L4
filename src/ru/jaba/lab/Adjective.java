package ru.jaba.lab;

public enum Adjective {

    HUGE_S("огромная"),
    HUGE_T("огромные"),
    ENORMOUS("огромнейший"),
    BIG("большая"),
    LASTING("длительная"),
    SPACE("космическое"),
    LUNAR("лунный"),
    NORMAL(""),
    LONG("долговязый")

    ;


    private final String text;
    Adjective(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
