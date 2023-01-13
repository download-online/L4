package ru.jaba.lab;

public class PhysicalObject extends NamedAmountable implements Visible, Visitable{
    public PhysicalObject(String name){
        super(name);
    }
    public PhysicalObject(String name, Amount amount) {
        super(name, amount);
    }

    public Action skipAction(Action action) {
        Action skip = new Action(this,"не будет",ActionType.SKIP);
        return skip.combine(action, false);
    }

    public String isLocation() {return "";};
    public String isDirection() {return "";};
}
