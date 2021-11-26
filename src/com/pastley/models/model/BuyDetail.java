package com.pastley.models.model;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class BuyDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idProduct;	
	private String discount;
	private String vat;
	private int count;
	private BigInteger price;
	private String description;
	private BigInteger subtotalNet;
	private BigInteger subtotalGross;
	private BigInteger otherPriceVat;
	private BigInteger otherPriceAddPriceVat;
	private BigInteger otherPriceDisount;
	private BigInteger otherPriceSubPriceDisount;
	private BigInteger otherSubtotalPriceDisount;
	
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
		BuyDetail other = (BuyDetail) obj;
		return Objects.equals(id, other.id);
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
	public BigInteger getOtherPriceVat() {
		return otherPriceVat;
	}
	public void setOtherPriceVat(BigInteger otherPriceVat) {
		this.otherPriceVat = otherPriceVat;
	}
	public BigInteger getOtherPriceAddPriceVat() {
		return otherPriceAddPriceVat;
	}
	public void setOtherPriceAddPriceVat(BigInteger otherPriceAddPriceVat) {
		this.otherPriceAddPriceVat = otherPriceAddPriceVat;
	}
	public BigInteger getOtherPriceDisount() {
		return otherPriceDisount;
	}
	public void setOtherPriceDisount(BigInteger otherPriceDisount) {
		this.otherPriceDisount = otherPriceDisount;
	}
	public BigInteger getOtherPriceSubPriceDisount() {
		return otherPriceSubPriceDisount;
	}
	public void setOtherPriceSubPriceDisount(BigInteger otherPriceSubPriceDisount) {
		this.otherPriceSubPriceDisount = otherPriceSubPriceDisount;
	}
	public BigInteger getOtherSubtotalPriceDisount() {
		return otherSubtotalPriceDisount;
	}
	public void setOtherSubtotalPriceDisount(BigInteger otherSubtotalPriceDisount) {
		this.otherSubtotalPriceDisount = otherSubtotalPriceDisount;
	}
	
	
}
