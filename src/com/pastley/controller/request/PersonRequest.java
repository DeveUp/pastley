package com.pastley.controller.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.pastley.controller.RequestController;
import com.pastley.models.dto.ExceptionDTO;
import com.pastley.models.dto.InitDTO;
import com.pastley.models.dto.JSONConvert;
import com.pastley.models.model.Person;
import com.pastley.util.PastleyValidate;
import com.pastley.util.PastleyVariableApi;

public class PersonRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String path = PastleyVariableApi.PASTLEY_API_MICROSERVICE_USER_SERVICE_PERSON;
	
	/**
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws ExceptionDTO
	 */
	public Person findById(Long id, Person value) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_FIND_ID;
		return find(aux.replace("{id}", String.valueOf(id)), value);
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @throws ExceptionDTO
	 */
	public Person findByName(String name, Person value) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_FIND_NAME;
		return find(aux.replace("{name}", name), value);
	}

	/**
	 * 
	 * @return
	 * @throws ExceptionDTO
	 */
	public List<Person> findAll() throws ExceptionDTO {
		return findAll(path + PastleyVariableApi.PASTLEY_API_REQUEST_ALL);
	}

	/**
	 * 
	 * @param statu
	 * @return
	 * @throws ExceptionDTO
	 */
	public List<Person> findByStatuAll(boolean statu) throws ExceptionDTO {
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_ALL_FIND_STATU;
		return findAll(aux.replace("{statu}", String.valueOf(statu)));
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws ExceptionDTO
	 */
	public List<Person> findByRangeDateRegister(String start, String end) throws ExceptionDTO{
		String aux = path + PastleyVariableApi.PASTLEY_API_REQUEST_RANGE_ALL_FIND_DATE_REGISTER;
		aux = aux.replace("{start}", String.valueOf(start));
		aux = aux.replace("{end}", String.valueOf(end));
		return findAll(aux);
	}
	
	/**
	 * 
	 * @param path
	 * @param value
	 * @return
	 * @throws ExceptionDTO
	 */
	public Person find(String path, Person value) throws ExceptionDTO {
		RequestController<JSONObject> request = new RequestController<>();
		return JSONConvert.person(request.get(path, null), value);
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws ExceptionDTO
	 */
	public List<Person> findAll(String path) throws ExceptionDTO {
		RequestController<List<JSONObject>> request = new RequestController<>();
		return PersonRequest.toAll(request.get(path, null));
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	public static List<Person> toAll(List<JSONObject> list) {
		List<Person> categories = new ArrayList<Person>();
		if (PastleyValidate.isList(list)) {
			list.stream().forEach(e -> {
				categories.add(JSONConvert.person(e, InitDTO.person()));
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
