package com.aalburquerque.ChemicalCAS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CASValidator {

	private static final String CAS_PATTERN = "^[1-9]\\d{1,6}-\\d{2}-\\d{1}$";

	public static boolean validate(String cadena) throws ParseException {
		// si es cadena vacia entonces no es valida	
		if (cadena == null || cadena.trim().length() == 0)
			throw new CASParseException("CAS Number Vacio",0);	
			
		// verificar si cumple el formato de un CAS y el digito de control
		ParseException validateCASException=null;
		boolean validateCAS=false;
		try{ 
			validateCAS=validateCAS(cadena,true);
		} catch (ParseException e) {
			validateCASException=e;
		}
		
		return validateCAS;
	}

	private static boolean validateCAS(String cadena, boolean checkDigit) throws ParseException {
		
		boolean result = false;
		Pattern pattern = Pattern.compile(CAS_PATTERN);
		Matcher matcher = pattern.matcher(cadena);
		result = matcher.matches();

		if (!result)
			throw new ParseException(cadena, 0);
		else if (!checkDigit)
			return true;

		// checksum digit
		String[] partes = cadena.split("-");
		String ec_checksum_digit = calc(partes[0] + partes[1]);
		result = partes[2].equals(ec_checksum_digit);
		return result;
	}

	public static final String calc(String digStr) {
		if (digStr == null || digStr.length() == 0) {
			return "";
		}

		long sum = 0;
		for (int i = digStr.length(); i > 0; i--) {
			sum += Long.parseLong(digStr.substring(i - 1, i)) * (digStr.length() - i + 1);
		}
		return Long.toString(sum % 10);

	}

}
