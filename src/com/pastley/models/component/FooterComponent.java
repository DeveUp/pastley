package com.pastley.models.component;

import java.util.List;

import com.pastley.models.model.Category;

public class FooterComponent {
	private static final long serialVersionUID = 1L;

	private List<ItemComponent<Category>> categories;
	private List<ItemComponent<String>> services;
	private List<ItemComponent<String>> social;

	public List<ItemComponent<Category>> getCategories() {
		return categories;
	}

	public void setCategories(List<ItemComponent<Category>> categories) {
		this.categories = categories;
	}

	public List<ItemComponent<String>> getServices() {
		return services;
	}

	public void setServices(List<ItemComponent<String>> services) {
		this.services = services;
	}

	public List<ItemComponent<String>> getSocial() {
		return social;
	}

	public void setSocial(List<ItemComponent<String>> social) {
		this.social = social;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
