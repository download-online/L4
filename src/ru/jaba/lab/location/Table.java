package ru.jaba.lab.location;

import ru.jaba.lab.Circumstances;

public class Table extends Circumstances {
    public Table(){
        super("стол");
    }
    @Override
    public String isDirection() {
        return "на стол";
    }
    @Override
    public String isLocation() {
        return "на столе";
    }
}
