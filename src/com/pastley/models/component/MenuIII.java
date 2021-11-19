package com.pastley.models.component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pastley.util.PastleyVariable;

public class MenuIII implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item<String> logo;
	private List<ItemII<String>> items;

	public void init(String pathLogo) {
		this.logo = new Item<>(null, pathLogo, "Logo", null);
		this.fillItems();
	}

	public void fillItems() {
		this.items = new ArrayList<>();
		this.fillMaintenance();
		this.fillCompany();
		this.fillSale();
	}

	public void fillMaintenance() {
		this.items.add(new ItemII<>(null, true, PastleyVariable.PASTLEY_MENU_TYPE_MAINTENANCE, null, null));
		// Customer
		List<ItemII<String>> customer = new ArrayList<>();
		customer.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		customer.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(
				new ItemII<>(new Badge("admi", "lsy-bg-c-warning"), false, PastleyVariable.PASTLEY_MENU_TYPE_CUSTOMER,
						null, PastleyVariable.PASTLEY_ICON_TYPE_CUSTOMER, customer));
		// Cashier
		List<ItemII<String>> cashier = new ArrayList<>();
		cashier.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		cashier.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER, null,
				PastleyVariable.PASTLEY_ICON_REGISTER));
		cashier.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_CASHIER, null,
				PastleyVariable.PASTLEY_ICON_TYPE_CASHIER, cashier));
		// Product
		List<ItemII<String>> product = new ArrayList<>();
		product.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, "pages/product/all.xhtml",
				PastleyVariable.PASTLEY_ICON_HISTORY));
		product.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER,
				"pages/product/register.xhtml", PastleyVariable.PASTLEY_ICON_REGISTER));
		product.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, "pages/product/index.xhtml",
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_PRODUCT, null,
				PastleyVariable.PASTLEY_ICON_TYPE_PRODUCT, product));
		// Category
		List<ItemII<String>> category = new ArrayList<>();
		category.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, "pages/category/all.xhtml",
				PastleyVariable.PASTLEY_ICON_HISTORY));
		category.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, "pages/category/index.xhtml",
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_CATEGORY, null,
				PastleyVariable.PASTLEY_ICON_TYPE_CATEGORY, category));
	}

	public void fillCompany() {
		this.items.add(new ItemII<>(new Badge("admi", "lsy-bg-c-warning"), true,
				PastleyVariable.PASTLEY_MENU_TYPE_COMPANY, null, null));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_COMPANY_INFO, null,
				PastleyVariable.PASTLEY_ICON_INFO));
		// PQR
		List<ItemII<String>> pqr = new ArrayList<>();
		pqr.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		pqr.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER, null,
				PastleyVariable.PASTLEY_ICON_REGISTER));
		pqr.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_PQR, null,
				PastleyVariable.PASTLEY_ICON_TYPE_PQR, pqr));
		// Contact
		List<ItemII<String>> contact = new ArrayList<>();
		contact.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		contact.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_RESPONSE, null,
				PastleyVariable.PASTLEY_ICON_RESPONSE));
		contact.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_CONTACT, null,
				PastleyVariable.PASTLEY_ICON_TYPE_CONTACT, contact));
	}

	public void fillSale() {
		this.items.add(new ItemII<>(new Badge("nuevo", "lsy-bg-c-success"), true,
				PastleyVariable.PASTLEY_MENU_TYPE_SALE, null, null));
		// Method
		List<ItemII<String>> method = new ArrayList<>();
		method.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		method.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER, "pages/method/register.xhtml",
				PastleyVariable.PASTLEY_ICON_REGISTER));
		method.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_TYPE_METHOD_PAY, null,
				PastleyVariable.PASTLEY_ICON_TYPE_METHOD_PAY, method));
		// Other
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_HISTORY, null,
				PastleyVariable.PASTLEY_ICON_HISTORY));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_REGISTER, null,
				PastleyVariable.PASTLEY_ICON_REGISTER));
		this.items.add(new ItemII<>(null, false, PastleyVariable.PASTLEY_MENU_NAME_STATISTICS, null,
				PastleyVariable.PASTLEY_ICON_STATISTICS));
		this.items.add(new ItemII<>(new Badge("info", "lsy-bg-c-info"), false, PastleyVariable.PASTLEY_MENU_NAME_MONTH,
				null, PastleyVariable.PASTLEY_ICON_MONTH));
	}

	public Item<String> getLogo() {
		return logo;
	}

	public void setLogo(Item<String> logo) {
		this.logo = logo;
	}

	public List<ItemII<String>> getItems() {
		return items;
	}

	public void setItems(List<ItemII<String>> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
