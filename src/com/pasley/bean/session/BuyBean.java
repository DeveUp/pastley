package com.pasley.bean.session;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.controller.request.ProviderRequest;
import com.pastley.models.dto.AlertDTO;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.dto.ListDTO;
import com.pastley.models.dto.primefaces.PrimefacesDTO;
import com.pastley.models.model.Buy;
import com.pastley.models.model.BuyDetail;
import com.pastley.models.model.Product;
import com.pastley.util.PastleyDate;
import com.pastley.util.PastleyValidate;

@ManagedBean(name = "buy")
@SessionScoped
public class BuyBean implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuyBean.class);
	private static final long serialVersionUID = 1L;

	private Buy buy;
	private AlertDTO alert;

	private String dateZone;
	private PastleyDate date = new PastleyDate();

	public BuyBean() {
	}

	@PostConstruct
	public void init() {
		buy = InitDTO.buy(true);
		alert = new AlertDTO();
	}

	public void findDateZone() {
		if (date == null)
			this.date = new PastleyDate();
		this.dateZone = date.currentToDateTime(null);
	}

	public void findByProvider() {
		alert = new AlertDTO();
		if (buy != null && buy.getProvider() != null && PastleyValidate.isLong(buy.getProvider().getId())) {
			ProviderRequest request = new ProviderRequest();
			try {
				buy.setProvider(request.findById(buy.getProvider().getId(), null));
				System.out.println(buy.getProvider());
				alert.success("Se ha encontrado el proveedor con el id " + buy.getProvider().getId() + ".");
			} catch (ExceptionDTO e) {
				buy.setProvider(InitDTO.provider());
				alert.warn(e.getMessage());
				LOGGER.error("[findByProvider()]", e);
			}
		} else {
			alert.error("No se ha encontrado el proveedor.");
		}
		alert.toPrintln(true);
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

	public void add(List<Product> list) throws InterruptedException {
		if (!PastleyValidate.isList(list))
			return;
		int count = 0;
		int size = list.size();
		for (Product pp : list)
			if (addProduct(pp, false))
				count++;
		if (count == size)
			alert.success("Se han agregado todos los productos " + count + "/" + size + ".");
		else
			alert.warn("Se han agregado " + count + "/" + size + " productos.");
		alert.toPrintln(true);
	}

	public void remove(BuyDetail detail){
		alert = new AlertDTO();
		ListDTO<BuyDetail> list = new ListDTO<>(buy.getDetails());
		if (list.remove(detail)) {
			buy.setDetails(list.getEntities());
			buy.calculate();
			alert.success("Se ha eliminado el producto con id " + detail.getIdProduct() + ".");
		} else {
			alert.warn("No se ha eliminado el producto con id " + detail.getIdProduct() + ".");
		}
		alert.toPrintln(true);
	}

	public boolean addProduct(Product product, boolean isMessage) {
		product.calculate();
		BuyDetail bd = findByProduct(product);
		boolean response = false;
		if (bd != null) {
			int count = 1 + bd.getCount();
			ListDTO<BuyDetail> dto = new ListDTO<>(buy.getDetails());
			if (count <= 0) {
				dto.remove(bd);
				if (isMessage)
					alert.error("Se ha eliminado el producto con ID " + product.getId()
							+ ", no cuenta con stock disponible.");
			} else {
				bd.setCount(count);
				bd.setProduct(product);
				bd.calculate();
				dto.replace(bd);
				response = true;
				if (isMessage) {
					alert.success("Se ha editado la cantidad a " + bd.getCount() + ", del producto con ID "
							+ product.getId() + ".");
				}
			}
			buy.calculate();
			this.buy.setDetails(dto.getEntities());
		} else {
			bd = new BuyDetail();
			bd.setIdProduct(product.getId());
			bd.setCount(1);
			bd.setDiscount(product.getDiscount());
			bd.setVat(product.getVat());
			bd.setPrice(product.getPrice());
			bd.setProduct(product);
			bd.calculate();
			buy.getDetails().add(bd);
			buy.calculate();
			response = true;
		}
		return response;
	}

	public void dialogProvider(int type) throws InterruptedException {
		PrimefacesDTO primefaces = new PrimefacesDTO();
		primefaces.dialog(type, "lsy-dialog-provider");
	}

	public void dialogProvider() throws InterruptedException {
		findByProvider();
		dialogProvider(0);
	}

	public void dialogProduct(int type) throws InterruptedException {
		PrimefacesDTO primefaces = new PrimefacesDTO();
		primefaces.dialog(type, "lsy-dialog-product");
	}

	public void dialogProductAdd(List<Product> list) throws InterruptedException {
		add(list);
		dialogProduct(0);
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

	public AlertDTO getAlert() {
		return alert;
	}

	public void setAlert(AlertDTO alert) {
		this.alert = alert;
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
