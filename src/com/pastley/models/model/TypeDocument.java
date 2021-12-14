package com.pastley.models.model;

import java.io.Serializable;

public class TypeDocument implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
	
	/**
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeDocument other = (TypeDocument) obj;
		return Objects.equals(id, other.id);
	}
	**/
	@Override
	public String toString() {
		return "TypeDocument [id=" + id + ", name=" + name + ", statu=" + statu + ", dateRegister=" + dateRegister
				+ ", dateUpdate=" + dateUpdate + "]";
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
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
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
