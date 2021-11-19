package com.pastley.bean.session;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "urlget")
@SessionScoped
public class URLBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String URL_CHAIN;

	public String getURL_CHAIN() {
		return URL_CHAIN;
	}

	public void setURL_CHAIN(String uRL_CHAIN) {
		URL_CHAIN = uRL_CHAIN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
