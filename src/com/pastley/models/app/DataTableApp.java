package com.pastley.models.app;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;

public class DataTableApp<T> extends StatuApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> entity;
	private List<T> filter;
	private List<FilterMeta> filterBy;
	private List<T> select;
	private boolean globalFilterOnly;

	public DataTableApp() {
		this(new ArrayList<>());
	}

	public DataTableApp(List<T> entity) {
		this.renderizar = true;
		this.globalFilterOnly = false;
		this.entity = entity;
		this.filter = new ArrayList<>();
		this.initFilter();
	}

	public void initFilter() {
		filterBy = new ArrayList<>();
	}

	public void filterRange() {
		if (filter == null)
			initFilter();
		filterBy.add(FilterMeta.builder().field("dateWithoutTime")
				.filterValue(
						new ArrayList<>(Arrays.asList(LocalDate.now().minusDays(28), LocalDate.now().plusDays(28))))
				.matchMode(MatchMode.RANGE).build());
	}

	public void toggleGlobalFilter() {
		setGlobalFilterOnly(!isGlobalFilterOnly());
	}

	public boolean filterByInteger(Object value, Object filter, Locale locale) {
		return FilterApp.filterByInteger(value, filter, locale);
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
