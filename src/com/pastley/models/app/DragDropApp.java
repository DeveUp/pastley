package com.pastley.models.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;

import com.pastley.util.PastleyValidate;

public class DragDropApp<E> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<E> list;
	private List<E> dropped;
	private E model;

	public DragDropApp() {
		this(new ArrayList<E>());
	}

	public DragDropApp(List<E> list) {
		this.list = list;
		dropped = new ArrayList<>();
	}

	public void on(DragDropEvent<E> ddEvent) {
		on(ddEvent.getData());
	}

	public void onDrag(DragDropEvent<E> e) {
		this.model = e.getData();
		this.dropped.add(this.model);
		this.list.remove(this.model);
	}

	public void on(E model) {
		this.model = model;
		onNotRemove(this.model);
		this.list.remove(this.model);
	}

	public void onNotRemove(E model) {
		this.dropped.add(model);
	}

	public boolean field(E x, List<E> a, List<E> b) {
		if (b == null)
			b = new ArrayList<E>();
		if (x != null && PastleyValidate.isList(a) && b != null) {
			a.remove(x);
			b.add(x);
			return true;
		}
		return false;
	}

	public boolean isDropped(E model) {
		ListApp<E> x = new ListApp<E>(dropped);
		int index = x.index(model);
		return index >= 0;
	}

	public void eliminar(E id) throws InterruptedException {
		FacesMessage m = ((field(id, dropped, list))
				? new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se ha eliminado la subcategoria del dropped.")
				: new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "No se ha eliminado la subcategoria del dropped."));
		FacesContext.getCurrentInstance().addMessage(null, m);
	}
}
