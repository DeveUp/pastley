package com.pastley.models.dto;

import java.math.BigInteger;

import org.json.simple.JSONObject;

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
		if (!PastleyValidate.isObject(object))
			return value;
		ExceptionDTO exception = new ExceptionDTO();
		exception.setException(validateString(object.get("exception"), "N/A"));
		exception.setPath(validateString(object.get("path"), "N/A"));
		exception.setMessage(validateString(object.get("message"), "N/A"));
		exception.setStatu(validateInt(object.get("code"), 500));
		return exception;
	}

	/*
	 * CONVERT MICROSERVICE PRODUCT
	 */

	public static Category category(JSONObject object, Category value) {
		if (!PastleyValidate.isObject(object))
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
		if (!PastleyValidate.isObject(object))
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
		product.setSupplies(validateBoolean(object.get("supplies"), false));
		product.setDescription(validateString(object.get("description"), null));
		product.setIngredients(validateString(object.get("ingredients"), null));
		product.setDiscount(validateString(object.get("discount"), null));
		product.setPrice(validateBigInteger(object.get("price"), BigInteger.ZERO));
		product.setDateRegister(validateString(object.get("dateRegister"), null));
		product.setDateUpdate(validateString(object.get("dateUpdate"), null));
		product.setCategory(category((JSONObject) object.get("category"), new Category()));
		return product;
	}
	
	/*
	 * CONVERT MICROSERVICE SALE
	 */
	
	public static Provider provider(JSONObject object, Provider value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Provider provider = new Provider();
		provider.setId(validateLong(object.get("id"), 0L));
		provider.setName(validateString(object.get("name"), null));
		provider.setDescription(validateString(object.get("description"), null));
		provider.setStatu(validateBoolean(object.get("statu"), false));
		provider.setDateRegister(validateString(object.get("dateRegister"), null));
		provider.setDateUpdate(validateString(object.get("dateUpdate"), null));
		return provider;
	}

	public static Buy buy(JSONObject object, Buy value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Buy buy = new Buy();
		buy.setId(validateLong(object.get("id"), 0L));
		buy.setProvider(provider((JSONObject) object.get("provider"), new Provider()));
		buy.setTotalNet(validateBigInteger(object.get("totalNet"), null));
		buy.setTotalGross(validateBigInteger(object.get("totalGross"), null));
		buy.setStatu(validateBoolean(object.get("statu"), false));
		buy.setDateRegister(validateString(object.get("dateRegister"), null));
		buy.setDateUpdate(validateString(object.get("dateUpdate"), null));
		return buy;
	}

	public static BuyDetail buyDetail(JSONObject object, BuyDetail value) {
		if (!PastleyValidate.isObject(object))
			return value;
		BuyDetail buyDetail = new BuyDetail();
		buyDetail.setId(validateLong(object.get("id"), 0L));
		buyDetail.setIdProduct(validateLong(object.get("idProduct"), null));
		buyDetail.setDiscount(validateString(object.get("discount"), null));
		buyDetail.setVat(validateString(object.get("vat"), null));
		buyDetail.setCount(validateInt(object.get("count"), 0));
		buyDetail.setPrice(validateBigInteger(object.get("price"), BigInteger.ZERO));
		buyDetail.setDescription(validateString(object.get("description"), null));
		buyDetail.setSubtotalNet(validateBigInteger(object.get("subtotalNet"), BigInteger.ZERO));
		buyDetail.setSubtotalGross(validateBigInteger(object.get("subtotalGross"), BigInteger.ZERO));
		buyDetail.setOtherPriceVat(validateBigInteger(object.get("otherPriceVat"), BigInteger.ZERO));
		buyDetail.setOtherPriceAddPriceVat(validateBigInteger(object.get("otherPriceAddPriceVat"), BigInteger.ZERO));
		buyDetail.setOtherPriceDisount(validateBigInteger(object.get("otherPriceDisount"), BigInteger.ZERO));
		buyDetail.setOtherPriceSubPriceDisount(
				validateBigInteger(object.get("otherPriceSubPriceDisount"), BigInteger.ZERO));
		buyDetail.setOtherSubtotalPriceDisount(
				validateBigInteger(object.get("otherSubtotalPriceDisount"), BigInteger.ZERO));
		return buyDetail;
	}

	public static Sale sale(JSONObject object, Sale value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Sale sale = new Sale();

		sale.setId(validateLong(object.get("id"), 0L));
		sale.setIdCoustomer(validateLong(object.get("idCoustomer"),  null));
		sale.setIdMethodPay(validateLong(object.get("idMethodPay"),  null));
		sale.setIva(validateString(object.get("iva"), null));
		sale.setTotalNet(validateBigInteger(object.get("totalNet"), BigInteger.ZERO));
		sale.setTotalGross(validateBigInteger(object.get("totalGross"), BigInteger.ZERO));
		sale.setStatu(validateBoolean(object.get("statu"), false));
		sale.setDateRegister(validateString(object.get("dateRegister"), null));
		sale.setDateUpdate(validateString(object.get("dateUpdate"), null));

		return sale;
	}
	
	public static SaleDetail saleDetail(JSONObject object, SaleDetail value) {
		if (!PastleyValidate.isObject(object))
			return value;
		SaleDetail saleDetail = new SaleDetail();

		saleDetail.setId(validateLong(object.get("id"), 0L));
		saleDetail.setIdSale(validateLong(object.get("idSale"),  null));

		return saleDetail;
	}
	
	public static MethodPay methodPay(JSONObject object, MethodPay value) {
		if (!PastleyValidate.isObject(object))
			return value;
		MethodPay methodPay = new MethodPay();
		
		methodPay.setId(validateLong(object.get("id"), 0L));
		methodPay.setName(validateString(object.get("name"), null));
		methodPay.setStatu(validateBoolean(object.get("statu"), false));
		methodPay.setDateRegister(validateString(object.get("dateRegister"), null));
		methodPay.setDateUpdate(validateString(object.get("dateUpdate"), null));

		return methodPay;
	}
	
	public static Cart cart(JSONObject object, Cart value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Cart cart = new Cart();

		cart.setId(validateLong(object.get("id"), 0L));
		cart.setIdProduct(validateLong(object.get("idProduct"),  null));
		cart.setIdCustomer(validateLong(object.get("idCustomer"),  null));
		cart.setDiscount(validateString(object.get("discount"), null));
		cart.setVat(validateString(object.get("vat"), null));
		cart.setCount(validateInt(object.get("count"), 0));
		cart.setPrice(validateBigInteger(object.get("price"), BigInteger.ZERO));
		cart.setDescription(validateString(object.get("description"), null));
		cart.setSubtotalNet(validateBigInteger(object.get("SubTotalNet"), BigInteger.ZERO));
		cart.setSubtotalGross(validateBigInteger(object.get("subTotalGross"), BigInteger.ZERO));
		cart.setStatu(validateBoolean(object.get("statu"), false));
		cart.setDateRegister(validateString(object.get("dateRegister"), null));
		cart.setDateUpdate(validateString(object.get("dateUpdate"), null));
		
		return cart;
	}
	
	/* 
	 * CONVERT MICROSERVICE USER 
	 * */
	public static Person person(JSONObject object, Person value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Person person = new Person();
		
		person.setId(validateLong(object.get("id"), 0L));
		person.setDocument(validateLong(object.get("document"),  null));
		person.setName(validateString(object.get("name"), null));
		person.setSubname(validateString(object.get("submane"), null));
		person.setPhone(validateString(object.get("phone"), null));
		person.setEmail(validateString(object.get("email"), null));
		person.setAddress(validateString(object.get("address"), null));
		person.setDateBirthday(validateString(object.get("dateBirthday"), null));
		person.setDateRegister(validateString(object.get("dateRegister"), null));
		person.setDateUpdate(validateString(object.get("dateUpdate"), null));
		person.setTypeDocument(typeDocument((JSONObject) object.get("typeDocument"), new TypeDocument()));
		return person;
	}
	
	
	public static User user(JSONObject object, User value) {
		if (!PastleyValidate.isObject(object))
			return value;
		User user = new User();
		
		user.setId(validateLong(object.get("id"), 0L));
		user.setNickname(validateString(object.get("nickname"), null));
		user.setPoints(validateLong(object.get("points"), null));
		user.setPassword(validateString(object.get("password"), null));
		user.setIp(validateString(object.get("ip"), null));
		user.setLastPassword(validateString(object.get("lastPassword"), null));
		user.setStatu(validateBoolean(object.get("statu"), false));
		user.setSession(validateBoolean(object.get("session"), false));
		user.setDateRegister(validateString(object.get("dateRegister"), null));
		user.setDateUpdate(validateString(object.get("dateUpdate"), null));		
		user.setDateLastDate(validateString(object.get("dateLastDate"), null));
		user.setDateSession(validateString(object.get("dateSession"), null));
		user.setPerson(person((JSONObject) object.get("person"), new Person()));
			
		return user;
	}
	
	public static Role role(JSONObject object, Role value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Role role = new Role();
		
		role.setId(validateLong(object.get("id"), 0L));
		role.setName(validateString(object.get("name"), null));
		role.setDescription(validateString(object.get("description"), null));
		role.setStatu(validateBoolean(object.get("statu"), false));
		role.setSession(validateBoolean(object.get("session"), false));
		role.setDateRegister(validateString(object.get("dateRegister"), null));
		role.setDateUpdate(validateString(object.get("dateUpdate"), null));
		
		return role;
	}
	
	
	public static TypeDocument typeDocument(JSONObject object, TypeDocument value) {
		if (!PastleyValidate.isObject(object))
			return value;
		TypeDocument typeDocument = new TypeDocument();
		
		typeDocument.setId(validateLong(object.get("id"), 0L));
		typeDocument.setName(validateString(object.get("name"), null));
		typeDocument.setStatu(validateBoolean(object.get("statu"), false));
		typeDocument.setDateRegister(validateString(object.get("dateRegister"), null));
		typeDocument.setDateUpdate(validateString(object.get("dateUpdate"), null));

		return typeDocument;
	}
	
	
	/* CONVERT MICROSERVICE CONTACT 
     * Company
	 * */
	
	public static TypePQR typePQR(JSONObject object, TypePQR value) {
		if (!PastleyValidate.isObject(object))
			return value;
		TypePQR typePQR = new TypePQR();
		
		typePQR.setId(validateLong(object.get("id"), 0L));
		typePQR.setName(validateString(object.get("name"), null));
		typePQR.setDescription(validateString(object.get("description"), null));
		typePQR.setStatu(validateBoolean(object.get("statu"), false));
		typePQR.setDateRegister(validateString(object.get("dateRegister"), null));
		typePQR.setDateUpdate(validateString(object.get("dateUpdate"), null));
		
		return typePQR;
	}
	
	public static Contact contact(JSONObject object, Contact value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Contact contact = new Contact();
		
		contact.setId(validateLong(object.get("id"), 0L));
		contact.setMessage(validateString(object.get("message"), null));
		contact.setStatu(validateBoolean(object.get("statu"), false));
		contact.setDateRegister(validateString(object.get("dateRegister"), null));
		contact.setDateUpdate(validateString(object.get("dateUpdate"), null));
		contact.setIdUser(validateLong(object.get("idUser"), null));
		
		return contact;
	}
	
	public static ContactResponse contactResponse(JSONObject object, ContactResponse value) {
		if (!PastleyValidate.isObject(object))
			return value;
		ContactResponse contactResponse = new ContactResponse();
		
		contactResponse.setId(validateLong(object.get("id"), 0L));
		contactResponse.setResponse(validateString(object.get("response"), null));
		contactResponse.setDateRegister(validateString(object.get("dateRegister"), null));
		contactResponse.setDateUpdate(validateString(object.get("dateUpdate"), null));
		
		return contactResponse;
	}
	
	public static Company company(JSONObject object, Company value) {
		if (!PastleyValidate.isObject(object))
			return value;
		Company company = new Company();
		
		company.setId(validateLong(object.get("id"), 0L));
		company.setName(validateString(object.get("name"), null));
		company.setEmail(validateString(object.get("email"), null));
		company.setPassword(validateString(object.get("password"), null));
		company.setAddress(validateString(object.get("address"), null));
		company.setDesciption(validateString(object.get("desciption"), null));
		company.setMission(validateString(object.get("mission"), null));
		company.setVision(validateString(object.get("vision"), null));
		company.setAboutUs(validateString(object.get("aboutUs"), null));
		//company.setSize(validateInteger(object.get("size"), BigInteger.ZERO));
		company.setButdget(validateBigInteger(object.get("butdget"), BigInteger.ZERO));
		company.setLogo(validateString(object.get("logo"), null));
		company.setStatu(validateBoolean(object.get("statu"), false));
		company.setSendSalesMail(validateBoolean(object.get("sendSalesMail"), false));
		company.setAlertStock(validateBoolean(object.get("alertStock"), false));
		//company.setAlertMinStock(validateInteger(object.get("alertMinStock"), BigInteger.ZERO));
		company.setDateRegister(validateString(object.get("dateRegister"), null));
		company.setDateUpdate(validateString(object.get("dateUpdate"), null));
		
		return company;
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
