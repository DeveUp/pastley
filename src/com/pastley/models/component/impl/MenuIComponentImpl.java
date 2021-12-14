package com.pastley.models.component.impl;

import java.util.ArrayList;

import com.pastley.models.component.ItemComponent;
import com.pastley.models.component.MenuIComponent;
import com.pastley.util.Pastley;

public class MenuIComponentImpl {

	@SuppressWarnings("unchecked")
	public static void init(@SuppressWarnings("rawtypes") MenuIComponent menu) {
		menu.setOptions(new ArrayList<>());
		menu.setLinks(new ArrayList<>());
		menu.setLevel(new ArrayList<>());
		menu.setLevelII(new ArrayList<>());
	}

	public static void fill(@SuppressWarnings("rawtypes") MenuIComponent menu) {
		init(menu);
		fillOptions(menu);
		fillLinks(menu);
	}

	@SuppressWarnings("unchecked")
	public static void fillOptions(@SuppressWarnings("rawtypes") MenuIComponent menu) {
		Pastley.addItem(new ItemComponent<String>("lsy-btn-bars", "fas fa-bars", true), menu.getOptions());
		Pastley.addItem(new ItemComponent<String>("lsy-btn-close", "fas fa-times", true), menu.getOptions());
	}

	@SuppressWarnings("unchecked")
	public static void fillLinks(@SuppressWarnings("rawtypes") MenuIComponent menu) {
		Pastley.addItem(new ItemComponent<String>("Contacto", "contact.xhtml", null), menu.getLinks());
		Pastley.addItem(new ItemComponent<String>("Carrito", "cart.xhtml", null), menu.getLinks());
		Pastley.addItem(new ItemComponent<String>("Iniciar Sesión", "login.xhtml", "pi pi-user"), menu.getLinks());
	}
}
