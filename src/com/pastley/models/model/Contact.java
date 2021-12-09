package com.pastley.models.model;

import java.io.Serializable;

public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String message;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
	private Long idUser;
	
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
		Contact other = (Contact) obj;
		return Objects.equals(id, other.id);
	}
	**/
	@Override
	public String toString() {
		return "Contact [id=" + id + ", message=" + message + ", statu=" + statu + ", dateRegister=" + dateRegister
				+ ", dateUpdate=" + dateUpdate + ", idUser=" + idUser + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}