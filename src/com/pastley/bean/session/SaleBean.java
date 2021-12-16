package com.pastley.bean.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.models.app.AlertApp;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.model.Sale;

@ManagedBean(name = "sale")
@SessionScoped
public class SaleBean implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(SaleBean.class);
	private static final long serialVersionUID = 1L;

	private Sale sale;
	private AlertApp alertApp;

	@PostConstruct
	public void init() {
		sale = InitDTO.sale();
		alertApp = new AlertApp();
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public AlertApp getAlertApp() {
		return alertApp;
	}

	public void setAlertApp(AlertApp alertApp) {
		this.alertApp = alertApp;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
