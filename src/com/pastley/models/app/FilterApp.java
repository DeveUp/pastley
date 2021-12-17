package com.pastley.models.app;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.pastley.models.model.Product;
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

	public static List<Product> filterProductByRangePrice(List<Product> list, int min, int max, int type) {
		List<Product> aux = new ArrayList<>();
		if (PastleyValidate.isList(list)) {
			if (max >= min) {
				BigInteger a = new BigInteger(String.valueOf(min));
				BigInteger b = new BigInteger(String.valueOf(max));
				BigInteger c;
				for (Product p : list) {
					p.calculate();
					switch (type) {
					case 1:
						c = p.getPrice();
						break;
					case 2:
						c = p.getCalculateSubTotalNet();
						break;
					default:
						c = null;
						break;
					}
					if (c != null) {
						int i = a.compareTo(c);
						int j = b.compareTo(c);
						if (i <= 0 && j >= 0) {
							aux.add(p);
						}
					}
				}
			}
		}
		return aux;
	}
}
