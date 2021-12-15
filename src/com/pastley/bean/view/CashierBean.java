package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.AlertApp;
import com.pastley.models.app.CrudApp;
import com.pastley.models.model.User;

@ManagedBean(name = "cashierView")
@ViewScoped
public class CashierBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CrudApp<User> crud;
	private AlertApp alert;

	@ManagedProperty("#{table}")
	private DataTableBean tableBean;

	@PostConstruct
	public void init() {
		initCrud();
		alert = new AlertApp();
	}

	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getCashier(), "lsy-table", "cajero", "selecionado");
	}

	public void update() {
		if (crud == null)
			initCrud();
		crud.setTable(this.tableBean.getCashier());
	}

	public CrudApp<User> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<User> crud) {
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
