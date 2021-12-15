package com.pastley.bean.session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.pastley.models.component.FooterComponent;
import com.pastley.models.component.impl.FooterComponentImpl;

@ManagedBean(name = "home")
@SessionScoped
public class HomeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private FooterComponent footer;
	
	@ManagedProperty("#{menu}")
	private MenuBean menuBean;
	
	@PostConstruct
	public void init() {
		initFooter();
	}
	
	public void initFooter() {
		footer = new FooterComponent();
		FooterComponentImpl.fill(footer);
		footer.setCategories(menuBean.getMenuI().getLevel());
	}

	public FooterComponent getFooter() {
		return footer;
	}

	public void setFooter(FooterComponent footer) {
		this.footer = footer;
	}

	public MenuBean getMenuBean() {
		return menuBean;
	}

	public void setMenuBean(MenuBean menuBean) {
		this.menuBean = menuBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
