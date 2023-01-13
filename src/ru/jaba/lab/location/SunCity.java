package ru.jaba.lab.location;

import ru.jaba.lab.Circumstances;
import ru.jaba.lab.Visitable;

public class SunCity extends Circumstances implements Visitable {
    public SunCity(){
        super("Солнечный город");
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
