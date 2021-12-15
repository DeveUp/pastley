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

	@PostConstruct
	public void init() {
		initProduct();
	}

	public void initProduct() {
		ProductRequest productRequest = new ProductRequest();
		try {
			products = productRequest.findBySuppliesAll(false);
		} catch (ExceptionDTO e) {
			products = new ArrayList<>();
			LOGGER.error("[initProduct()]", e);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
