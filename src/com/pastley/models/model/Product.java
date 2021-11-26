package com.pastley.models.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;

import com.pastley.util.PastleyDate;

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
	private String description;
	private String ingredients;
	private String discount;
	private BigInteger price;
	private String dateRegister;
	private String dateUpdate;
	private Category category;
	
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
