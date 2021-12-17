package com.pastley.controller.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.pastley.controller.RequestController;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.dto.JSONConvert;
import com.pastley.models.model.User;
import com.pastley.util.PastleyValidate;
import com.pastley.util.PastleyVariableApi;

public class UserRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String path = PastleyVariableApi.PASTLEY_API_MICROSERVICE_USER_SERVICE_USER;

	public User findById(Long id, User value) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_FIND_ID;
		return find(aux.replace("{id}", String.valueOf(id)), value);
	}
	
	public User findByName(String name, User value) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_FIND_NAME;
		return find(aux.replace("{name}", name), value);
	}

	public List<User> findAll() throws ExceptionDTO {
		return findAll(path + PastleyVariableApi.PASTLEY_API_REQUEST_ALL);
	}

	public List<User> findByStatuAll(boolean statu) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_ALL_FIND_STATU;
		return findAll(aux.replace("{statu}", String.valueOf(statu)));
	}
	
	public List<User> findByRoleAll(Long role) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_ALL_FIND_USER_ROLE;
		return findAll(aux.replace("{idRole}", String.valueOf(role)));
	}
	
	public List<User> findByRangeDateRegister(String start, String end) throws ExceptionDTO{
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_RANGE_ALL_FIND_DATE_REGISTER;
		aux = aux.replace("{start}", String.valueOf(start));
		aux = aux.replace("{end}", String.valueOf(end));
		return findAll(aux);
	}
	
	public User find(String path, User value) throws ExceptionDTO {
		RequestController<JSONObject> request = new RequestController<>();
		return JSONConvert.user(request.get(path, null), value);
	}

	public List<User> findAll(String path) throws ExceptionDTO {
		RequestController<List<JSONObject>> request = new RequestController<>();
		return UserRequest.toAll(request.get(path, null));
	}

	public static List<User> toAll(List<JSONObject> list) {
		List<User> categories = new ArrayList<User>();
		if (PastleyValidate.isList(list)) {
			list.stream().forEach(e -> {
				categories.add(JSONConvert.user(e, InitDTO.user()));
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
