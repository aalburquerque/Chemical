package com.aalburquerque.ChemicalECHA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;


@RunWith(JUnit4ClassRunner.class)
public class ECRaroValidatorTest {

	static String[] VALID_CAS_NUMBER_ARRAY = { 
		"01-000-0",
		"0-000-0",
		"0-0-0",
		"0-00-0",
		"0-000-0",
		"00-00-0",
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
	public void validateChekDigit_NOk_N() {		
		int total=0;
		for (int i = 0; i < VALID_CAS_NUMBER_ARRAY.length; i++) {
			try {
				if (!ECValidator.validate(VALID_CAS_NUMBER_ARRAY[i])){
					total++;
				}
			} catch (ParseException e) {
				total++;
			} catch (Exception e){
				Assert.assertTrue(false);
			}
		}
		Assert.assertTrue(total==VALID_CAS_NUMBER_ARRAY.length);
	}



}
