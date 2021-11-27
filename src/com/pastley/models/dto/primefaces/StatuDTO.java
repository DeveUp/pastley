package com.pastley.models.dto.primefaces;

import java.io.Serializable;


public class StatuDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected boolean renderizar;

	public boolean isRenderizar() {
		return renderizar;
	}

	public void setRenderizar(boolean renderizar) {
		this.renderizar = renderizar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
