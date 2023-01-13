package ru.jaba.lab.process;

import ru.jaba.lab.Circumstances;
import ru.jaba.lab.Visitable;

public class Breakfast extends Circumstances implements Visitable {
    public Breakfast(){
        super("завтрак");
    }
    @Override
    public String isDirection() {
        return "к завтраку";
    }
    @Override
    public String isLocation() {
        return "во время завтрака";
    }
}
