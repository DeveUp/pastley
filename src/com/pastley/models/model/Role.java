package com.pastley.models.model;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private boolean statu;
	private boolean session;
	private String dateRegister;
	private String dateUpdate;

	/**
	 * @Override public int hashCode() { return Objects.hash(id); }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 *           if (obj == null) return false; if (getClass() != obj.getClass())
	 *           return false; Role other = (Role) obj; return Objects.equals(id,
	 *           other.id); }
	 **/

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", statu=" + statu + ", session="
				+ session + ", dateRegister=" + dateRegister + ", dateUpdate=" + dateUpdate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatu() {
		return statu;
	}

	public void setStatu(boolean statu) {
		this.statu = statu;
	}

	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	public String getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
