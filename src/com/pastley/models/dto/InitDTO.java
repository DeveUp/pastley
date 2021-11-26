package com.pastley.models.dto;

import com.pastley.models.model.Category;
import com.pastley.models.model.Product;

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
}
