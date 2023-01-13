package ru.jaba.lab;

import javafx.geometry.Pos;
import ru.jaba.lab.location.Moon;
import ru.jaba.lab.location.Room;
import ru.jaba.lab.location.SunCity;
import ru.jaba.lab.location.Table;
import ru.jaba.lab.process.Breakfast;
import ru.jaba.lab.process.Dream;

public class Lab {
	public static void main(String[] args) {

		Shorties.shortiesCounter counter = new Shorties.shortiesCounter();
		//System.out.println(counter.getShortiesCount());
		//Выведет 0, не требуется создание объекта Shorties

		Shortie smarty = new Shortie("Знайка");
		smarty.setAdjective(Adjective.LONG); //checked исключение ShortieIsLongException

		//System.out.println(counter.getShortiesCount());
		//Выведет 1

		Dream dream = new Dream("сон");
		Rocket rocket = new Rocket("ракета");
		//System.out.println(rocket.shortie);
		rocket.setAdjective(Adjective.BIG);
		rocket.setPronoun(Pronoun.SHE);
		Moon moon = new Moon("Луна");
		Moon.Subsurface subsurface = moon.new Subsurface();

		moon.setPronoun(Pronoun.SHE);
		Shorties lunarShorties = new Shorties("лунные коротышки", Amount.PLURAL);
		lunarShorties.setAdjective(Adjective.LUNAR);
		Things stuff = new Things("много разных интересных вещей");
		Breakfast breakfast = new Breakfast("завтрак");
		Shorties normalShorties = new Shorties("коротышки", Amount.PLURAL);
		Shorties passengers = new Shorties("пассажиры", Amount.PLURAL);
		Room room = new Room("комната");
		Table table = new Table("стол");
		Food food = new Food("пища");

		SunCity city = new SunCity("Солнечный город");
		String text = city.isDirection();
		Note note = new Note(3,text);
		Signature signature = new Signature(smarty);

		Heavyweight heavyweight = new Heavyweight("тяжести",Amount.PLURAL);
		heavyweight.setAdjective(Adjective.HUGE_T);
		Mountains mountains = new Mountains("горы");
		FuelReserve fuelReserve = new FuelReserve("запас топлива");
		fuelReserve.setAdjective(Adjective.ENORMOUS);
		Fuel fuel = new Fuel("топливо");
		Travel travel = new Travel("путешествие");
		travel.setAdjective(Adjective.SPACE);
		Expedition expedition = new Expedition("экспедиция");
		expedition.setAdjective(Adjective.LASTING);

		Visible[] dreamImages = {rocket, moon, lunarShorties, stuff};
		Action[] Story = new Action[12];

		Force zeroGravity = new Force("невесомость");
		zeroGravity.setAdjective(Adjective.HUGE_S);
		zeroGravity.setPronoun(Pronoun.SHE);

		Action action1_0 = zeroGravity.define();
		Action action1_1 = new ActionImpersonal(ActionType.APPROACH).addComplement(Preposition.TO+zeroGravity.getPronoun().getDative()).connect(Connection.HOW);
		Action action1_2 = new ActionImpersonal(ActionType.KNOW).connect(Connection.IF);
		Action action1_3 = smarty.think().collapseSubject().connect(Connection.DASH).simplify();
		Action action1_4 = action1_2.combine(action1_1,true);
		Action action1_5 = action1_0.combine(action1_4,true);
		Action action1 = action1_5.combine(action1_3,false);
		Story[0] = action1;

		Action action2_0 = new ActionImpersonal(ActionType.POSSIBLE).connect(Connection.DASH).specify(Preposition.USING+zeroGravity.getName());
		Action action2_1 = new ActionImpersonal(ActionType.LIFT);
		Action action2_2 = new ActionImpersonal(ActionType.PASS).addComplement(heavyweight.getAdjective()+" "+heavyweight.getName()).connect(Connection.AND);
		Action action2_3 = action2_1.combine(action2_2,false);
		Action action2 = action2_0.combine(action2_3,false);
		Story[1] = action2;

		Action action3_0 = new ActionImpersonal(ActionType.POSSIBLE);
		Action action3_1 = new ActionImpersonal(ActionType.COLLAPSE).addComplement(mountains.getName()).specify("буквально ");
		Action action3_2 = new ActionImpersonal(ActionType.TURN).connect(Connection.AND).specify("вверх ногами ");
		Action action3_3 = action3_1.combine(action3_2,false);
		Action action3 = action3_0.combine(action3_3,false);
		Story[2] = action3;

		Action action4_0 = new ActionImpersonal(ActionType.POSSIBLE);
		Action action4_1 = new ActionImpersonal(ActionType.BUILD).addComplement(rocket.getAdjective()+" "+rocket.getName());
		Action action4_2 = new ActionImpersonal(ActionType.FLY).addComplement(Preposition.ON+rocket.getPronoun().getPrepositional()+" "+Preposition.INTO+travel.getAdjective()+" "+travel).connect(Connection.AND);
		Action action4_3 = action4_1.combine(action4_2,false);
		Action action4 = action4_0.combine(action4_3,false);
		Story[3] = action4;

		Action action5_0 = new ActionImpersonal(ActionType.ACCELERATE).addComplement(rocket.getName()).connect(Connection.TO).specify("",""," до нужной скорости");
		Action action5_1 = new ActionImpersonal(ActionType.TAKE).addComplement(fuelReserve.getAdjective()+" "+fuelReserve.getName());
		Action action5_2 = new ActionImpersonal(ActionType.OBLIGATE);
		Action action5_3 = action5_2.combine(action5_1,false);
		Action action5 = action5_0.combine(action5_3,true).simplify().connect(Connection.BECAUSE).specify("сейчас, ");
		Story[4] = action5;

		Action action6_0 = new ActionImpersonal(ActionType.WEIGHT).specify(Amount.NULL.toString()+" ");
		Action action6_1 = rocket.skipAction(action6_0).connect(Connection.IF).specify("же ");
		Action action6_2 = new ActionImpersonal(ActionType.NEED).addComplement(Amount.FEW.toString()).specify(fuel.getName()+" ").connect(Connection.THEN);
		Action action6_3 = new ActionImpersonal(ActionType.POSSIBLE).connect(Connection.AND).specify(Preposition.INSTEAD+fuelReserve.getName()+" ");
		Action action6_4 = new ActionImpersonal(ActionType.WILL);
		Action action6_5 = new ActionImpersonal(ActionType.BRING).addComplement(Amount.MORE+" "+passengers+" "+Connection.AND+Amount.MORE+" "+ food+" "+Preposition.FOR+passengers.getPronoun().getGenetive());
		Action action6_6 = action6_3.combine(action6_4,false);
		Action action6_7 = action6_6.combine(action6_5,false);
		Action action6_8 = action6_1.combine(action6_2, true);
		Action action6 = action6_8.combine(action6_7, true);
		Story[5] = action6;

		Action action7_0 = new ActionImpersonal(ActionType.COMMIT).addComplement(expedition.getAdjective()+" "+expedition).specify("",""," "+moon.isDirection());
		Action action7_1 = new ActionImpersonal(ActionType.GET_INTO).addComplement(Preposition.INTO+subsurface.getSubsurfaceDescription());
		Action action7_2 = new ActionImpersonal(ActionType.MEET).addComplement(Preposition.WITH+lunarShorties.getName()).connect(Connection.AND).specify("может быть, даже ");
		Action action7_3 = action7_0.combine(action7_1,true);
		Action action7_4 = action7_3.combine(action7_2,true);
		Action action7_5 = new ActionImpersonal(ActionType.WILL).combine(action7_4,false);
		Action action7 = new ActionImpersonal(ActionType.POSSIBLE).combine(action7_5,false).connect(Connection.THERE_WHEN);
		Story[6] = action7;

		Action action8 = smarty.skipAction(smarty.notice(smarty.sleep())).specify("размечтавшись, ");
		Action action9 = smarty.see(dreamImages,dream).connect(Connection.AND).collapseSubject();
		Action action10 = smarty.disappear().specify("наутро ").connect(Connection.A);
		Action action11 = smarty.skipAction(smarty.go(breakfast,MovementType.appear)).collapseSubject();
		Action action12 = normalShorties.go(room,MovementType.come).specify("",""," "+Preposition.TO+smarty.getPronoun().getDative()).connect(Connection.A_WHEN);
		Visible[] stuffOnTable = {note,signature};
		Action action13 = normalShorties.see(stuffOnTable, table);
		Action action14 = action11.combine(action12.combine(action13, true),true);
		Action a2 = smarty.go(city,MovementType.leave);
		Action action15 = normalShorties.realize(a2).specify("прочитав записку, "," сразу");
		Story[7] = action8;
		Story[8] = action9;
		Story[9] = action10;
		Story[10] = action14;
		Story[11] = action15;

		for (Action Sentence : Story) {
			System.out.print(Sentence);
		}

	}
}
