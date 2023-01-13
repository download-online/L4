package ru.jaba.lab;

import java.util.Objects;

public class Signature extends Named implements Visible{
    Shortie author;

    public Signature(){
        super("подпись");
    }
    public Signature(Shortie author){
        super("подпись");
        this.author = author;
    }
    public String describe() {
        return String.format("подпись: \"%s\"",author.getName());
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
        Signature other = (Signature)otherObject;
        return Objects.equals(getName(), other.getName())&&(author.equals(other.author));
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(),author);
    }
}
