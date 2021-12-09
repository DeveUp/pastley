package com.pastley.models.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idCoustomer;
	private Long idMethodPay;
	private String iva;
	private BigInteger totalNet;
	private BigInteger totalGross;
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
		Sale other = (Sale) obj;
		return Objects.equals(id, other.id);
	}
	
	**/
	@Override
	public String toString() {
		return "Sale [id=" + id + ", idCoustomer=" + idCoustomer + ", idMethodPay=" + idMethodPay + ", iva=" + iva
				+ ", totalNet=" + totalNet + ", totalGross=" + totalGross + ", statu=" + statu + ", dateRegister="
				+ dateRegister + ", dateUpdate=" + dateUpdate + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCoustomer() {
		return idCoustomer;
	}
	public void setIdCoustomer(Long idCoustomer) {
		this.idCoustomer = idCoustomer;
	}
	public Long getIdMethodPay() {
		return idMethodPay;
	}
	public void setIdMethodPay(Long idMethodPay) {
		this.idMethodPay = idMethodPay;
	}
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	public BigInteger getTotalNet() {
		return totalNet;
	}
	public void setTotalNet(BigInteger totalNet) {
		this.totalNet = totalNet;
	}
	public BigInteger getTotalGross() {
		return totalGross;
	}
	public void setTotalGross(BigInteger totalGross) {
		this.totalGross = totalGross;
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
