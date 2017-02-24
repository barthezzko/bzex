package com.barthezzko.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringTests {
	
	@Test
	public void testEmptyString(){
		String s = "";
		assertEquals(true, s.isEmpty());
	}
	
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void npeisEmpty(){
		String s = null;
		assertEquals(true, s.isEmpty()); //Don't do this
	}

}
