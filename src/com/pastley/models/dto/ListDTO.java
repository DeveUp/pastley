package com.pastley.models.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pastley.util.PastleyValidate;

public class ListDTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> entities;
	private T entity;
	private int index;

	public ListDTO() {
		this(new ArrayList<>());
	}

	public ListDTO(List<T> entities) {
		this.entities = entities;
		this.index = -1;
	}

	public void reset() {
		if (!PastleyValidate.isList(entities))
			entities = new ArrayList<T>();
	}

	public boolean isList() {
		return PastleyValidate.isList(entities);
	}

	public boolean isValidate(T entity) {
		return (entity != null && isList());
	}

	public boolean remove(T entity) {
		return (isValidate(entity)) ? entities.remove(entity) : false;
	}

	public int index(T entity) {
		index = -1;
		if (isValidate(entity)) {
			index = entities.indexOf(entity);
			if (index >= 0)
				this.entity = entities.get(index);
		}
		return index;
	}

	public boolean replace(T entity) {
		if (isValidate(entity)) {
			index = index(entity);
			if (index >= 0) {
				entities.set(index, entity);
				return true;
			}
		}
		return false;
	}

	public boolean add(List<T> entities) {
		reset();
		if (PastleyValidate.isList(entities)) {
			entities.stream().forEach(e -> this.entities.add(e));
			return true;
		}
		return false;
	}

	public List<T> getEntities() {
		return entities;
	}

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
