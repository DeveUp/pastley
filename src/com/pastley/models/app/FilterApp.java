package com.pastley.models.app;

import java.util.Locale;

import com.pastley.util.PastleyValidate;

public class FilterApp {
	
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
