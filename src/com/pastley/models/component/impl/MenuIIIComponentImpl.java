package com.pastley.models.component.impl;

import java.util.ArrayList;
import java.util.List;

import com.pastley.models.component.BadgeComponent;
import com.pastley.models.component.ItemIIComponent;
import com.pastley.models.component.MenuIIIComponent;
import com.pastley.util.PastleyVariable;

public class MenuIIIComponentImpl {

	public static void init(MenuIIIComponent menu) {
		menu.setItems(new ArrayList<>());
	}

	public static void fillItems(MenuIIIComponent menu) {
		init(menu);
		fillMaintenance(menu);
		fillCompany(menu);
		fillSale(menu);
		fillBuy(menu);
	}

	public static void fillMaintenance(MenuIIIComponent menu) {
		menu.getItems()
				.add(new ItemIIComponent<>(null, true, PastleyVariable.PASTLEY_MENU_TYPE_MAINTENANCE, null, null));
		// Customer
		List<ItemIIComponent<String>> customer = new ArrayList<>();
		customer.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		customer.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems()
				.add(new ItemIIComponent<>(new BadgeComponent("admi", "lsy-bg-c-warning"), false,
						PastleyVariable.PASTLEY_MENU_TYPE_CUSTOMER, null, PastleyVariable.PASTLEY_ICON_TYPE_CUSTOMER,
						customer));
		// Cashier
		List<ItemIIComponent<String>> cashier = new ArrayList<>();
		cashier.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		cashier.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER, null,
				PastleyVariable.PASTLEY_ICON_REGISTER));
		cashier.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_CASHIER, null,
				PastleyVariable.PASTLEY_ICON_TYPE_CASHIER, cashier));
		// Product
		List<ItemIIComponent<String>> product = new ArrayList<>();
		product.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY,
				"pages/product/all.xhtml", PastleyVariable.PASTLEY_ICON_HISTORY));
		product.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER,
				"pages/product/register.xhtml", PastleyVariable.PASTLEY_ICON_REGISTER));
		product.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS,
				"pages/product/index.xhtml", PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_PRODUCT, null,
				PastleyVariable.PASTLEY_ICON_TYPE_PRODUCT, product));
		// Category
		List<ItemIIComponent<String>> category = new ArrayList<>();
		category.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY,
				"pages/category/all.xhtml", PastleyVariable.PASTLEY_ICON_HISTORY));
		category.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS,
				"pages/category/index.xhtml", PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_CATEGORY, null,
				PastleyVariable.PASTLEY_ICON_TYPE_CATEGORY, category));
	}

	public static void fillCompany(MenuIIIComponent menu) {
		menu.getItems().add(new ItemIIComponent<>(new BadgeComponent("admi", "lsy-bg-c-warning"), true,
				PastleyVariable.PASTLEY_MENU_TYPE_COMPANY, null, null));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_COMPANY_INFO,
				"pages/company/index.xhtml", PastleyVariable.PASTLEY_ICON_INFO));
		// PQR
		List<ItemIIComponent<String>> pqr = new ArrayList<>();
		pqr.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		pqr.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER, null,
				PastleyVariable.PASTLEY_ICON_REGISTER));
		pqr.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_PQR, null,
				PastleyVariable.PASTLEY_ICON_TYPE_PQR, pqr));
		// Contact
		List<ItemIIComponent<String>> contact = new ArrayList<>();
		contact.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		contact.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_RESPONSE, null,
				PastleyVariable.PASTLEY_ICON_RESPONSE));
		contact.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_CONTACT, null,
				PastleyVariable.PASTLEY_ICON_TYPE_CONTACT, contact));
	}

	public static void fillSale(MenuIIIComponent menu) {
		menu.getItems().add(new ItemIIComponent<>(new BadgeComponent("nuevo", "lsy-bg-c-success"), true,
				PastleyVariable.PASTLEY_MENU_TYPE_SALE, null, null));
		// Method
		List<ItemIIComponent<String>> method = new ArrayList<>();
		method.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		method.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER,
				"pages/method/register.xhtml", PastleyVariable.PASTLEY_ICON_REGISTER));
		method.add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_METHOD_PAY, null,
				PastleyVariable.PASTLEY_ICON_TYPE_METHOD_PAY, method));
		// Other
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER, null,
				PastleyVariable.PASTLEY_ICON_REGISTER));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		menu.getItems().add(new ItemIIComponent<>(new BadgeComponent("info", "lsy-bg-c-info"), false,
				PastleyVariable.PASTLEY_MENU_NAME_MONTH, null, PastleyVariable.PASTLEY_ICON_MONTH));
	}

	public static void fillBuy(MenuIIIComponent menu) {
		menu.getItems().add(new ItemIIComponent<>(new BadgeComponent("salidas", "lsy-bg-c-danger"), true,
				PastleyVariable.PASTLEY_MENU_TYPE_BUY, null, null));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY,
				"pages/buy/all.xhtml", PastleyVariable.PASTLEY_ICON_HISTORY));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER,
				"pages/buy/register.xhtml", PastleyVariable.PASTLEY_ICON_REGISTER));
		menu.getItems().add(new ItemIIComponent<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS,
				"pages/buy/index.xhtml", PastleyVariable.PASTLEY_ICON_STATISTICS));
	}
}
