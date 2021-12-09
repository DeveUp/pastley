package com.pastley.models.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idProduct;
	private Long idCustomer;
	private String discount;
	private String vat;
	private int count;
	private BigInteger price;
	private String description;
	private BigInteger subtotalNet;
	private BigInteger subtotalGross;
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
		Cart other = (Cart) obj;
		return Objects.equals(id, other.id);
	}
	**/
	@Override
	public String toString() {
		return "Cart [id=" + id + ", idProduct=" + idProduct + ", idCustomer=" + idCustomer + ", discount=" + discount
				+ ", vat=" + vat + ", count=" + count + ", price=" + price + ", description=" + description
				+ ", subtotalNet=" + subtotalNet + ", subtotalGross=" + subtotalGross + ", statu=" + statu
				+ ", dateRegister=" + dateRegister + ", dateUpdate=" + dateUpdate + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BigInteger getPrice() {
		return price;
	}
	public void setPrice(BigInteger price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigInteger getSubtotalNet() {
		return subtotalNet;
	}
	public void setSubtotalNet(BigInteger subtotalNet) {
		this.subtotalNet = subtotalNet;
	}
	public BigInteger getSubtotalGross() {
		return subtotalGross;
	}
	public void setSubtotalGross(BigInteger subtotalGross) {
		this.subtotalGross = subtotalGross;
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
