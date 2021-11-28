package com.pastley.models.app;

import java.io.Serializable;

import com.pastley.util.PastleyValidate;

public class CrudApp<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T select;
	private String name;
	private String subname;

	private String styleClass;
	
	private AlertApp alert;
	private DataTableApp<T> table;


	public CrudApp() {
		this(new DataTableApp<>(), null, null, "Selecionada");
	}

	public CrudApp(DataTableApp<T> table, String styleClass, String name, String subname) {
		this.name = name;
		this.styleClass = styleClass;
		this.table = table;
		this.subname = subname;
	}

	public String getMessageDeleteCrud() {
		if (PastleyValidate.isList(this.table.getSelect())) {
			int count = this.table.getSelect().size();
			return count + " " + ConvertApp.plural(count, name) + " " + ConvertApp.plural(count, subname) + ".";
		}
		return "Eliminar";
	}
	
	public void sync() {
		if(table == null)
			return;
		this.alert = new AlertApp();
		table.setRenderizar(true);
		alert.success("Se ha actualizado la tabla "+name+".");
		alert.toPrintln(true);
	}
	
	public void clearFilter() {
		this.alert = new AlertApp();
		PrimefacesApp primefaces = new PrimefacesApp();
		primefaces.tableClearFilter(styleClass);
		primefaces.update(styleClass, "."+styleClass);
		alert.success("Se ha limpiado el filtro de la tabla "+name+".");
		alert.toPrintln(true);
	}

	public T getSelect() {
		return select;
	}

	public void setSelect(T select) {
		this.select = select;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public AlertApp getAlert() {
		return alert;
	}

	public void setAlert(AlertApp alert) {
		this.alert = alert;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public DataTableApp<T> getTable() {
		return table;
	}

	public void setTable(DataTableApp<T> table) {
		this.table = table;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
