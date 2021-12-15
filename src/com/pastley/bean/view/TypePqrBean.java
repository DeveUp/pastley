package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.AlertApp;
import com.pastley.models.app.CrudApp;
import com.pastley.models.model.TypePQR;

@ManagedBean(name = "typePqrView")
@ViewScoped
public class TypePqrBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CrudApp<TypePQR> crud;
	
	private AlertApp alert;

	@ManagedProperty("#{table}")
	private DataTableBean tableBean;

	@PostConstruct
	public void init() {
		initCrud();
		alert = new AlertApp();
	}

	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getTypePqr(), "lsy-table", "tipo de pqr", "selecionada");
	}

	public void update() {
		if (crud == null)
			initCrud();
		crud.setTable(this.tableBean.getTypePqr());
	}

	public CrudApp<TypePQR> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<TypePQR> crud) {
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
