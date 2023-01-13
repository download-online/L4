package ru.jaba.lab.process;

import ru.jaba.lab.Process;
import ru.jaba.lab.Visitable;

public class Breakfast extends Process implements Visitable {
    public Breakfast(String name) {
        super(name);
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
