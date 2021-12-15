package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.AlertApp;
import com.pastley.models.app.CrudApp;
import com.pastley.models.model.TypeDocument;

@ManagedBean(name = "typeDocumentView")
@ViewScoped
public class TypeDocumentBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private CrudApp<TypeDocument> crud;
	private AlertApp alert;
	
	@ManagedProperty("#{table}")
	private DataTableBean tableBean;
	
	@PostConstruct
	public void init() {
		initCrud();
		alert = new AlertApp();
	}
	
	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getTypeDocument(), "lsy-table", "tipo de documento", "selecionado");
	}
	
	public void update() {
		if(crud == null)
			initCrud();
		crud.setTable(this.tableBean.getTypeDocument());
	}

	public CrudApp<TypeDocument> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<TypeDocument> crud) {
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
