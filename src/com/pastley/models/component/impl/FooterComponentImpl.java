package com.pastley.models.component.impl;

import java.util.ArrayList;

import com.pastley.models.component.FooterComponent;
import com.pastley.models.component.ItemComponent;
import com.pastley.util.Pastley;

public class FooterComponentImpl {

	public static void init(FooterComponent footer) {
		footer.setCategories(new ArrayList<>());
		footer.setServices(new ArrayList<>());
		footer.setSocial(new ArrayList<>());
	}

	public static void fill(FooterComponent footer) {
		init(footer);
		fillServicies(footer);
		fillSocial(footer);
	}

	public static void fillServicies(FooterComponent footer) {
		Pastley.addItem(new ItemComponent<String>("Iniciar Sesión", "login?faces-redirect=true", "Iniciar Sesión",
				"pi pi-user"), footer.getServices());
		Pastley.addItem(new ItemComponent<String>("Contacto", "contact?faces-redirect=true", "Contacto", "pi pi-user"),
				footer.getServices());
		Pastley.addItem(new ItemComponent<String>("Carrito", "cart?faces-redirect=true", "Carrito", "pi pi-user"),
				footer.getServices());
	}

	public static void fillSocial(FooterComponent footer) {
		Pastley.addItem(new ItemComponent<String>(null, "login?faces-redirect=true", "Facebook", "pi pi-facebook"),
				footer.getSocial());
		Pastley.addItem(new ItemComponent<String>(null, "login?faces-redirect=true", "Twitter", "pi pi-twitter"),
				footer.getSocial());
		Pastley.addItem(new ItemComponent<String>(null, "login?faces-redirect=true", "Mensaje", "pi pi-send"),
				footer.getSocial());
	}
}
