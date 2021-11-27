package com.pastley.models.model;

import java.io.Serializable;
import java.math.BigInteger;

public class BuyDetail implements Serializable {

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

	private Product product;


	
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
		BuyDetail other = (BuyDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Method that allows all prices to be calculated.
	 */
	public void calculate() {
		if(this.count <= 0) return;
		Product pm = new Product(this.price, this.discount, this.vat);
		pm.calculate();
		this.otherPriceVat = pm.getPriceVat();
		this.otherPriceAddPriceVat = pm.calculatePriceAddPriceIva();
		this.otherPriceDisount = pm.getPriceDiscount();
		this.otherPriceSubPriceDisount = pm.calculatePriceSubDiscount();
		calculateSubtotalPriceDisount(pm);
		calculateSubtotalNet(pm);
		calculateSubtotalGross(pm);
	}
	
	/**
	 * Method for calculating the gross subtotal.
	 * @return The value obtained.
	 */
	public BigInteger calculateSubtotalGross(Product pm) {
		pm = (pm != null) ? pm : new Product(this.price, this.discount, this.vat);
		this.subtotalGross = pm.calculateSubtotalGross().multiply(new BigInteger(String.valueOf(this.count)));
		return this.subtotalGross;
	}
	
	/**
	 * Method for calculating the net subtotal.
	 * @return The value obtained.
	 */
	public BigInteger calculateSubtotalNet(Product pm) {
		pm = (pm != null) ? pm : new Product(this.price, this.discount, this.vat);
		this.subtotalNet = pm.calculateSubTotalNet().multiply(new BigInteger(String.valueOf(this.count)));
		return this.subtotalNet;
	}
	
	/**
	 * Method that allows calculating the subtotal of discount applied.
	 * @return The value obtained.
	 */
	public BigInteger calculateSubtotalPriceDisount(Product pm) {
		pm = (pm != null) ? pm : new Product(this.price, this.discount, this.vat);
		pm.calculateDiscount();
		this.otherSubtotalPriceDisount = pm.getPriceDiscount().multiply(new BigInteger(String.valueOf(this.count)));
		return this.otherSubtotalPriceDisount;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
