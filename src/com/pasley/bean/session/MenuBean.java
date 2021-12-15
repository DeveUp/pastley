package com.pasley.bean.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.controller.request.CategoryRequest;
import com.pastley.controller.request.ProductRequest;
import com.pastley.models.component.ItemComponent;
import com.pastley.models.component.MenuIComponent;
import com.pastley.models.component.MenuIIComponent;
import com.pastley.models.component.MenuIIIComponent;
import com.pastley.models.component.impl.MenuIComponentImpl;
import com.pastley.models.component.impl.MenuIIComponentImpl;
import com.pastley.models.component.impl.MenuIIIComponentImpl;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.model.Category;
import com.pastley.models.model.Product;

@ManagedBean(name = "menu")
@SessionScoped
public class MenuBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuBean.class);

	private List<Category> categories;
	
	private MenuIComponent<Category, Product> menuI;
	
	private MenuIIComponent menuII;
	private MenuIIIComponent menuIII;

	@PostConstruct
	public void init() {
		initCategory();
		initMenuI();
		initMenuII();
		initMenuIII();
	}

	public void initCategory() {
		CategoryRequest categoryRequest = new CategoryRequest();
		try {
			categories = categoryRequest.findByStatuAll(true);
		} catch (ExceptionDTO e) {
			categories = new ArrayList<>();
			LOGGER.error("[initCategory()], category: ", e);
		}
		ProductRequest productRequest = new ProductRequest();
		categories.stream().forEach(category -> {
			try {
				category.setProducts(productRequest.findByIdCategoryAll(category.getId()));
			} catch (ExceptionDTO e) {
				category.setProducts(new ArrayList<>());
				LOGGER.error("[initCategory()], product: ", e);
			}
		});
	}
	
	public void initMenuI() {
		menuI = new MenuIComponent<>();
		MenuIComponentImpl.fill(menuI);
		categories.stream().forEach(category ->{
			menuI.getLevel().add(new ItemComponent<>(category, null, "fas fa-angle-right"));
			List<ItemComponent<Product>> products= new ArrayList<>();
			category.getProducts().stream().forEach(product -> {
				products.add(new ItemComponent<Product>(product, null, null));
			});
			menuI.getLevelII().add(products);
		});
	}
	
	public void initMenuII() {
		menuII = new MenuIIComponent();
		MenuIIComponentImpl.fillItems(menuII);
	}
	
	public void initMenuIII() {
		menuIII = new MenuIIIComponent();
		MenuIIIComponentImpl.fillItems(menuIII);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public MenuIIComponent getMenuII() {
		return menuII;
	}

	public void setMenuII(MenuIIComponent menuII) {
		this.menuII = menuII;
	}

	public MenuIComponent<Category, Product> getMenuI() {
		return menuI;
	}

	public void setMenuI(MenuIComponent<Category, Product> menuI) {
		this.menuI = menuI;
	}

	public MenuIIIComponent getMenuIII() {
		return menuIII;
	}

	public void setMenuIII(MenuIIIComponent menuIII) {
		this.menuIII = menuIII;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
