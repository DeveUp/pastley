package com.pastley.bean.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.CrudApp;

@ManagedBean(name = "methodPayView")
@ViewScoped
public class MethodPay implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private CrudApp<MethodPay> crud;
	
	@ManagedProperty("#{table}")
	private DataTableBean tableBean;
	
	@PostConstruct
	public void init() {
		initCrud();
	}
	
	public void initCrud() {
		this.crud = new CrudApp<>();
	}

	public CrudApp<MethodPay> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<MethodPay> crud) {
		this.crud = crud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
