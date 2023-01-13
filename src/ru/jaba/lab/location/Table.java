package ru.jaba.lab.location;

import ru.jaba.lab.PhysicalObject;
import ru.jaba.lab.Process;

public class Table extends PhysicalObject {
    public Table(String name){
        super(name);
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
