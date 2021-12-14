package com.pastley.models.component;

import java.io.Serializable;

public class Component implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected String title;
	protected String styleClass;
	protected String style;
	protected String icon;

	public Component() {
		this(null, null, null, null, null);
	}

	public Component(String id) {
		this(id, null, null, null, null);
	}

	public Component(String id, String styleClass, String icon) {
		this(id, styleClass, null, null, icon);
	}
	
	public Component(String id, String styleClass, String title, String icon) {
		this(id, styleClass, title, null, icon);
	}

	public Component(String id, String styleClass, String title, String style, String icon) {
		this.id = id;
		this.styleClass = styleClass;
		this.title = title;
		this.style = style;
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
