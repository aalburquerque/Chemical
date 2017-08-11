package com.aalburquerque.ChemicalECHA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ECValidator {

	private static final String PATTERN = "^[1-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9]$";
	private static Pattern pattern = Pattern.compile(PATTERN);

	public static boolean validate(String cadena) throws ParseException {
		return validate(cadena, true);
	}

	public static boolean validate(String cadena, boolean checkDigit) throws ParseException {
		// si es cadena vacia entonces no es valida
		if (cadena == null || cadena.trim().length() == 0)
			throw new ECParseException("EC Number Vacio", 0);

		boolean validateEC = false;

		if (CadenaValidator.validate(cadena)) {

			Matcher matcher = pattern.matcher(cadena);
			validateEC = matcher.matches();

			if (validateEC) {
				if (!checkDigit)
					return true;

				// checksum digit
				String str = cadena.substring(0, 7);
				String ec_checksum_digit = calc(str.replaceAll("-", ""));
				validateEC = ec_checksum_digit.equals(cadena.subSequence(8, 9));
				if (validateEC) {
					return true;
				}
			}

		}

		return false;
	}

	private static final String calc(String digStr) {
		int len = digStr.length();
		int sum = 0, rem = 0;
		int[] digArr = new int[len];
		for (int k = 1; k <= len; k++)
			// compute weighted sum
			sum += (11 - k) * Character.getNumericValue(digStr.charAt(k - 1));
		if ((rem = sum % 11) == 0)
			return "0";
		else if (rem == 1)
			return "1"; // X
		return (new Integer(11 - rem)).toString();
	}

}
