package com.pastley.bean.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pastley.controller.request.BuyRequest;
import com.pastley.controller.request.ProductRequest;
import com.pastley.controller.request.ProviderRequest;
import com.pastley.models.app.DataTableApp;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Buy;
import com.pastley.models.model.Product;
import com.pastley.models.model.Provider;

@ManagedBean(name = "table")
@ViewScoped
public class DataTableBean implements Serializable{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataTableBean.class);
	
	private static final long serialVersionUID = 1L;
	
	private DataTableApp<Buy> buy;
	private DataTableApp<Provider> provider;
	private DataTableApp<Product> product;
	
	@PostConstruct
	public void init() {
		buy = new DataTableApp<>();
		product = new DataTableApp<>();
		provider = new DataTableApp<>();
	}
	
	public List<Buy> getBuyEntity(){
		if(buy == null)
			return new ArrayList<>();
		if(!buy.isRenderizar())
			return buy.getEntity();
		BuyRequest request = new BuyRequest();
		try {
			buy = new DataTableApp<>(request.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getBuyEntity()]", e);
			buy.setEntity(new ArrayList<>());
		}finally {
			buy.setRenderizar(false);
		}
		return buy.getEntity();
	}
	
	public List<Product> getProductEntity(){
		if(product == null)
			return new ArrayList<>();
		if(!product.isRenderizar())
			return product.getEntity();
		ProductRequest request = new ProductRequest();
		try {
			System.out.println(request.findAll());
			product = new DataTableApp<>(request.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getProductEntity()]", e);
			product.setEntity(new ArrayList<>());
		}finally {
			product.setRenderizar(false);
		}
		return product.getEntity();
	}
	
	public List<Provider> getProviderEntity(){
		if(provider == null)
			return new ArrayList<>();
		if(!provider.isRenderizar())
			return provider.getEntity();
		ProviderRequest requestProvider = new ProviderRequest();
		try {
			provider = new DataTableApp<>(requestProvider.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getProviderEntity()]", e);
			provider.setEntity(new ArrayList<>());
		}finally {
			provider.setRenderizar(false);
		}
		return provider.getEntity();
	}

	public DataTableApp<Buy> getBuy() {
		return buy;
	}

	public void setBuy(DataTableApp<Buy> buy) {
		this.buy = buy;
	}

	public DataTableApp<Product> getProduct() {
		return product;
	}

	public void setProduct(DataTableApp<Product> product) {
		this.product = product;
	}

	public DataTableApp<Provider> getProvider() {
		return provider;
	}

	public void setProvider(DataTableApp<Provider> provider) {
		this.provider = provider;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
