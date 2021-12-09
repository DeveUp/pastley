package com.pastley.models.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String address;
	private String desciption;
	private String mission;
	private String vision;
	private String aboutUs;
	private Integer size;
	private BigInteger butdget;
	private String logo;
	private boolean statu;
	private boolean sendSalesMail;
	private boolean alertStock;
	private Integer alertMinStock;
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
		Company other = (Company) obj;
		return Objects.equals(id, other.id);
	}
**/
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", desciption=" + desciption + ", mission=" + mission + ", vision=" + vision + ", aboutUs="
				+ aboutUs + ", size=" + size + ", butdget=" + butdget + ", logo=" + logo + ", statu=" + statu
				+ ", sendSalesMail=" + sendSalesMail + ", alertStock=" + alertStock + ", alertMinStock=" + alertMinStock
				+ ", dateRegister=" + dateRegister + ", dateUpdate=" + dateUpdate + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public String getVision() {
		return vision;
	}
	public void setVision(String vision) {
		this.vision = vision;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public BigInteger getButdget() {
		return butdget;
	}
	public void setButdget(BigInteger butdget) {
		this.butdget = butdget;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	public boolean isSendSalesMail() {
		return sendSalesMail;
	}
	public void setSendSalesMail(boolean sendSalesMail) {
		this.sendSalesMail = sendSalesMail;
	}
	public boolean isAlertStock() {
		return alertStock;
	}
	public void setAlertStock(boolean alertStock) {
		this.alertStock = alertStock;
	}
	public Integer getAlertMinStock() {
		return alertMinStock;
	}
	public void setAlertMinStock(Integer alertMinStock) {
		this.alertMinStock = alertMinStock;
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
