package com.pastley.models.app;

import java.io.Serializable;


public class StatuApp implements Serializable{

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
