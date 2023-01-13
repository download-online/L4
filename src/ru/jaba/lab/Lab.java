package ru.jaba.lab;

import ru.jaba.lab.location.*;
import ru.jaba.lab.process.*;

import java.util.Objects;

public class Lab {
	public static void main(String[] args) {
		Shortie smarty = new Shortie("Знайка");
		Dream dream = new Dream();
		Rocket rocket = new Rocket();
		Moon moon = new Moon();
		Shortie lunarShorties = new Shortie("коротышки", Amount.PLURAL,Type.LUNAR);
		Things stuff = new Things();
		Breakfast breakfast = new Breakfast();
		Shortie normalShorties = new Shortie("коротышки", Amount.PLURAL, Type.NORMAL);
		Room room = new Room();
		Table table = new Table();

		SunCity city = new SunCity();
		String text = city.isDirection();
		Note note = new Note(3,text);
		Signature signature = new Signature(smarty);

		Action action1 = smarty.skipAction(smarty.realize(smarty.sleep())).specify("размечтавшись, ");
		Visible[] dreamImages = {rocket, moon, lunarShorties, stuff};
		Action action2 = smarty.see(dreamImages,dream).connect(Connection.AND).collapseSubject();
		Action action3 = smarty.go().specify("наутро ").connect(Connection.A);
		Action action4 = smarty.skipAction(smarty.go(breakfast,MovementType.appear)).collapseSubject();
		Action action5 = normalShorties.go(room,MovementType.come).specify("",""," к нему").connect(Connection.A_WHEN);
		Visible[] stuffOnTable = {note,signature};
		Action action6 = normalShorties.see(stuffOnTable, table);
		Action action7 = action4.combine(action5.combine(action6));
		Action a2 = smarty.go(city,MovementType.leave);
		Action action8 = normalShorties.realize(a2).specify("прочитав записку, "," сразу");
		Action[] Story = new Action[5];
		Story[0] = action1;
		Story[1] = action2;
		Story[2] = action3;
		Story[3] = action7;
		Story[4] = action8;

		for (Action Sentence : Story) {
			System.out.print(Sentence);
		}
	}
}
