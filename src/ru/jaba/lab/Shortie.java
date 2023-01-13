package ru.jaba.lab;

import java.util.Objects;

public class Shortie extends NamedAmountable implements Visible{
    private Visitable place;
    private Visitable placePrevious;
    final private Type type;

    public Shortie(String name) {
        super(name);
        type = Type.NORMAL;
    }
    public Shortie(String name, Amount amount, Type type) {
        super(name,amount);
        this.type = type;
    }

    public Action go(Visitable direction, MovementType type) {
        String verbSingular = "пришёл ";
        String verbPlural = "пришли ";
        if (type == MovementType.leave) {
            verbSingular = "уехал ";
            verbPlural = "уехали ";
        } else if (type == MovementType.appear){
            verbSingular = "явился ";
            verbPlural = "явились ";
        }
        placePrevious = place;
        place = direction;
        return new Action(this,(getAmount() == Amount.PLURAL ? verbPlural : verbSingular) + direction.isDirection(), ActionType.GO);
    }
    public Action go() {
        placePrevious = place;
        place = null;
        return new Action(this,(getAmount() == Amount.PLURAL ? "исчезли" : "исчез"),ActionType.GO);
    }

    public Action sleep() {
        return new Action(this,(getAmount() == Amount.PLURAL ? "погрузились" : "погрузился") + " в сон",ActionType.SLEEP);
    }
    public Action skipAction(Action action) {
        if (action.getType() == ActionType.GO) {
            place = placePrevious;
        }
        action.setSentence("не "+action.getSentence());
        action.setType(ActionType.SKIP);
        return action;
    }
    public Action realize(Action action) {
        String verbSingular;
        String verbPlural;
        Action realisation = new Action(action.getSubject(),action.getSentence(),action.getType());
        if (action.getType()==ActionType.SLEEP) {
            verbSingular = "заметил" + ", как ";
            verbPlural = "заметили" + ", как ";
        } else {
            verbSingular = "понял" + ", что ";
            verbPlural = "поняли" + ", что ";
        }
        if (!action.getSubject().getName().equals(getName())) {
            realisation.setSentence((getAmount()==Amount.PLURAL ? verbPlural : verbSingular) + action.getSubject().getName() + " " + action.getSentence());
            realisation.setSubject(this);
        } else {
            realisation.setSentence((getAmount() == Amount.PLURAL ? verbPlural : verbSingular) + action.getSentence());
        }
        realisation.setType(ActionType.REALIZE);
        return realisation;
    }

    public Action see(Visible vision) {
        return new Action(this,((getAmount() == Amount.PLURAL) ? "увидели" : "увидел")+" "+vision.describe(),ActionType.SEE);
    }

    public Action see(Visible[] vision, Circumstances where) {
        String description = "";
        for (int i=0; i<vision.length; i++) {
            Visible image = vision[i];
            description += " " + image.describe();
            if (i<vision.length-1) {
                description += ", и";
                if (vision.length > 3 && i == vision.length-2) {
                    description += " ещё";
                }
            }
        }
        return new Action(this,((getAmount() == Amount.PLURAL)?"увидели":"увидел")+" "+where.isLocation()+description,ActionType.SEE);
    }


    public Type getType() {
        return type;
    }

    public String describe(){
        String nameForm = ((getAmount() == Amount.PLURAL)?"коротышек":"коротышку");
        String typeForm = "";

        if (getType() == Type.LUNAR){
            typeForm = ((getAmount() == Amount.PLURAL)?"лунных":"лунного");
        }
        return String.format("%s %s",typeForm,nameForm);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        Shortie other = (Shortie)otherObject;
        return type == other.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getAmount(),type);
    }
}
