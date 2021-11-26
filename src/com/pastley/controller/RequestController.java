package com.pastley.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.JSONConvert;
import com.pastley.util.PastleyValidate;
import com.pastley.util.PastleyVariableApi;;

public class RequestController <A> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String PROPERTY_TYPE = PastleyVariableApi.PASTLEY_API_PROPERTY_TYPE_JSON;
	private String PROPERTY_ACCEPT = PastleyVariableApi.PASTLEY_API_PROPERTY_ACCEPT_JSON;

	public HttpURLConnection requestToHead(String path, String method, JSONObject send) throws ExceptionDTO {
		try {
			URL connect = new URL(path);
			HttpURLConnection http = (HttpURLConnection) connect.openConnection();
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setRequestProperty("Content-Type", PROPERTY_TYPE);
			http.setRequestProperty("Accept", PROPERTY_ACCEPT);
			http.setRequestProperty("Method", method);
			if (send != null) {
				OutputStream os = http.getOutputStream();
				os.write(send.toString().getBytes("UTF-8"));
				os.close();
			}
			return http;
		}catch (Exception e) {
			throw new ExceptionDTO(e); 
		}	
	}
	
	public A post(String path, JSONObject send) throws ExceptionDTO {
		return request(path, PastleyVariableApi.PASTLEY_API_METHOD_POST, send);
	}

	public A get(String path, JSONObject send) throws ExceptionDTO {
		return request(path, PastleyVariableApi.PASTLEY_API_METHOD_GET, send);
	}

	public A put(String path, JSONObject send) throws ExceptionDTO {
		return request(path, PastleyVariableApi.PASTLEY_API_METHOD_PUT, send);
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	private A request(String path, String method, JSONObject send) throws ExceptionDTO {
		HttpURLConnection http = requestToHead(path, method, send);
		try {
			int HttpResult = http.getResponseCode();
			JSONParser parser = new JSONParser();
			if (HttpResult == HttpURLConnection.HTTP_OK) {
				String response = streamString(http.getInputStream());
				if(!PastleyValidate.isChain(response)) 
					return null;
				return (A) parser.parse(response);
			} else {
				String response = streamString(http.getErrorStream());
				if(!PastleyValidate.isChain(response)) 
					return null;
				JSONObject object= (JSONObject) parser.parse(response);
				throw new JSONConvert().exception(object, null); 
			}
		}catch (Exception e) {
			throw new ExceptionDTO(e);
		}		
	}
	
	private String streamString(InputStream is) throws ExceptionDTO {
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			return sb.toString();
		}catch (Exception e) {
			throw new ExceptionDTO(e);
		}
	}

	public String getPROPERTY_TYPE() {
		return PROPERTY_TYPE;
	}

	public void setPROPERTY_TYPE(String pROPERTY_TYPE) {
		PROPERTY_TYPE = pROPERTY_TYPE;
	}

	public String getPROPERTY_ACCEPT() {
		return PROPERTY_ACCEPT;
	}

	public void setPROPERTY_ACCEPT(String pROPERTY_ACCEPT) {
		PROPERTY_ACCEPT = pROPERTY_ACCEPT;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
