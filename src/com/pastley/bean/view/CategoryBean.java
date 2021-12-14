package com.pastley.bean.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.pastley.models.app.CrudApp;
import com.pastley.models.model.Category;

@ManagedBean(name = "categoryView")
@ViewScoped
public class CategoryBean {
	
	private CrudApp<Category> crud;
	
	@ManagedProperty("#{table}")
	private DataTableBean tableBean;
	
	@PostConstruct
	public void init() {
		initCrud();
	}
	
	public void initCrud() {
		this.crud = new CrudApp<>(tableBean.getCategory(), "lsy-table", "categoria", "selecionada");
	}

	public CrudApp<Category> getCrud() {
		return crud;
	}

	public void setCrud(CrudApp<Category> crud) {
		this.crud = crud;
	}

	public DataTableBean getTableBean() {
		return tableBean;
	}

	public void setTableBean(DataTableBean tableBean) {
		this.tableBean = tableBean;
	}
}
