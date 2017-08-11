package com.aalburquerque.ChemicalECHA;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;


@RunWith(JUnit4ClassRunner.class)
public class ECValidatorTest {

	@Test
	public void validateEC_OK() throws ParseException {
		final String VALID_CODE = "500-776-5";
		assertTrue(ECValidator.validate(VALID_CODE, true));
	}

	@Test
	public void validateEC_OK2() throws ParseException {
		final String VALID_CODE = "434-020-1";
		assertTrue(ECValidator.validate(VALID_CODE, true));
	}

	@Test
	public void validateEC_OK4() throws ParseException {
		final String VALID_CODE = "111-222-3";
		assertTrue(ECValidator.validate(VALID_CODE, true));
	}

	@Test
	public void validateEC_CheckDigit_NOK() throws ParseException {
		final String INVALID_CODE_BY_CHECKSUM = "500-776-4";
		assertFalse(ECValidator.validate(INVALID_CODE_BY_CHECKSUM, true));
	}

	@Test
	public void validateECNull() throws ParseException {
		validateFalse(null);
	}

	@Test
	public void validateECEmpty() throws ParseException {
		validateFalse("--");
	}

	@Test
	public void validateCadenaBlanks() throws ParseException {
		validateFalse("");
	}

	@Test
	public void validateFormatoIncorrecto() throws ParseException {
		validateFalse("00212343");

	}

	@Test
	public void validateFormatoSoloUnGuion() throws ParseException {
		validateFalse("123-1");
	}

	@Test
	public void validateFormatoIncorrectoExcesivosDigitos() throws ParseException {
		validateFalse("1234-123-1");
	}

	@Test
	public void validateFormatoIncorrectoDigitosIntermedios() throws ParseException {
		validateFalse("123-1234-1");
	}

	@Test
	public void validateFormatoIncorrectoDigitosFinales() throws ParseException {
		validateFalse("123-123-12");

	}

	private void validateFalse(String cadena) {
		try {
			Assert.assertFalse(ECValidator.validate(cadena));
		} catch (ParseException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	private void validateTrue(String cadena) {
		try {
			Assert.assertTrue(ECValidator.validate(cadena));
		} catch (ParseException e) {
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	// FORMATOS SIT
	static String[] VALID_SIT_NUMBER_ARRAY = { "013-34-0", "034-00-2", "010-0-0", "020-00-1", "033-33-3", "044-56-1",
			"030-99-1" };

	
}
