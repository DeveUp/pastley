package com.pastley.models.dto;

import java.util.ArrayList;

import com.pastley.models.model.Buy;
import com.pastley.models.model.BuyDetail;
import com.pastley.models.model.Cart;
import com.pastley.models.model.Category;
import com.pastley.models.model.Company;
import com.pastley.models.model.Contact;
import com.pastley.models.model.ContactResponse;
import com.pastley.models.model.MethodPay;
import com.pastley.models.model.Person;
import com.pastley.models.model.Product;
import com.pastley.models.model.Provider;
import com.pastley.models.model.Role;
import com.pastley.models.model.Sale;
import com.pastley.models.model.SaleDetail;
import com.pastley.models.model.TypeDocument;
import com.pastley.models.model.TypePQR;
import com.pastley.models.model.User;

/**
 * @project Pastley.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @contributors leynerjoseoa.
 * @version 1.0.0.
 */
public class InitDTO {
	
	public static Company company() {
		return new Company();
	}
	
	public static ContactResponse contactResponse() {
		return new ContactResponse();
	}
	
	public static Contact contact() {
		return new Contact();
	}
	
	public static TypePQR typePQR() {
		return new TypePQR();
	}
	
	public static Cart cart() {
		return new Cart();
	}
	
	public static MethodPay methodPay() {
		return new MethodPay();
	}
	
	public static SaleDetail saleDetail() {
		return new SaleDetail();
	}

	public static Sale sale() {
		return new Sale();
	}

	public static TypeDocument typeDocument() {
		return new TypeDocument();
	}

	public static Role role() {
		return new Role();
	}

	public static User user() {
		return new User();
	}

	public static Person person() {
		return new Person();
	}

	public static Category category() {
		return new Category();
	}

	public static Product product(boolean category) {
		Product product = new Product();
		if (category)
			product.setCategory(category());
		return product;
	}

	public static Provider provider() {
		return new Provider();
	}

	public static Buy buy(boolean provider) {
		Buy buy = new Buy();
		buy.setDetails(new ArrayList<>());
		if (provider)
			buy.setProvider(provider());
		return buy;
	}

	public static BuyDetail buyDetail() {
		BuyDetail buyDetail = new BuyDetail();
		return buyDetail;
	}
}
