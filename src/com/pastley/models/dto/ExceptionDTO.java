package com.pastley.models.dto;

import java.io.Serializable;

/**
 * @project Pastley.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @contributors leynerjoseoa.
 * @version 1.0.0.
 */
public class ExceptionDTO extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	private String exception;
	private String path;
	private String message;
	private int statu;
	
	public ExceptionDTO() {
	}

	public ExceptionDTO(Exception e) {
		if (e != null) {
			this.exception = e.getLocalizedMessage();
			this.path = e.getLocalizedMessage();
			this.message = e.getMessage();
			this.statu = 404;
		}
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
