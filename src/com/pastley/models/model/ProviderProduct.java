package com.pastley.models.model;

import java.io.Serializable;
import java.util.Objects;

public class ProviderProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long product;
	private Long provider;
	
	@Override
	public int hashCode() {
		return Objects.hash(product, provider);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProviderProduct other = (ProviderProduct) obj;
		return Objects.equals(product, other.product) && Objects.equals(provider, other.provider);
	}
	
	
	
	public Long getProduct() {
		return product;
	}
	public void setProduct(Long product) {
		this.product = product;
	}
	public Long getProvider() {
		return provider;
	}
	public void setProvider(Long provider) {
		this.provider = provider;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
