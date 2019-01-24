package com.Farm;

import org.testng.asserts.SoftAssert;

public class Assertion extends Base{
	
	static SoftAssert assert1 = new SoftAssert(); 
	
	public static void assertTrue(Boolean result){
		sAssert.assertTrue(result,"Expected conditions successfull");
	}
	

	public static void assertFalse(Boolean result){
		sAssert.assertFalse(result);
	}
	
	
	public static void assertString(String actual, String expected){
		sAssert.assertEquals(actual, expected);
	}
}
