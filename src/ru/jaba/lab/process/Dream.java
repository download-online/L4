package ru.jaba.lab.process;

import ru.jaba.lab.*;

public class Dream extends Circumstances {

    public Dream(){
        super("сон");
    }
    @Override
    public String isDirection() {
        return "в сон";
    }
    @Override
    public String isLocation() {
        return "во сне";
    }
}
