package com.pastley.models.component.impl;

import java.util.ArrayList;
import java.util.List;

import com.pastley.models.component.CardComponent;

public class CardComponentImpl {

	public static void init(List<CardComponent> cards) {
		cards = new ArrayList<>();
	}

	public static List<CardComponent> fill(List<CardComponent> cards) {
		cards = new ArrayList<>();
		cards.add(new CardComponent("login.xhtml", "30000", "Clientes", false, new ArrayList<>(), "lsy-bg-c-success",
				"", "pi pi-user"));
		cards.add(new CardComponent("login.xhtml", "30000", "Cajeros", false, new ArrayList<>(), "", "", "pi pi-user"));
		cards.add(new CardComponent("login.xhtml", "30000", "Productos", false, new ArrayList<>(), "lsy-bg-c-fatal", "",
				"pi pi-user"));
		cards.add(new CardComponent("login.xhtml", "30000", "Ventas", true, new ArrayList<>(), "lsy-bg-c-warning", "",
				"pi pi-user"));
		cards.add(new CardComponent("login.xhtml", "30000", "Contacto", true, new ArrayList<>(), "lsy-bg-c-info", "",
				"pi pi-user"));
		return cards;
	}
}
