package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.AlertApp;
import com.pastley.models.app.CrudApp;
import com.pastley.models.model.Sale;

@ManagedBean(name = "saleView")
@ViewScoped
public class SaleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private CrudApp<Sale> crud;
	
	private AlertApp alert;
	
	@ManagedProperty("#{table}")
	private DataTableBean tableBean;
	
	@PostConstruct
	public void init() {
		initCrud();
		this.alert = new AlertApp();
	}
	
	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getSale(), "lsy-table", "venta", "selecionada");
	}
	
	public void update() {
		if(crud == null)
			initCrud();
		crud.setTable(this.tableBean.getSale());
	}

	public CrudApp<Sale> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<Sale> crud) {
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
