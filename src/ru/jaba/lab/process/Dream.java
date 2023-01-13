package ru.jaba.lab.process;

import ru.jaba.lab.Process;

public class Dream extends Process {

    public Dream(String name){
        super(name);
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
