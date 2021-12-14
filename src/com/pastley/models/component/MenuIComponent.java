package com.pastley.models.component;

import java.io.Serializable;
import java.util.List;

public class MenuIComponent<A, B> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemComponent<String>> options;
	private List<ItemComponent<String>> links;
	private List<ItemComponent<A>> level;
	private List<List<ItemComponent<B>>> levelII;

	public List<ItemComponent<String>> getOptions() {
		return options;
	}

	public void setOptions(List<ItemComponent<String>> options) {
		this.options = options;
	}

	public List<ItemComponent<String>> getLinks() {
		return links;
	}

	public void setLinks(List<ItemComponent<String>> links) {
		this.links = links;
	}

	public List<ItemComponent<A>> getLevel() {
		return level;
	}

	public void setLevel(List<ItemComponent<A>> level) {
		this.level = level;
	}

	public List<List<ItemComponent<B>>> getLevelII() {
		return levelII;
	}

	public void setLevelII(List<List<ItemComponent<B>>> levelII) {
		this.levelII = levelII;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
