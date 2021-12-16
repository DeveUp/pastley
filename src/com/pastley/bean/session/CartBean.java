package com.pastley.bean.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.models.app.AlertApp;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.model.Cart;

@ManagedBean(name = "cart")
@SessionScoped
public class CartBean implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartBean.class);
	private static final long serialVersionUID = 1L;

	private List<Cart> carts;
	private Cart cart;

	private AlertApp alert;

	@PostConstruct
	public void init() {
		cart = InitDTO.cart();
		carts = new ArrayList<>();
		alert = new AlertApp();
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public AlertApp getAlert() {
		return alert;
	}

	public void setAlert(AlertApp alert) {
		this.alert = alert;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
