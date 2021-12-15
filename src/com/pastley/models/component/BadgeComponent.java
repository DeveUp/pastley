package com.pastley.models.component;

public class BadgeComponent extends Component{
	
	private static final long serialVersionUID = 1L;
	
	private String name;

	public BadgeComponent(String name, String styleClass) {
		this(name, null, styleClass, null);
	}
	
	public BadgeComponent(String name, String styleClass, String icon) {
		this(name, null, styleClass, icon);
	}
	
	public BadgeComponent(String name, String id, String styleClass, String icon) {
		super(id, styleClass, icon);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
