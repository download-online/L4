package ru.jaba.lab.location;

import ru.jaba.lab.Heavyweight;
import ru.jaba.lab.PhysicalObject;
import ru.jaba.lab.Visible;
import ru.jaba.lab.Visitable;

public class Moon extends Heavyweight implements Visitable, Visible {
    public Moon(String name) {
        super(name);
    }

    public class Subsurface {
        public String getSubsurfaceDescription() {
            return Moon.this.getPronoun().getGenetive()+" недра";
        }
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
