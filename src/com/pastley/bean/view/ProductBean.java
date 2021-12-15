package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.bean.session.URLBean;
import com.pastley.controller.request.ProductRequest;
import com.pastley.models.app.AlertApp;
import com.pastley.models.app.CrudApp;
import com.pastley.models.app.FilterApp;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.model.Product;
import com.pastley.util.PastleyValidate;

@ManagedBean(name = "productView")
@ViewScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductBean.class);

	private CrudApp<Product> crud;
	private FilterApp filter;
	private AlertApp alert;

	private Product product;

	@ManagedProperty("#{table}")
	private DataTableBean tableBean;

	@ManagedProperty("#{urlGet}")
	private URLBean urlBean;

	@PostConstruct
	public void init() {
		initCrud();
		this.alert = new AlertApp();
		this.filter = new FilterApp();
		this.initProduct();
	}

	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getProduct(), "lsy-table", "producto", "selecionado");
	}

	public void findByProduct() {
		if (PastleyValidate.isChain(urlBean.getURL_CHAIN()) && PastleyValidate.isNumber(urlBean.getURL_CHAIN())) {
			try {
				ProductRequest productRequest = new ProductRequest();
				this.product = productRequest.findById(Long.parseLong(urlBean.getURL_CHAIN()), null);
			} catch (ExceptionDTO e) {
				LOGGER.error("[findByProduct()]", e);
				product = null;
			}
		} else {
			product = null;
		}
	}

	public void initProduct() {
		this.product = InitDTO.product(true);
	}

	public void update() {
		if (crud == null)
			initCrud();
		crud.setTable(this.tableBean.getProduct());
	}

	public void create() {
		this.alert = new AlertApp();
		try {
			ProductRequest productRequest = new ProductRequest();
			Product product = productRequest.create(this.product);
			alert.success("Se ha registrado el producto con el id " + product.getId());
		} catch (ExceptionDTO e) {
			LOGGER.error("[create()]", e);
			if (e != null && PastleyValidate.isChain(e.getMessage()))
				alert.error(e.getMessage());
			else
				alert.error("No se ha registrado el producto, verifique todos los campos.");
		}
		alert.toPrintln(true);
	}

	public CrudApp<Product> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<Product> crud) {
		this.crud = crud;
	}

	public AlertApp getAlert() {
		return alert;
	}

	public void setAlert(AlertApp alert) {
		this.alert = alert;
	}

	public FilterApp getFilter() {
		return filter;
	}

	public void setFilter(FilterApp filter) {
		this.filter = filter;
	}

	public Product getProduct() {
		return product;
	}

	public URLBean getUrlBean() {
		return urlBean;
	}

	public void setUrlBean(URLBean urlBean) {
		this.urlBean = urlBean;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DataTableBean getTableBean() {
		return tableBean;
	}

	public void setTableBean(DataTableBean tableBean) {
		this.tableBean = tableBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
