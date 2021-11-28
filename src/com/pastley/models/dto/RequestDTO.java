package com.pastley.models.dto;

import java.io.Serializable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pastley.models.model.Buy;
import com.pastley.models.model.BuyDetail;
import com.pastley.models.model.Provider;

public class RequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public JSONObject provider(Provider provider) {
		JSONObject object = new JSONObject();
		object.put("id", provider.getId());
		object.put("name", provider.getName());
		object.put("description", provider.getDescription());
		object.put("statu", provider.isStatu());
		object.put("dateRegister", provider.getDateRegister());
		object.put("dateUpdate", provider.getDateUpdate());
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject buyDetail(BuyDetail buyDetail) {
		JSONObject object = new JSONObject();
		object.put("id", buyDetail.getId());
		object.put("idProduct", buyDetail.getIdProduct());
		object.put("discount", buyDetail.getDiscount());
		object.put("vat", buyDetail.getVat());
		object.put("count", buyDetail.getCount());
		object.put("price", buyDetail.getPrice());
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject buy(Buy buy, boolean details) {
		JSONObject object = new JSONObject();
		object.put("id", buy.getId());
		object.put("provider", provider(buy.getProvider()));
		object.put("totalNet", buy.getTotalNet());
		object.put("totalGross", buy.getTotalGross());
		object.put("statu", buy.isStatu());
		object.put("dateRegister", buy.getDateRegister());
		object.put("dateUpdate", buy.getDateUpdate());
		if(details) {
			JSONArray array = new JSONArray();
			for(BuyDetail bd: buy.getDetails()) {
				array.add(buyDetail(bd));
			}
			object.put("details", array);
		}
		return object;
	}	
}
