package ru.jaba.lab;

public enum Preposition {
    TO("к"),
    USING("с помощью"),
    INTO("в"),
    INSTEAD("вместо"),
    WITH("с"),
    FOR("для"),
    ON("на"),


    ;
    private String text;
    Preposition(String text) {
        this.text = text+" ";
    }

    @Override
    public String toString() {
        return text;
    }
}
