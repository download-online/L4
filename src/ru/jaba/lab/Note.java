package ru.jaba.lab;

import java.util.Objects;

public class Note extends Named implements Visible{
    private int wordAmount;
    private String words;

    public Note(int wordAmount, String words) {
        super("записка");
        this.wordAmount = wordAmount;
        this.words = words;
    }

    public String describe() {
        return String.format("записку, в которой было всего %d слова: \"%s\"",wordAmount,words);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Note other = (Note)otherObject;
        return Objects.equals(words, other.words)&&(wordAmount==other.wordAmount);
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(),words,wordAmount);
    }
}
