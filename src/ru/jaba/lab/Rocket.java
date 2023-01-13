package ru.jaba.lab;

public class Rocket extends PhysicalObject implements Visible {
    public Rocket(String name){
        super(name);
    }
    public String describe() {
        return "космическую ракету";
    }

    Shortie shortie = new Shortie("пилот") {
        @Override
        public String toString() {
            return "пилот ракеты";
        }
    };

}
