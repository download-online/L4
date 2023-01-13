package ru.jaba.lab;

public enum Pronoun {
    HE("он","его","его","нему","им","нём"), SHE("она","её","её","ней","ей","ней"), THEY("они","них","их","им","ими","них");
    private final String nominative, genetive, accusative, dative, instrumental, prepositional;
    Pronoun(String nominative,String genetive, String accusative, String dative, String instrumental, String prepositional) {

        this.nominative = nominative;
        this.genetive = genetive;
        this.accusative = accusative;
        this.dative = dative;
        this.instrumental = instrumental;
        this.prepositional = prepositional;

    }

    public String getNominative() {return nominative;}
    public String getGenetive() {return genetive;}
    public String getAccusative() {return accusative;}
    public String getDative() {return dative;}
    public String getInstrumental() {return instrumental;}
    public String getPrepositional() {return prepositional;}

    @Override
    public String toString() {
        return "text";
    }
}
