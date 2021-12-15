package com.pastley.controller.request;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.pastley.controller.RequestController;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.dto.JSONConvert;
import com.pastley.models.dto.RequestDTO;
import com.pastley.models.model.Company;
import com.pastley.util.PastleyValidate;
import com.pastley.util.PastleyVariableApi;

public class CompanyRequest {

	private static final long serialVersionUID = 1L;

	private String path = PastleyVariableApi.PASTLEY_API_MICROSERVICE_CONTACT_SERVICE_COMPANY;

	public Company findById(Long id, Company value) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_FIND_ID;
		return find(aux.replace("{id}", String.valueOf(id)), value);
	}

	public Company findByName(String name, Company value) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_FIND_NAME;
		return find(aux.replace("{name}", name), value);
	}

	public List<Company> findAll() throws ExceptionDTO {
		return findAll(path + PastleyVariableApi.PASTLEY_API_REQUEST_ALL);
	}

	public List<Company> findByStatuAll(boolean statu) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_ALL_FIND_STATU;
		return findAll(aux.replace("{statu}", String.valueOf(statu)));
	}

	public List<Company> findByRangeDateRegister(String start, String end) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_RANGE_ALL_FIND_DATE_REGISTER;
		aux = aux.replace("{start}", String.valueOf(start));
		aux = aux.replace("{end}", String.valueOf(end));
		return findAll(aux);
	}

	public Company create(Company company) throws ExceptionDTO {
		RequestController<JSONObject> request = new RequestController<>();
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_CREATE;
		RequestDTO dto = new RequestDTO();
		JSONObject object = dto.company(company);
		company = JSONConvert.company(request.post(aux, object), null);
		return company;
	}
	
	public Company update(Company company) throws ExceptionDTO {
		RequestController<JSONObject> request = new RequestController<>();
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_UPDATE;
		RequestDTO dto = new RequestDTO();
		JSONObject object = dto.company(company);
		System.out.println(aux);
		System.out.println(object);
		company = JSONConvert.company(request.put(aux, object), null);
		return company;
	}

	public Company find(String path, Company value) throws ExceptionDTO {
		RequestController<JSONObject> request = new RequestController<>();
		return JSONConvert.company(request.get(path, null), value);
	}

	public List<Company> findAll(String path) throws ExceptionDTO {
		RequestController<List<JSONObject>> request = new RequestController<>();
		return CompanyRequest.toAll(request.get(path, null));
	}

	public static List<Company> toAll(List<JSONObject> list) {
		List<Company> categories = new ArrayList<Company>();
		if (PastleyValidate.isList(list)) {
			list.stream().forEach(e -> {
				categories.add(JSONConvert.company(e, InitDTO.company()));
			});
		}
		return categories;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
