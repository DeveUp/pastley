package com.pastley.models.model;

import java.io.Serializable;

public class ContactResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String response;
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
		ContactResponse other = (ContactResponse) obj;
		return Objects.equals(id, other.id);
	}
	**/
	@Override
	public String toString() {
		return "ContactResponse [id=" + id + ", response=" + response + ", dateRegister=" + dateRegister
				+ ", dateUpdate=" + dateUpdate + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
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
