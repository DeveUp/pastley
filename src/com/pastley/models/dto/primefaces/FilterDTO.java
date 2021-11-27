package com.pastley.models.dto.primefaces;

import java.util.Locale;

import com.pastley.util.PastleyValidate;

public class FilterDTO {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean filterByInteger(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}
		if (value == null) {
			return false;
		}
		return ((Comparable) value).compareTo(PastleyValidate.toInteger(filterText)) >= 0;
	}
}
