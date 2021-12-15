package com.pastley.util;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

/**
 * @project Pastley.
 * @author Sergio Stives Barrios Buitrago.
 * @Github https://github.com/SerBuitrago.
 * @contributors leynerjoseoa.
 * @version 1.0.0.
 */
public class PastleyValidate {

	/**
	 * Method that allows to validate the strings.
	 * 
	 * @param chain, Represents the string.
	 * @return Boolean true if it meets false if not.
	 */
	public static boolean isChain(String chain) {
		return chain != null && chain.trim().length() > 0;
	}

	/**
	 * Method that validates if a string contains pure numbers.
	 * 
	 * @param str, Represents the string.
	 * @return Boolean true if it meets false if not.
	 */
	public static boolean isNumber(String str) {
		if (isChain(str)) {
			char[] array = PastleyVariable.PASTLEY_ARRAY_NUMBER;
			char[] aux = str.toCharArray();
			for (char i : aux) {
				boolean salir = true;
				for (char j : array) {
					if (i == j) {
						salir = false;
					}
				}
				if (salir) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Method that allows to validate an object.
	 * @param object, Represents the object.
	 * @return Boolean true if it meets false if not.
	 */
	public static boolean isObject(Object object) {
		return object != null;
	}

	/**
	 * Method that allows to validate a long.
	 * @param value, Represents the value.
	 * @return Boolean true if it meets false if not.
	 */
	public static boolean isLong(Long value) {
		return value != null && value >= 0;
	}

	/**
	 * Method that converts a string to a number.
	 * @param str, Represents the string.
	 * @return the value number obtained.
	 */
	public static int toInteger(String str) {
		try {
			return Integer.valueOf(str);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	/*
	 * Method that allows knowing a value of an attribute of the path.
	 */
	public static String getAttributePath(String attribute) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(attribute);
	}

	/**
	 * Method that allows to verify if a list is valid.
	 * 
	 * @param <E>,  Represents the data type of the list.
	 * @param list, Represents the list.
	 * @return true if it meets false if not.
	 */
	public static <E> boolean isList(List<E> list) {
		return (list != null && list.size() > 0);
	}
	
	/**
	 * Method that allows verifying if a biginteger is greater than zero.
	 * 
	 * @param a, Represents the biginteger.
	 * @return true if it meets false if not.
	 */
	public static boolean bigIntegerHigherZero(BigInteger a) {
		return (a != null && a.compareTo(BigInteger.ZERO) == 1);
	}

	/**
	 * Method that allows verifying if a biginteger is less than zero.
	 * 
	 * @param a, Represents the biginteger.
	 * @return true if it meets false if not.
	 */
	public static boolean bigIntegerLessZero(BigInteger a) {
		return (a != null && a.compareTo(BigInteger.ZERO) == -1);
	}

	/**
	 * Method that allows verifying if a biginteger is greater than or equal to
	 * zero.
	 * 
	 * @param a, Represents the biginteger.
	 * @return true if it meets false if not.
	 */
	public static boolean bigIntegerHigherEqualZero(BigInteger a) {
		return (a != null && a.compareTo(BigInteger.ZERO) >= 0);
	}
	
	public static String getFace(String attribute) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(attribute);
	}
}
