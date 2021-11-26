package com.pastley.models.dto;

import com.pastley.models.model.Buy;
import com.pastley.models.model.BuyDetail;
import com.pastley.models.model.Category;
import com.pastley.models.model.Product;
import com.pastley.models.model.Provider;

/**
 * @project Pastley.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @contributors leynerjoseoa.
 * @version 1.0.0.
 */
public class InitDTO {
	
	public static Category category() {
		return new Category();
	}
	
	public static Product product(boolean category) {
		Product product = new Product();
		if(category)
			product.setCategory(category());
		return product;
	}
	
	public static Provider provider() {
		return new Provider();
	}
	
	public static Buy buy(boolean provider) {
		Buy buy = new Buy();
		if(provider)
			buy.setProvider(provider());
		return buy;
	}
	public static BuyDetail buyDetail() {
		BuyDetail buyDetail = new BuyDetail();
		return buyDetail;
	}
}
