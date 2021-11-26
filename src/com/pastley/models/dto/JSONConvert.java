package com.pastley.models.dto;

import java.math.BigInteger;

import org.json.simple.JSONObject;

import com.pastley.models.model.Category;
import com.pastley.models.model.Product;
import com.pastley.util.PastleyValidate;

/**
 * @project Pastley.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @contributors leynerjoseoa.
 * @version 1.0.0.
 */
public class JSONConvert {

	public static ExceptionDTO exception(JSONObject object, ExceptionDTO value) {
		if(!PastleyValidate.isObject(object))
			return value;
		ExceptionDTO exception = new ExceptionDTO();
		exception.setException(validateString(object.get("exception"), "N/A"));
		exception.setPath(validateString(object.get("path"), "N/A"));
		exception.setMessage(validateString(object.get("message"), "N/A"));
		exception.setStatu(validateInt(object.get("code"), 500));
		return exception;
	}
	
	public static Category category(JSONObject object, Category value) {
		if(!PastleyValidate.isObject(object))
			return value;
		Category category = new Category();
		category.setId(validateLong(object.get("id"), 0L));
		category.setName(validateString(object.get("name"), null));
		category.setStatu(validateBoolean(object.get("statu"), false));
		category.setDateRegister(validateString(object.get("dateRegister"), null));
		category.setDateUpdate(validateString(object.get("dateUpdate"), null));
		return category;
	}
	
	public static Product product(JSONObject object, Product value) {
		if(!PastleyValidate.isObject(object))
			return value;
		Product product = new Product();
		product.setId(validateLong(object.get("id"), 0L));
		product.setName(validateString(object.get("name"), null));
		product.setFlavor(validateString(object.get("flavor"), null));
		product.setVat(validateString(object.get("vat"), null));
		product.setStock(validateInt(object.get("stock"), 0));
		product.setStockMin(validateInt(object.get("stockMin"), 0));
		product.setDimension(validateString(object.get("dimension"), null));
		product.setImage(validateString(object.get("image"), null));
		product.setStatu(validateBoolean(object.get("statu"), false));
		product.setDescription(validateString(object.get("description"), null));
		product.setIngredients(validateString(object.get("ingredients"), null));
		product.setDiscount(validateString(object.get("discount"), null));
		product.setPrice(validateBigInteger(object.get("price"), BigInteger.ZERO));
		product.setDateRegister(validateString(object.get("dateRegister"), null));
		product.setDateUpdate(validateString(object.get("dateUpdate"), null));
		product.setCategory(category((JSONObject) object.get("category"), new Category()));
		return product;
	}
	
	
	private static Long validateLong(Object object, Long value) {
		return PastleyValidate.isObject(object) ? Long.parseLong(String.valueOf(object)) : value;
	}
	
	private static String validateString(Object object, String value) {
		return PastleyValidate.isObject(object) ? String.valueOf(object) : value;
	}
	
	private static int validateInt(Object object, int value) {
		return PastleyValidate.isObject(object) ? Integer.parseInt(String.valueOf(object)) : value;
	}
	
	private static boolean validateBoolean(Object object, boolean value) {
		return PastleyValidate.isObject(object) ? Boolean.parseBoolean(String.valueOf(object)) : value;
	}
	
	private static BigInteger validateBigInteger(Object object, BigInteger value) {
		return PastleyValidate.isObject(object) ? new BigInteger(String.valueOf(object)) : value;
	}
}
