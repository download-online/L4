package ru.jaba.lab;

public class ActionImpersonal extends Action {
    public ActionImpersonal(String sentence, ActionType type) {
        super(null, sentence, type);
        hideSubject();
    }
    public ActionImpersonal(ActionType type) {
        super(null, type.getInfinitive(), type);
        hideSubject();
    }

    public ActionImpersonal addComplement(String text) {
        setSentence(getSentence() + " " + text);
        return this;
    }
}
