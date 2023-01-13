package ru.jaba.lab;

import java.util.Objects;

public class NamedAmountable extends Named{
    private final Amount amount;

    public NamedAmountable(String name){
        super(name);
        this.amount = Amount.SINGLE;
    }
    public NamedAmountable(String name, Amount amount) {
        super(name);
        this.amount = amount;
        setPronoun((this.amount == Amount.SINGLE) ? Pronoun.HE : Pronoun.THEY);
    }

    public Amount getAmount(){
        return amount;
    }

    @Override
    public String getDefinition() {
        return "исчисляемое";
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
        if (!super.equals(otherObject)) {
            return false;
        }
        NamedAmountable other = (NamedAmountable)otherObject;
        return amount == other.amount;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(),amount);
    }
}
