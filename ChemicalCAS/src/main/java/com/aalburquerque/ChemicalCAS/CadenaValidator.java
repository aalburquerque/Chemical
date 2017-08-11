package com.aalburquerque.ChemicalCAS;

import org.apache.commons.lang.StringUtils;

public class CadenaValidator {

	public static boolean esVaciaONulo(String cadena) {
		return StringUtils.isBlank(cadena);
	}

	public static boolean validate(String cadena) {
		return StringUtils.isNotBlank(cadena);
	}

}
