package com.pastley.bean.view.page;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.json.simple.JSONObject;

import com.oastley.controller.RequestController;
import com.pastley.bean.session.URLBean;
import com.pastley.bean.view.DataTableBean;
import com.pastley.models.dto.CrudDTO;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.FilterDTO;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.dto.ListDTO;
import com.pastley.models.dto.RequestDTO;
import com.pastley.models.model.Product;
import com.pastley.util.PastleyValidate;
import com.pastley.util.PastleyVariable;

@ManagedBean(name = "product")
@ViewScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CrudDTO<Product> crud;
	private Product product;

	@ManagedProperty("#{table}")
	private DataTableBean tableBean;

	@ManagedProperty("#{urlget}")
	private URLBean urlBean;

	@PostConstruct
	public void init() {
		initCrud();
	}

	public void initCrud() {
		this.crud = new CrudDTO<Product>(tableBean.getProductTable().getEntity(), "producto", "selecionado");
		initOther();
	}

	public void initOther() {
		this.product = InitDTO.product(true);
	}

	public boolean replace(Product product) {
		boolean statu = false;
		if (product != null) {
			ListDTO<Product> list = new ListDTO<>(tableBean.getProductEntity());
			statu = list.replace(product);
			if (statu) {
				tableBean.getProductTable().setEntity(list.getList());
			} else {
				tableBean.initProduct();
			}
		}
		return statu;
	}

	public void create() {
		crud.insert(true, false, true);
		try {
			RequestController<JSONObject> request = new RequestController<>();
			RequestDTO send = new RequestDTO();
			Product product = new Product(request.post(PastleyVariable.PASTLEY_API_MICROSERVICE_PRODUCT_SERVICE_PRODUCT,
					send.add(this.product)));
			crud.getAlert().success("Se ha registrado el producto con el id " + product.getId());
			crud.insert(false, true, false);
		} catch (ExceptionDTO e) {
			crud.getAlert().error(e.getMessage());
		}
		crud.getAlert().toPrintln(true);
	}

	public void update(Long id) {
		crud.update(true, false, true);
		try {
			RequestController<JSONObject> request = new RequestController<>();
			Product product = new Product(request.put("http://localhost:8080/product/update/statu/1", null));
			crud.getAlert().success("Se ha actualizado el estado del producto con el id " + product.getId());
			crud.update(false, true, false);
			replace(product);
		} catch (ExceptionDTO e) {
			crud.getAlert().error(e.getMessage());
		}
		crud.getAlert().toPrintln(true);
	}

	public void update() {
		crud.update(true, false, true);
		try {
			RequestController<JSONObject> request = new RequestController<>();
			RequestDTO send = new RequestDTO();
			Product product = new Product(request.put("http://localhost:8080/product/", send.add(this.product)));
			crud.getAlert().success("Se ha actualizado el producto con el id " + product.getId());
			crud.update(false, true, false);
			replace(product);
		} catch (ExceptionDTO e) {
			crud.getAlert().error(e.getMessage());
		}
		crud.getAlert().toPrintln(true);
	}

	public void findByProduct() {
		if (PastleyValidate.isChain(urlBean.getURL_CHAIN()) && PastleyValidate.isNumber(urlBean.getURL_CHAIN())) {
			try {
				RequestController<JSONObject> request = new RequestController<>();
				this.product = new Product(
						request.put("http://localhost:8080/product/" + urlBean.getURL_CHAIN(), null));
			} catch (ExceptionDTO e) {
				product = null;
			}
		} else {
			product = null;
		}
	}

	public boolean filterByInteger(Object value, Object filter, Locale locale) {
		return FilterDTO.filterByInteger(value, filter, locale);
	}

	public CrudDTO<Product> getCrud() {
		return crud;
	}

	public void setCrud(CrudDTO<Product> crud) {
		this.crud = crud;
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
