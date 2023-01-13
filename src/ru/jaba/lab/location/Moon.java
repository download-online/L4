package ru.jaba.lab.location;

import ru.jaba.lab.Circumstances;
import ru.jaba.lab.Visitable;
import ru.jaba.lab.Visible;

public class Moon extends Circumstances implements Visitable, Visible {
    public Moon() {
        super("Луна");
    }
    @Override
    public String isDirection() {
        return "на Луну";
    }
    @Override
    public String isLocation() {
        return "на Луне";
    }
    public String describe() {
        return "Луну";
    }
}
