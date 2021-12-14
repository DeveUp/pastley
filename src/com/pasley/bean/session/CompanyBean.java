package com.pasley.bean.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.controller.request.CompanyRequest;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Company;

@ManagedBean(name = "company")
@SessionScoped
public class CompanyBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyBean.class);
	
	private Company company;
	
	@PostConstruct
	public void init() {
		initCompany();
	}
	
	public void initCompany() {
		CompanyRequest companyRequest = new CompanyRequest();
		try {
			company = companyRequest.findById(1L, new Company());
		} catch (ExceptionDTO e) {
			LOGGER.error("[initCompany()]", e);
		}
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
