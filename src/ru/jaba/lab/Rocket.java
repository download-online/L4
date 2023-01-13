package ru.jaba.lab;

public class Rocket extends Named implements Visible {
    public Rocket() {
        super("ракета");
    }
    public String describe() {
        return "космическую ракету";
    }


}
