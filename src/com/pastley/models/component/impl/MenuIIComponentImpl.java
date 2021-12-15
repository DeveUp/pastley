package com.pastley.models.component.impl;

import java.util.ArrayList;

import com.pastley.models.component.ItemComponent;
import com.pastley.models.component.MenuIIComponent;
import com.pastley.util.PastleyVariable;

public class MenuIIComponentImpl {

	public static void init(MenuIIComponent menu) {
		menu.setItems(new ArrayList<>());
	}

	public static void fillItems(MenuIIComponent menu) {
		init(menu);
		menu.getItems()
				.add(new ItemComponent<>(null, "index.xhtml", "Cerrar Sesión", PastleyVariable.PASTLEY_ICON_OUT));
	}
}
