package ru.jaba.lab.location;

import ru.jaba.lab.PhysicalObject;
import ru.jaba.lab.Process;
import ru.jaba.lab.Visitable;

public class SunCity extends PhysicalObject implements Visitable {
    public SunCity(String name){
        super(name);
    }
    @Override
    public String isDirection() {
        return "в Солнечный город";
    }
    @Override
    public String isLocation() {
        return "в Солнечном городе";
    }
}
