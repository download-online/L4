package ru.jaba.lab;

import java.util.Objects;

public class Named {
    private final String name;
    private String nameCollapsed;

    public Named(String name){
        this.name = name;
        this.nameCollapsed = name;
    }

    public String getName(){
        return name;
    }
    public String getCollapsedName() {return nameCollapsed;}

    public void setCollapsedName(String nameCollapsed){ this.nameCollapsed = nameCollapsed;}

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
