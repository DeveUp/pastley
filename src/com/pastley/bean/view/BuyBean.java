package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.AlertApp;
import com.pastley.models.app.CrudApp;
import com.pastley.models.model.Buy;

@ManagedBean(name = "buyView")
@ViewScoped
public class BuyBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private CrudApp<Buy> crud;
	private AlertApp alert;
	
	@ManagedProperty("#{table}")
	private DataTableBean tableBean;
	
	@PostConstruct
	public void init() {
		initCrud();
		this.alert = new AlertApp();
	}
	
	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getBuy(), "lsy-table", "compra", "selecionada");
	}
	
	public void update() {
		if(crud == null)
			initCrud();
		crud.setTable(this.tableBean.getBuy());
	}

	public CrudApp<Buy> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<Buy> crud) {
		this.crud = crud;
	}

	public DataTableBean getTableBean() {
		return tableBean;
	}

	public AlertApp getAlert() {
		return alert;
	}

	public void setAlert(AlertApp alert) {
		this.alert = alert;
	}

	public void setTableBean(DataTableBean tableBean) {
		this.tableBean = tableBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
