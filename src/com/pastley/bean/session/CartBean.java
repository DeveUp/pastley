package com.pastley.bean.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pastley.models.app.AlertApp;
import com.pastley.models.app.DragDropApp;
import com.pastley.models.app.FilterApp;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.model.Cart;
import com.pastley.models.model.Category;
import com.pastley.models.model.Product;
import com.pastley.util.PastleyValidate;

@ManagedBean(name = "cart")
@SessionScoped
public class CartBean implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartBean.class);
	private static final long serialVersionUID = 1L;

	private List<Cart> carts;
	private Cart cart;

	private List<Product> productCopy;

	private String key;
	private DragDropApp<Category> categoriasDrag;

	private boolean filter;
	private boolean filterCategory;
	private boolean filterKey;
	private boolean filterRangePrice;

	private int priceMin, priceMax;

	private AlertApp alert;

	@ManagedProperty("#{product}")
	private ProductBean productBean;
	
	@ManagedProperty("#{menu}")
	private MenuBean menuBean;

	@PostConstruct
	public void init() {
		cart = InitDTO.cart();
		carts = new ArrayList<>();
		alert = new AlertApp();
		initFilter();
		initKey();
	}

	public void initFilter() {
		filter = false;
		filterCategory = false;
		filterRangePrice = false;
		filterKey = false;
		priceMin = 0;
		priceMax = 0;
	}

	public void initKey() {
		key = null;
		filterKey = false;
	}

	public void clearFilter(int type) {
		if(filter) {
			List<Product> aux = productCopy;
			productBean.setProducts(aux);;
			productCopy = new ArrayList<Product>();
			filter = false;
			switch (type) {
			case 1:
				filterCategory = false;
				categoriasDrag = new DragDropApp<>(menuBean.getCategories());
				break;
			case 2:
				filterKey = false;
				break;
			case 3:
				filterRangePrice = false;
				priceMin = 0;
				priceMax = 0;
				break;
			default:
				filterCategory = false;
				filterKey = false;
				filterRangePrice = false;
				priceMin = 0;
				priceMax = 0;
				break;
			}
		}else {
			alert.warn("No has filtrado."); 
			alert.toPrintln(true);
		}
	}
	
	public void filterProduct() {
		alert = new AlertApp();
		initFilter();
		productBean.initProduct();
		alert.success("Se consultado todos los productos.");
		alert.toPrintln(true);
	}

	public void filterByKey() {
		boolean isError = true;
		alert = new AlertApp();
		productCopy = (filter) ? productCopy : this.productBean.getProducts();
		if (!PastleyValidate.isChain(key)) {
			alert.warn("No se ha recibido ningun valor a buscar.");
		} else {
			List<Product> list = new ArrayList<>();
			key = key.toLowerCase();
			boolean next;
			for (Product product : productCopy) {
				next = false;
				if (PastleyValidate.isChain(product.getFlavor()) && product.getFlavor().toLowerCase().contains(key)) {
					next = true;
				} else if (PastleyValidate.isChain(product.getName())
						&& product.getName().toLowerCase().contains(key)) {
					next = true;
				} else {
					Category category = product.getCategory();
					if (category != null) {
						if (PastleyValidate.isNumber(key)) {
							int number = Integer.parseInt(key);
							if (number > 0 && category.getId() == number) {
								next = true;
							}
						} else if (PastleyValidate.isChain(category.getName())
								&& category.getName().toLowerCase().contains(key)) {
							next = true;
						}
					}
				}
				if (next)
					list.add(product);
			}
			productBean.setProducts(list);
			filter = true;
			filterKey = true;
			filterCategory = false;
			filterRangePrice = false;
			priceMin = 0;
			priceMax = 0;
			isError = false;
			alert.success("Se ha filtrado " + list.size() + " resultados encontrados.");
		}
		if (isError) {
			filter = false;
			filterKey = false;
			filterCategory = false;
			filterRangePrice = false;
			priceMin = 0;
			priceMax = 0;
			productBean.setProducts(productCopy);
			productCopy = new ArrayList<>();
		}
		alert.toPrintln(true);
	}
	
	public void filterByCategory() {
		boolean isError = true;
		alert = new AlertApp();
		if (isError) {
			filter = false;
			filterKey = false;
			filterCategory = false;
			filterRangePrice = false;
			priceMin = 0;
			priceMax = 0;
			productBean.initProduct();
			productCopy = productBean.getProducts();
		}
		alert.toPrintln(true);
	}
	
	public void filterRangePrice() throws InterruptedException {
		alert = new AlertApp();
		productCopy = (filter) ? productCopy : productBean.getProducts();
		List<Product> list = FilterApp.filterProductByRangePrice(productCopy, priceMin, priceMax, 2);
		productBean.setProducts(list);
		filter = true;
		filterCategory = false;
		filterKey = false;
		filterRangePrice = true;
		alert.success("Se ha filtrado "+ productBean.getProducts().size() +" productos "+
				" por rango precio desde "+priceMin+" hasta "+priceMax+".");
		alert.toPrintln(true);	
	}

	public int getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}

	public int getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}

	public List<Product> getProductCopy() {
		return productCopy;
	}

	public DragDropApp<Category> getCategoriasDrag() {
		return categoriasDrag;
	}

	public void setCategoriasDrag(DragDropApp<Category> categoriasDrag) {
		this.categoriasDrag = categoriasDrag;
	}

	public MenuBean getMenuBean() {
		return menuBean;
	}

	public void setMenuBean(MenuBean menuBean) {
		this.menuBean = menuBean;
	}

	public void setProductCopy(List<Product> productCopy) {
		this.productCopy = productCopy;
	}

	public boolean isFilter() {
		return filter;
	}

	public void setFilter(boolean filter) {
		this.filter = filter;
	}

	public boolean isFilterCategory() {
		return filterCategory;
	}

	public void setFilterCategory(boolean filterCategory) {
		this.filterCategory = filterCategory;
	}

	public boolean isFilterKey() {
		return filterKey;
	}

	public void setFilterKey(boolean filterKey) {
		this.filterKey = filterKey;
	}

	public boolean isFilterRangePrice() {
		return filterRangePrice;
	}

	public void setFilterRangePrice(boolean filterRangePrice) {
		this.filterRangePrice = filterRangePrice;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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
