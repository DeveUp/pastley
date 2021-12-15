package com.pastley.models.component;

import java.util.List;

public class CardComponent extends Component {
	
	private static final long serialVersionUID = 1L;
	
	private String path;
	private String value;
	private String name;
	private boolean isPrice;
	
	private List<LinkComponent> links;

	public CardComponent(String path, String value, String name, boolean isPrice, List<LinkComponent> links, String styleClass, String id,
			String icon) {
		super(id, styleClass, icon);
		this.path = path;
		this.value = value;
		this.name = name;
		this.isPrice = isPrice;
		this.links = links;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrice() {
		return isPrice;
	}

	public void setPrice(boolean isPrice) {
		this.isPrice = isPrice;
	}

	public List<LinkComponent> getLinks() {
		return links;
	}

	public void setLinks(List<LinkComponent> links) {
		this.links = links;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
