package com.pastley.bean.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pastley.controller.request.BuyRequest;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.primefaces.DataTableDTO;
import com.pastley.models.model.Buy;

@ManagedBean(name = "table")
@ViewScoped
public class DataTableBean implements Serializable{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataTableBean.class);
	
	private static final long serialVersionUID = 1L;
	
	private DataTableDTO<Buy> buy;
	
	@PostConstruct
	public void init() {
		buy = new DataTableDTO<>();
	}
	
	public List<Buy> getBuyEntity(){
		if(buy == null)
			return new ArrayList<>();
		if(!buy.isRenderizar())
			return buy.getEntity();
		BuyRequest request = new BuyRequest();
		try {
			buy = new DataTableDTO<>(request.findAll());
		} catch (ExceptionDTO e) {
			LOGGER.error("[getBuyEntity()]", e);
			buy.setEntity(new ArrayList<>());
		}finally {
			buy.setRenderizar(false);
		}
		return buy.getEntity();
	}

	public DataTableDTO<Buy> getBuy() {
		return buy;
	}

	public void setBuy(DataTableDTO<Buy> buy) {
		this.buy = buy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
