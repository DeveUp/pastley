package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.AlertApp;
import com.pastley.models.app.CrudApp;
import com.pastley.models.model.Provider;

@ManagedBean(name = "providerView")
@ViewScoped
public class ProviderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CrudApp<Provider> crud;
	private AlertApp alert;

	@ManagedProperty("#{table}")
	private DataTableBean tableBean;

	@PostConstruct
	public void init() {
		initCrud();
		this.alert = new AlertApp();
	}

	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getProvider(), "lsy-table", "proveedor", "selecionado");
	}

	public void update() {
		if (crud == null)
			initCrud();
		crud.setTable(this.tableBean.getProvider());
	}

	public CrudApp<Provider> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<Provider> crud) {
		this.crud = crud;
	}

	public AlertApp getAlert() {
		return alert;
	}

	public void setAlert(AlertApp alert) {
		this.alert = alert;
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
