package com.pastley.models.component;

public class ItemComponent<A> extends Component{

	private static final long serialVersionUID = 1L;

	private A entity;
	private String path;

	public ItemComponent(A entity) {
		this(null, null, null, entity, null, null);
	}

	public ItemComponent(A entity, String path, String icon) {
		this(null, null, null, entity, path, icon);
	}

	public ItemComponent(A entity, String path, String title, String icon) {
		this(null, null, title, entity, path, icon);
	}

	public ItemComponent(String id, String icon, boolean isClass) {
		this(id, (isClass ? id : null), null, null, null, icon);
	}

	public ItemComponent(String id, String styleClass, String title, A entity, String path, String icon) {
		super(id, styleClass, title, null, icon);
		this.entity = entity;
		this.path = path;
	}

	public A getEntity() {
		return entity;
	}

	public void setEntity(A entity) {
		this.entity = entity;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
