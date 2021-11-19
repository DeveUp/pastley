package com.pastley.util;

public class PastleyVariable {

	/* APP */
	public static final String PASTLEY_APP_NAME = "Pastley";
	
	/* ARRAY */
	public static final char[] PASTLEY_ARRAY_NUMBER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static final String[] PASTLEY_ARRAY_DATE = { "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	
	/* DATE */
	public static final String PASTLEY_DATE_ZONA_ID = "America/Bogota";
	public static final String PASTLEY_DATE_FORMAT_DATE = "yyyy/MM/dd";
	public static final String PASTLEY_DATE_FORMAT_HOUR = "HH:mm:ss";
	public static final String PASTLEY_DATE_TIME_FORMAT = PASTLEY_DATE_FORMAT_DATE + " " + PASTLEY_DATE_FORMAT_HOUR;

	/* API */
	public static final String PASTLEY_API_PROPERTY_ACCEPT_JSON = "application/json";
	public static final String PASTLEY_API_PROPERTY_TYPE_JSON = "application/json; charset=utf8";
	
	public static final String PASTLEY_API_METHOD_GET = "get";
	public static final String PASTLEY_API_METHOD_PUT = "put";
	public static final String PASTLEY_API_METHOD_POST = "post";
	public static final String PASTLEY_API_GATEWAY_PORT = "8080";
	public static final String PASTLEY_API_GATEWAY_HOST = "localhost";
	public static final String PASTLEY_API_GATEWAY_PATH = "http://" + PASTLEY_API_GATEWAY_HOST + ":"
			+ PASTLEY_API_GATEWAY_PORT + "/";

	/* REQUEST */
	public static final String PASTLEY_API_REQUEST_CREATE = "";
	public static final String PASTLEY_API_REQUEST_UPDATE_STATU = "update/statu";
	public static final String PASTLEY_API_REQUEST_ALL_GET_STATU = "all/find/statu/";
	
	/* API MICROSERVICE SALE */
	public static final String PASTLEY_API_MICROSERVICE_PRODUCT_SERVICE_PRODUCT = PASTLEY_API_GATEWAY_PATH+"product";
	public static final String PASTLEY_API_MICROSERVICE_PRODUCT_SERVICE_CATEGORY = PASTLEY_API_GATEWAY_PATH+"category";
	
	/* API MICROSERVICE SALE */
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_SALE = PASTLEY_API_GATEWAY_PATH+"sale";
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_METHOD = PASTLEY_API_GATEWAY_PATH+"method";
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_CART= PASTLEY_API_GATEWAY_PATH+"cart";
	public static final String PASTLEY_API_MICROSERVICE_SALE_SERVICE_SALE_DETAIL = PASTLEY_API_GATEWAY_PATH+"sale-detail";

	/* NAME MENU */
	public static final String PASTLEY_MENU_NAME_HISTORY = "Historial";
	public static final String PASTLEY_MENU_NAME_REGISTER = "Registrar";
	public static final String PASTLEY_MENU_NAME_STATISTICS = "Estadistica";
	public static final String PASTLEY_MENU_NAME_MONTH = "Mensual";
	public static final String PASTLEY_MENU_NAME_RESPONSE = "Respuesta";
	public static final String PASTLEY_MENU_TYPE_MAINTENANCE = "Mantenimiento";
	public static final String PASTLEY_MENU_TYPE_COMPANY = "Empresa";
	public static final String PASTLEY_MENU_TYPE_COMPANY_INFO = "Informacion";

	public static final String PASTLEY_MENU_TYPE_SALE = "Venta";
	public static final String PASTLEY_MENU_TYPE_CONTACT = "Contacto";
	public static final String PASTLEY_MENU_TYPE_CUSTOMER = "Cliente";
	public static final String PASTLEY_MENU_TYPE_CASHIER = "Cajero";
	public static final String PASTLEY_MENU_TYPE_PRODUCT = "Producto";
	public static final String PASTLEY_MENU_TYPE_PQR = "PQR";
	public static final String PASTLEY_MENU_TYPE_CATEGORY = "Categoria";
	public static final String PASTLEY_MENU_TYPE_METHOD_PAY = "Metodo Pago";

	/* ICON */
	public static final String PASTLEY_ICON_HISTORY = "fas fa-history";
	public static final String PASTLEY_ICON_REGISTER = "far fa-plus-square";
	public static final String PASTLEY_ICON_STATISTICS = "fas fa-chart-bar";
	public static final String PASTLEY_ICON_MONTH = "fas fa-calendar-alt";
	public static final String PASTLEY_ICON_INFO = "fas fa-file-alt";
	public static final String PASTLEY_ICON_RESPONSE = "fas fa-paper-plane";
	public static final String PASTLEY_ICON_OUT = "fas fa-sign-out-alt";

	public static final String PASTLEY_ICON_TYPE_CUSTOMER = "fas fa-user-tag";
	public static final String PASTLEY_ICON_TYPE_CASHIER = "fas fa-user-tie";
	public static final String PASTLEY_ICON_TYPE_PRODUCT = "fas fa-box-open";
	public static final String PASTLEY_ICON_TYPE_CONTACT = "fas fa-id-card";
	public static final String PASTLEY_ICON_TYPE_PQR = "fas fa-file-signature";
	public static final String PASTLEY_ICON_TYPE_CATEGORY = "fas fa-file-signature";
	public static final String PASTLEY_ICON_TYPE_METHOD_PAY = "fas fa-file-signature";
}
