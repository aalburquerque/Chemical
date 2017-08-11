package com.aalburquerque.ChemicalECHA;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;


@RunWith(JUnit4ClassRunner.class)
public class ECValidatorDegeneradoTest {

	
	
		static String[] VALID_EC_NUMBER_MAESTRO_SIT_ARRAY = {
		"00-00-0",
		"000-000-0",		
		"000-00-0",
		"0000-00-0",
		"00000-00-0",
		"000000-00-0",
		"0000000-00-0",
		"000-00-0",
		"000-0-0",
		"00-00-0",
		"00-0-0",
		"0000000-0-0" , 
		"0000000-00-0",
		"00-11-1",
		"000-11-1",
		"0000-11-1",
		"00000-11-1",
		"000000-11-1",
		"0000000-11-1",
		"000-11-1",
		"000-1-1",
		"00-11-1",
		"00-1-1",
		"0000000-1-1" , 
		"0000000-11-1" 
	};

	@Test
	public void validateDegenerated() {
		boolean checkDigit = true;
		for (int i = 0; i < VALID_EC_NUMBER_MAESTRO_SIT_ARRAY.length; i++) {
			try{ 		
				assertFalse(ECValidator.validate(VALID_EC_NUMBER_MAESTRO_SIT_ARRAY[i], checkDigit));
			} catch (AssertionError e) {
				System.out.println(i + ":" + VALID_EC_NUMBER_MAESTRO_SIT_ARRAY[i]);
				throw e;
			} catch (ParseException e) {
				
			}
		}
		
	}


}
