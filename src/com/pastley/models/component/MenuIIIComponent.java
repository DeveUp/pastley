package com.pastley.models.component;

import java.io.Serializable;
import java.util.List;

public class MenuIIIComponent implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemIIComponent<String>> items;

	public List<ItemIIComponent<String>> getItems() {
		return items;
	}

	public void setItems(List<ItemIIComponent<String>> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
