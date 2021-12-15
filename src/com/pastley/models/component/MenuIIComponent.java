package com.pastley.models.component;

import java.io.Serializable;
import java.util.List;

public class MenuIIComponent implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemComponent<String>> items;

	public List<ItemComponent<String>> getItems() {
		return items;
	}

	public void setItems(List<ItemComponent<String>> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
