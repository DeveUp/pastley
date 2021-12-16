package com.pastley.models.model;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;

import com.pastley.util.PastleyDate;

public class MethodPay implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodPay other = (MethodPay) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MethodPay [id=" + id + ", name=" + name + ", statu=" + statu + ", dateRegister=" + dateRegister
				+ ", dateUpdate=" + dateUpdate + "]";
	}
	
	public LocalDate getDateWithoutTime() {
		PastleyDate date = new PastleyDate();
		try {
			return PastleyDate.convertToLocalDate(date.convertToDate(dateRegister));
		} catch (ParseException e) {
			return LocalDate.now();
		}
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
