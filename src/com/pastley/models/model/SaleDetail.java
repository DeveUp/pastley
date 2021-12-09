package com.pastley.models.model;

import java.io.Serializable;

public class SaleDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idSale;
	
	
	
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
		SaleDetail other = (SaleDetail) obj;
		return Objects.equals(id, other.id);
	}

	**/
	
	@Override
	public String toString() {
		return "SaleDetail [id=" + id + ", idSale=" + idSale + "]";
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdSale() {
		return idSale;
	}
	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
