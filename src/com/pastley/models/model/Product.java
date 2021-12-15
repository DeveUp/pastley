package com.pastley.models.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;

import com.pastley.util.PastleyDate;
import com.pastley.util.PastleyValidate;

/**
 * @project Pastley.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @contributors leynerjoseoa.
 * @version 1.0.0.
 */
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String flavor;
	private String vat;
	private int stock;
	private int stockMin;
	private String dimension;
	private String image;
	private boolean statu;
	private boolean supplies;
	private String description;
	private String ingredients;
	private String discount;
	private BigInteger price;
	private String dateRegister;
	private String dateUpdate;
	private Category category;
	
	private BigInteger priceVat;
	private BigInteger priceDiscount;
	
	public Product() {	
	}
	
	public Product(BigInteger price, String discount, String vat) {
		this.price= price;
		this.discount = discount;
		this.vat = vat;
	}
	
	public LocalDate getDateWithoutTime() {
		PastleyDate date = new PastleyDate();
		try {
			return PastleyDate.convertToLocalDate(date.convertToDate(dateRegister));
		} catch (ParseException e) {
			return LocalDate.now();
		}
	}
	
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", flavor=" + flavor + ", vat=" + vat + ", stock=" + stock
				+ ", stockMin=" + stockMin + ", dimension=" + dimension + ", image=" + image + ", statu=" + statu
				+ ", description=" + description + ", ingredients=" + ingredients + ", discount=" + discount
				+ ", price=" + price + ", dateRegister=" + dateRegister + ", dateUpdate=" + dateUpdate + ", category="
				+ category + "]";
	}
	
	public void calculate() {
		this.calculatePriceIva();
		this.calculateDiscount();

	}

	/**
	 * Method that allows calculating the price of vat.
	 */
	public void calculatePriceIva() {
		this.priceVat = calculate(this.vat);
	}

	/**
	 * Method that allows the discount price to be calculated.
	 */
	public void calculateDiscount() {
		this.priceDiscount = calculate(this.discount);
	}

	/**
	 * Method for calculating the net subtotal.
	 * 
	 * @return The value obtained.
	 */
	public BigInteger getCalculateSubTotalNet() {
		return calculatePriceSubDiscount();
	}

	/**
	 * Method for calculating the gross subtotal.
	 * 
	 * @return The value obtained.
	 */
	public BigInteger getCalculateSubtotalGross() {
		if (!PastleyValidate.bigIntegerHigherZero(this.priceVat)) {
			calculatePriceIva();
		}
		return getCalculateSubTotalNet().add(this.priceVat);
	}

	/**
	 * Method that allows adding the value of the VAT to the price of the product.
	 * 
	 * @return The value obtained.
	 */
	public BigInteger calculatePriceAddPriceIva() {
		if (!PastleyValidate.bigIntegerHigherZero(this.priceVat)) {
			calculatePriceIva();
		}
		BigInteger price = (PastleyValidate.bigIntegerHigherZero(this.price)) ? this.price.add(this.priceVat)
				: BigInteger.ZERO;
		return (PastleyValidate.bigIntegerLessZero(price)) ? BigInteger.ZERO : price;
	}

	/**
	 * Method that allows subtracting the value of the discount from the price of
	 * the product.
	 * 
	 * @return The value obtained.
	 */
	public BigInteger calculatePriceSubDiscount() {
		if (!PastleyValidate.bigIntegerHigherZero(this.priceDiscount)) {
			calculateDiscount();
		}
		BigInteger price = (PastleyValidate.bigIntegerHigherZero(this.price)) ? this.price.subtract(this.priceDiscount)
				: BigInteger.ZERO;
		return (PastleyValidate.bigIntegerLessZero(price)) ? BigInteger.ZERO : price;
	}

	/**
	 * Method that allows you to convert a percentage into a price.
	 * 
	 * @param chain, Represents the percentage.
	 * @return The value obtained.
	 */
	private BigInteger calculate(String chain) {
		if (PastleyValidate.isChain(chain)) {
			BigDecimal price = new BigDecimal(this.price);
			int number = (PastleyValidate.isNumber(chain)) ? Integer.parseInt(chain) : 0;
			price = price.multiply(new BigDecimal((double) (number / 100d)));
			return price.toBigInteger();
		}
		return BigInteger.ZERO;
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

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public boolean isSupplies() {
		return supplies;
	}

	public void setSupplies(boolean supplies) {
		this.supplies = supplies;
	}

	public BigInteger getPriceVat() {
		return priceVat;
	}

	public void setPriceVat(BigInteger priceVat) {
		this.priceVat = priceVat;
	}

	public BigInteger getPriceDiscount() {
		return priceDiscount;
	}

	public void setPriceDiscount(BigInteger priceDiscount) {
		this.priceDiscount = priceDiscount;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMin() {
		return stockMin;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isStatu() {
		return statu;
	}

	public void setStatu(boolean statu) {
		this.statu = statu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public BigInteger getPrice() {
		return price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
