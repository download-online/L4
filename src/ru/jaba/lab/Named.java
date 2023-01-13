package ru.jaba.lab;

import java.util.Objects;

public class Named {
    private final String name;
    private Pronoun pronoun;
    private Adjective adjective = Adjective.NORMAL;

    {
        pronoun = Pronoun.HE;
    }

    public Named(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public Pronoun getPronoun() {return pronoun;}
    public String getCollapsedName() {return pronoun.getNominative();}


    public void setPronoun(Pronoun pronoun){ this.pronoun = pronoun;}
    public void setAdjective(Adjective adjective) {this.adjective = adjective;}

    public Action define() {
        return new Action(this,"— это "+adjective+" "+getDefinition(), ActionType.DEFINE);
    }

    public String getDefinition() {return "понятие";}
    public Adjective getAdjective() {return adjective;}

    @Override
    public String toString() {
        return name;
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
        Named other = (Named)otherObject;
        return Objects.equals(name, other.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
