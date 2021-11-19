package com.pastley.bean.request;

import org.slf4j.LoggerFactory;

import com.pastley.bean.session.URLBean;
import com.pastley.util.PastleyValidate;

import org.slf4j.Logger;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "requestApp")
@RequestScoped
public class RequestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestBean.class);

	private FacesContext context;
	private ExternalContext external;
	private String url;
	
	@ManagedProperty("#{urlget}")
	private URLBean urlBean;

	public void init() {
		this.context = FacesContext.getCurrentInstance();
		this.external = context.getExternalContext();
		this.url = this.external.getRequestContextPath();
	}

	public void direct(String path) {
		LOGGER.info("Accessing method: direct(String path)");
		if(!PastleyValidate.isChain(path))
			return;
		this.init();
		try {
			this.external.redirect(this.url + "/" + path);
		} catch (IOException e) {
			LOGGER.error("Error accessing method: direct(String path)");
		}
	}
	
	public void findURL() {
		String url = PastleyValidate.getFace("id");
		urlBean.setURL_CHAIN(PastleyValidate.isChain(url) ? url : null);
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public ExternalContext getExternal() {
		return external;
	}

	public void setExternal(ExternalContext external) {
		this.external = external;
	}

	public URLBean getUrlBean() {
		return urlBean;
	}

	public void setUrlBean(URLBean urlBean) {
		this.urlBean = urlBean;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}
