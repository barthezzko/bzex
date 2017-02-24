package com.barthezzko.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashCodes {

	@Test
	public void testHC(){
		String ola = "ola";
		Integer ola2 = 12345;
		assertNotEquals(ola.hashCode(), System.identityHashCode(ola));
		assertNotEquals(ola2.hashCode(), System.identityHashCode(ola2));
	}
	
}
