package com.pasley.bean.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.models.dto.InitDTO;
import com.pastley.models.dto.ListDTO;
import com.pastley.models.model.Buy;
import com.pastley.models.model.BuyDetail;
import com.pastley.models.model.Product;
import com.pastley.util.PastleyDate;
import com.pastley.util.PastleyValidate;

@ManagedBean(name = "buy")
@ViewScoped
public class BuyBean implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuyBean.class);
	private static final long serialVersionUID = 1L;

	private Buy buy;

	private String dateZone;
	private PastleyDate date = new PastleyDate();

	public BuyBean() {
	}

	@PostConstruct
	public void init() {
		buy = InitDTO.buy(true);
	}

	public void findDateZone() {
		if (date == null)
			this.date = new PastleyDate();
		this.dateZone = date.currentToDateTime(null);
	}

	public BuyDetail findByProduct(Product product) {
		if (product == null || !PastleyValidate.isList(buy.getDetails()))
			return null;
		for (BuyDetail bd : buy.getDetails()) {
			if (bd.getIdProduct() == product.getId())
				return bd;
		}
		return null;
	}

	public void addProduct(Product product) {
		BuyDetail bd = findByProduct(product);
		if (bd != null) {
			int count = 1 + bd.getCount();
			if (count > product.getStock())
				count = product.getStock();
			ListDTO<BuyDetail> dto = new ListDTO<>(buy.getDetails());
			if (count <= 0)
				dto.remove(bd);
			else {
				bd.setCount(count);
				dto.replace(bd);
			}
			this.buy.setDetails(dto.getEntities());
		} else {
			bd = new BuyDetail();
			bd.setIdProduct(product.getId());
			bd.setCount(1);
			bd.setDiscount(product.getDiscount());
			bd.setVat(product.getVat());
			bd.setPrice(product.getPrice());
			buy.getDetails().add(bd);
		}
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDateZone() {
		return dateZone;
	}

	public void setDateZone(String dateZone) {
		this.dateZone = dateZone;
	}

	public PastleyDate getDate() {
		return date;
	}

	public void setDate(PastleyDate date) {
		this.date = date;
	}

	public Buy getBuy() {
		return buy;
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}
}
