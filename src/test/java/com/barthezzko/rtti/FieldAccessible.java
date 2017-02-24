package com.barthezzko.rtti;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class FieldAccessible {

	@Test
	@Ignore //broken
	public void test() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		PrivateFinalFields pff = new PrivateFinalFields();
		//PrivateFinalFields.class.getDeclaredField("firstName").set(pff, "Irina");
		//PrivateFinalFields.class.getDeclaredField("lastName").set(pff, "Plaksina");
		assertEquals("Mikhail", pff.getFirstName());
		assertEquals("Baytsurov", pff.lastName);
		PrivateFinalFields.class.getDeclaredField("firstName").setAccessible(true);
		PrivateFinalFields.class.getDeclaredField("lastName").setAccessible(true);
		PrivateFinalFields.class.getDeclaredField("firstName").set(pff, "Irina");
		PrivateFinalFields.class.getDeclaredField("lastName").set(pff, "Plaksina");
		assertEquals("Irina", pff.getFirstName());
		assertEquals("Baytsurov", pff.lastName);
	}
	
}

class PrivateFinalFields{
	
	private String firstName = "Mikhail";
	final String lastName = "Baytsurov";
	public String getFirstName() {
		return firstName;
	}
	
}
