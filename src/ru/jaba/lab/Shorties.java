package ru.jaba.lab;

import java.util.Objects;

public class Shorties extends Person implements Visible {

    private static int shortiesCount = 0;

    public static class shortiesCounter {
        public int getShortiesCount() {
            return shortiesCount;
        }
    }

    public Shorties(String name) {
        super(name);
        shortiesCount+=1;
    }

    public Shorties(String name,Amount amount) {
        super(name,amount);
        shortiesCount+=1;
    }



    public String describe(){
        String nameForm = ((getAmount() == Amount.PLURAL)?"коротышек":"коротышку");
        String typeForm = "";

        if (getAdjective() == Adjective.LUNAR){
            typeForm = ((getAmount() == Amount.PLURAL)?"лунных":"лунного");
        }
        return String.format("%s %s",typeForm,nameForm);
    }

    public void setShortieAdjective(Adjective adjective) throws ShortieIsLongException {
        if (adjective == Adjective.LONG) {
            throw new ShortieIsLongException("Long shortie cannot exist");
        }
        super.setAdjective(adjective);
    }

    @Override
    public void setAdjective(Adjective adjective) {
        try {
            setShortieAdjective(adjective);
        } catch (ShortieIsLongException e) {
            System.out.println("Long shortie cannot exist!");
        }

    }



    @Override
    public int hashCode() {
        return Objects.hash(getName(),getAmount());
    }

}
