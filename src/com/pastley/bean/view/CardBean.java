package com.pastley.bean.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pastley.models.component.CardComponent;
import com.pastley.models.component.impl.CardComponentImpl;

@ManagedBean(name = "cardView")
@ViewScoped
public class CardBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CardComponent> cardsUser;

	@PostConstruct
	public void init() {
		initCardUser();
	}

	public void initCardUser() {
		cardsUser = CardComponentImpl.fill(cardsUser);
	}

	public List<CardComponent> getCardsUser() {
		return cardsUser;
	}

	public void setCardsUser(List<CardComponent> cardsUser) {
		this.cardsUser = cardsUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
