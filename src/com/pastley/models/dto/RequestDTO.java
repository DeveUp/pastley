package com.pastley.models.dto;

import java.io.Serializable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pastley.models.model.Buy;
import com.pastley.models.model.BuyDetail;
import com.pastley.models.model.Category;
import com.pastley.models.model.Company;
import com.pastley.models.model.Product;
import com.pastley.models.model.Provider;
import com.pastley.util.PastleyValidate;

public class RequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public JSONObject company(Company company) {
		JSONObject object = new JSONObject();
		object.put("id", company.getId());
		object.put("name", company.getName());
		object.put("email", company.getEmail());
		object.put("password", company.getPassword());
		object.put("address", company.getAddress());
		object.put("desciption", company.getDesciption());
		object.put("mission", company.getMission());
		object.put("vision", company.getVision());
		object.put("aboutUs", company.getAboutUs());
		object.put("size", company.getSize());
		object.put("butdget", company.getButdget());
		object.put("logo", company.getLogo());
		object.put("statu", company.isStatu());
		object.put("sendSalesMail", company.isSendSalesMail());
		object.put("alertStock", company.isAlertStock());
		object.put("alertMinStock", company.isAlertMinStock());
		object.put("dateRegister", company.getDateRegister());
		object.put("dateUpdate", company.getDateUpdate());
		return object;
	}

	@SuppressWarnings("unchecked")
	public JSONObject product(Product product) {
		JSONObject object = new JSONObject();
		object.put("id", product.getId());
		object.put("name", product.getName());
		object.put("flavor", product.getFlavor());
		object.put("vat", product.getVat());
		object.put("stock", product.getStock());
		object.put("stockMin", product.getStockMin());
		object.put("dimension", product.getDimension());
		object.put("image", product.getImage());
		object.put("supplies", product.isSupplies());
		object.put("price", product.getPrice());
		object.put("description", product.getDescription());
		object.put("ingredients", product.getIngredients());
		object.put("discount", product.getDiscount());
		object.put("dateRegister", product.getDateRegister());
		object.put("dateUpdate", product.getDateUpdate());
		object.put("category", category(product.getCategory() != null ? product.getCategory() : new Category()));
		return object;
	}

	@SuppressWarnings("unchecked")
	public JSONObject category(Category category) {
		JSONObject object = new JSONObject();
		object.put("id", PastleyValidate.isLong(category.getId()) ? category.getId() : 0L);
		object.put("name", category.getName());
		return object;
	}

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
		if (details) {
			JSONArray array = new JSONArray();
			for (BuyDetail bd : buy.getDetails()) {
				array.add(buyDetail(bd));
			}
			object.put("details", array);
		}
		return object;
	}
}
