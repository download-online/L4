package ru.jaba.lab.location;

import ru.jaba.lab.PhysicalObject;
import ru.jaba.lab.Process;
import ru.jaba.lab.Visitable;

public class Room extends PhysicalObject implements Visitable {
    public Room(String name) {
        super(name);
    }
    @Override
    public String isDirection() {
        return "в комнату";
    }
    @Override
    public String isLocation() {
        return "в комнате";
    }
}
