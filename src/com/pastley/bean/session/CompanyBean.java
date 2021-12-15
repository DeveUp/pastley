package com.pastley.bean.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.controller.request.CompanyRequest;
import com.pastley.models.app.AlertApp;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Company;

@ManagedBean(name = "company")
@SessionScoped
public class CompanyBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyBean.class);
	
	private Company company;
	private AlertApp alert;
	
	@PostConstruct
	public void init() {
		initCompany();
		alert = new AlertApp();
	}
	
	public void initCompany() {
		CompanyRequest companyRequest = new CompanyRequest();
		try {
			company = companyRequest.findById(1L, new Company());
		} catch (ExceptionDTO e) {
			LOGGER.error("[initCompany()]", e);
		}
	}
	
	public void update() {
		alert = new AlertApp();
		CompanyRequest companyRequest = new CompanyRequest();
		try {
			Company company = companyRequest.update(this.company);
			this.company = company;
			alert.success("Se ha actualizado la información de la empresa");
		} catch (ExceptionDTO e) {
			LOGGER.error("[update()]", e);
			initCompany();
			alert.error(e.getMessage());
		}
		alert.toPrintln(true);
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}
