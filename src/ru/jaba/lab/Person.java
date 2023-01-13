package ru.jaba.lab;

import java.util.Objects;

public class Person extends NamedAmountable {
    private Visitable place;
    private Visitable placePrevious;


    public Person(String name) {
        super(name);
    }
    public Person(String name, Amount amount) {
        super(name,amount);
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
    public Action disappear() {
        ActionType type = ActionType.DISAPPEAR;
        String verbSingular = type.getSingleForm();
        String verbPlural = type.getPluralForm();
        placePrevious = place;
        place = null;
        return new Action(this,(getAmount() == Amount.PLURAL ? verbPlural : verbSingular),type);
    }

    public Action sleep() {
        ActionType type = ActionType.SLEEP;
        String verbSingular = type.getSingleForm();
        String verbPlural = type.getPluralForm();
        return new Action(this,(getAmount() == Amount.PLURAL ? verbPlural : verbSingular),type);
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
        ActionType type = ActionType.REALIZE;
        String verbSingular = type.getSingleForm() + ", что ";
        String verbPlural = type.getPluralForm() + ", что ";
        Action realisation = new Action(action.getSubject(),action.getSentence(),action.getType());
        if (!action.getSubject().getName().equals(getName())) {
            realisation.setSentence((getAmount()==Amount.PLURAL ? verbPlural : verbSingular) + action.getSubject().getName() + " " + action.getSentence());
            realisation.setSubject(this);
        } else {
            realisation.setSentence((getAmount() == Amount.PLURAL ? verbPlural : verbSingular) + action.getSentence());
        }
        realisation.setType(type);
        return realisation;
    }
    public Action notice(Action action) {
        ActionType type = ActionType.NOTICE;
        String verbSingular = type.getSingleForm() + ", как ";
        String verbPlural = type.getPluralForm() + ", как ";
        Action noticed = new Action(action.getSubject(),action.getSentence(),action.getType());
        if (!action.getSubject().getName().equals(getName())) {
            noticed.setSentence((getAmount()==Amount.PLURAL ? verbPlural : verbSingular) + action.getSubject().getName() + " " + action.getSentence());
            noticed.setSubject(this);
        } else {
            noticed.setSentence((getAmount() == Amount.PLURAL ? verbPlural : verbSingular) + action.getSentence());
        }
        noticed.setType(type);
        return noticed;
    }

    public Action see(Visible vision) {
        ActionType type = ActionType.SEE;
        String verbSingular = type.getSingleForm();
        String verbPlural = type.getPluralForm();
        return new Action(this, ((getAmount() == Amount.PLURAL) ? verbPlural : verbSingular) + " " + vision.describe(), type);
    }

    public Action see(Visible[] vision, Visitable where) {
        ActionType type = ActionType.SEE;
        String verbSingular = type.getSingleForm();
        String verbPlural = type.getPluralForm();
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
        return new Action(this,((getAmount() == Amount.PLURAL)? verbPlural : verbSingular)+" "+where.isLocation()+description,type);
    }

    public Action think() {
        ActionType type = ActionType.THINK;
        String verbSingular = type.getSingleForm();
        String verbPlural = type.getPluralForm();
        return new Action(this,(getAmount() == Amount.PLURAL ? verbPlural : verbSingular), type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getAmount());
    }
}
