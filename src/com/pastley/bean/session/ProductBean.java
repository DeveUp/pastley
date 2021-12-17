package com.pastley.bean.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.controller.request.ProductRequest;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Product;

@ManagedBean(name = "product")
@SessionScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductBean.class);

	private List<Product> products;
	private List<Product> discount;

	@PostConstruct
	public void init() {
		initProduct();
		initProductDiscount();
	}

	public void initProduct() {
		System.out.println("Consultando Produtos..");
		ProductRequest productRequest = new ProductRequest();
		try {
			products = productRequest.findBySuppliesAll(false);
		} catch (ExceptionDTO e) {
			products = new ArrayList<>();
			LOGGER.error("[initProduct()]", e);
		}
	}
	
	public void initProductDiscount() {
		System.out.println("Consultando Produtos discount..");
		ProductRequest productRequest = new ProductRequest();
		try {
			discount = productRequest.findByDiscountAll();
		} catch (ExceptionDTO e) {
			discount = new ArrayList<>();
			LOGGER.error("[initProductDiscount()]", e);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getDiscount() {
		return discount;
	}

	public void setDiscount(List<Product> discount) {
		this.discount = discount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}
