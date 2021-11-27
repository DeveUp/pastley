package com.pastley.models.dto.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.primefaces.model.FilterMeta;

public class DataTableDTO<T> extends StatuDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> entity;
	private List<T> filter;
	private List<FilterMeta> filterBy;
	private List<T> select;
	private boolean globalFilterOnly;

	public DataTableDTO() {
		this(new ArrayList<>());
	}

	public DataTableDTO(List<T> entity) {
		this.renderizar = true;
		this.globalFilterOnly = false;
		this.entity = entity;
		this.filter = new ArrayList<>();
		this.filter();
	}

	public void filter() {
	}
	
	public void toggleGlobalFilter() {
        setGlobalFilterOnly(!isGlobalFilterOnly());
    }
	
	public boolean filterByInteger(Object value, Object filter, Locale locale) {
		return FilterDTO.filterByInteger(value, filter, locale);
	}

	public List<T> getEntity() {
		return entity;
	}

	public List<T> getSelect() {
		return select;
	}

	public void setSelect(List<T> select) {
		this.select = select;
	}

	public void setEntity(List<T> entity) {
		this.entity = entity;
	}

	public List<T> getFilter() {
		return filter;
	}

	public void setFilter(List<T> filter) {
		this.filter = filter;
	}

	public boolean isGlobalFilterOnly() {
		return globalFilterOnly;
	}

	public void setGlobalFilterOnly(boolean globalFilterOnly) {
		this.globalFilterOnly = globalFilterOnly;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<FilterMeta> getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(List<FilterMeta> filterBy) {
		this.filterBy = filterBy;
	}
}
