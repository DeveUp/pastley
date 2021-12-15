package com.pastley.models.component;

import java.util.List;

public class ItemIIComponent<A> extends ItemComponent<A> {

	private static final long serialVersionUID = 1L;
	
	private BadgeComponent badge;
	private boolean info;
	
	private List<ItemIIComponent<A>> items;
	
	public ItemIIComponent(BadgeComponent badge, boolean info, A entity, String path, String icon) {
		this(badge, info, null, null, null, entity, path, icon, null);
	}
	
	public ItemIIComponent(BadgeComponent badge, boolean info, A entity, String path, String icon, List<ItemIIComponent<A>> items) {
		this(badge, info, null, null, null, entity, path, icon, items);
	}
	
	public ItemIIComponent(BadgeComponent badge, boolean info, String id, String styleClass, String title, A entity, String path, String icon) {
		this(badge, info, id, styleClass, title, entity, path, icon, null);
	}
	
	public ItemIIComponent(BadgeComponent badge, boolean info, String id, String styleClass, String title, A entity, String path, String icon, List<ItemIIComponent<A>> items) {
		super(id, styleClass, title, entity, path, icon);
		this.badge = badge;
		this.info = info;
		this.items = items;
	}

	public BadgeComponent getBadge() {
		return badge;
	}

	public void setBadge(BadgeComponent badge) {
		this.badge = badge;
	}

	public boolean isInfo() {
		return info;
	}

	public void setInfo(boolean info) {
		this.info = info;
	}

	public List<ItemIIComponent<A>> getItems() {
		return items;
	}

	public void setItems(List<ItemIIComponent<A>> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
