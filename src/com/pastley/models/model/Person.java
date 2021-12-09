package com.pastley.models.model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long document;
	private String name;
	private String subname;
	private String phone;
	private String email;
	private String address;
	private String dateBirthday;
	private String dateRegister;
	private String dateUpdate;
	private TypeDocument typeDocument;

	/**
	 * @Override public int hashCode() { return Objects.hash(id); }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 *           if (obj == null) return false; if (getClass() != obj.getClass())
	 *           return false; Person other = (Person) obj; return
	 *           Objects.equals(id, other.id); }
	 **/


	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", document=" + document + ", name=" + name + ", subname=" + subname + ", phone="
				+ phone + ", email=" + email + ", address=" + address + ", dateBirthday=" + dateBirthday
				+ ", dateRegister=" + dateRegister + ", dateUpdate=" + dateUpdate + ", typeDocument=" + typeDocument
				+ "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateBirthday() {
		return dateBirthday;
	}

	public void setDateBirthday(String dateBirthday) {
		this.dateBirthday = dateBirthday;
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

	public TypeDocument getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}
	
	

}
