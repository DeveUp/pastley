package com.pastley.models.app;

import java.io.Serializable;

import org.primefaces.PrimeFaces;

public class PrimefacesApp implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	public void tableClearFilter(String table) {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('"+table+"').clearFilters()");
	} 
	
	public void tableUnSelect(String table) {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('"+table+"').unselectAllRows()");
	}
	
	public void dialog(int statu, String dialog) {
		PrimeFaces current = PrimeFaces.current();
		switch (statu) {
		case 1:
			current.executeScript("PF('"+dialog+"').show();");
			break;
		case 2:
			current.executeScript("PF('"+dialog+"').hide();");
			break;
		default:
			break;
		}
	}
	
	public void update(String a, String b) {
		PrimeFaces.current().ajax().update(a, b);
	}
	
	public void fileUpdate(String a) {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('"+a+"').reset();");
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
