package com.pastley.util;

public class PastleyVariableApi {
	
	/* GATEWAY */
	public static final String PASTLEY_API_GATEWAY_PORT = "8080";
	public static final String PASTLEY_API_GATEWAY_HOST = "localhost";
	public static final String PASTLEY_API_GATEWAY_PATH = "http://" + PASTLEY_API_GATEWAY_HOST + ":"
			+ PASTLEY_API_GATEWAY_PORT + "/";
	
	/* PROPERTY */
	public static final String PASTLEY_API_PROPERTY_ACCEPT_JSON = "application/json";
	public static final String PASTLEY_API_PROPERTY_TYPE_JSON = "application/json; charset=utf8";
	
	/* METHOD */
	public static final String PASTLEY_API_METHOD_GET = "get";
	public static final String PASTLEY_API_METHOD_PUT = "put";
	public static final String PASTLEY_API_METHOD_POST = "post";

	/* REQUEST */
	public static final String PASTLEY_API_REQUEST_FIND_ID = "/{id}";
	public static final String PASTLEY_API_REQUEST_FIND_NAME = "/find/name/{name}";
	public static final String PASTLEY_API_REQUEST_ALL = "/";
	public static final String PASTLEY_API_REQUEST_ALL_FIND_STATU = "/all/find/statu/{statu}";
	public static final String PASTLEY_API_REQUEST_ALL_FIND_SUPPLIES = "/all/find/supplies/{supplies}";
	public static final String PASTLEY_API_REQUEST_ALL_FIND_CATEGORY = "/all/find/category/{idCategory}";
	public static final String PASTLEY_API_REQUEST_RANGE_ALL_FIND_DATE_REGISTER = "/range/all/find/date/register/{start}/{end}";
	public static final String PASTLEY_API_REQUEST_CREATE = "/";
	public static final String PASTLEY_API_REQUEST_UPDATE = "/";
	public static final String PASTLEY_API_REQUEST_UPDATE_STATU = "/update/statu/{id}";
	
	/* API MICROSERVICE PRODUCT */
	public static final String PASTLEY_API_MICROSERVICE_PRODUCT_SERVICE_PRODUCT = PASTLEY_API_GATEWAY_PATH+"product";
	public static final String PASTLEY_API_MICROSERVICE_PRODUCT_SERVICE_CATEGORY = PASTLEY_API_GATEWAY_PATH+"category";
	
	/* API MICROSERVICE SALE */
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_SALE = PASTLEY_API_GATEWAY_PATH+"sale";
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_METHOD = PASTLEY_API_GATEWAY_PATH+"method";
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_CART= PASTLEY_API_GATEWAY_PATH+"cart";
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_SALE_DETAIL = PASTLEY_API_GATEWAY_PATH+"sale-detail";
	
	/* API MICROSERVICE BUY */
	public static final String PASTLEY_API_MICROSERVICE_BUY_SERVICE_BUY = PASTLEY_API_GATEWAY_PATH+"buy";
	public static final String PASTLEY_API_MICROSERVICE_BUY_SERVICE_PROVIDER = PASTLEY_API_GATEWAY_PATH+"provider";
	public static final String PASTLEY_API_MICROSERVICE_BUY_SERVICE_BUYDETAIL = PASTLEY_API_GATEWAY_PATH+"buy-detail";
	
	/* API MICROSERVICE USER */
	public static final String PASTLEY_API_MICROSERVICE_USER_SERVICE_PERSON = PASTLEY_API_GATEWAY_PATH+"person";
	public static final String PASTLEY_API_MICROSERVICE_USER_SERVICE_USER = PASTLEY_API_GATEWAY_PATH+"user";
	public static final String PASTLEY_API_MICROSERVICE_USER_SERVICE_ROLE = PASTLEY_API_GATEWAY_PATH+"role";
	public static final String PASTLEY_API_MICROSERVICE_USER_SERVICE_TYPE_DOCUMENT = PASTLEY_API_GATEWAY_PATH+"TypeDocument";
	
	/* API MICROSERVICE CONTACT */
	public static final String PASTLEY_API_MICROSERVICE_CONTACT_SERVICE_TYPEPQR = PASTLEY_API_GATEWAY_PATH+"type-pqr";
	public static final String PASTLEY_API_MICROSERVICE_CONTACT_SERVICE_CONTACT = PASTLEY_API_GATEWAY_PATH+"contact";
	public static final String PASTLEY_API_MICROSERVICE_CONTACT_SERVICE_CONTACT_RESPONSE = PASTLEY_API_GATEWAY_PATH+"contact-response";
	public static final String PASTLEY_API_MICROSERVICE_CONTACT_SERVICE_COMPANY = PASTLEY_API_GATEWAY_PATH+"company";
}
