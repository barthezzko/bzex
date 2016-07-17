package com.barthezzko.basic;

import org.junit.Test;

public class ObjectCreation {

	@Test
	public void test() {
		DftConstructor dft = new DftConstructor();
	}

	@Test
	public void test2() {
		// PrivateConstructor private = new PrivateConstructor(); <<< That will
		// not compile
	}

	@Test(expected=IllegalAccessException.class)
	public void test3() throws InstantiationException, IllegalAccessException {
		PrivateConstructor privateRunTime = PrivateConstructor.class.newInstance();
	}
	
	@Test(expected=Exception.class)
	public void test4() throws InstantiationException, IllegalAccessException {
		ExceptionInConstructor exception = ExceptionInConstructor.class.newInstance();
	}

}

class DftConstructor {

}

class PrivateConstructor {

	// private constructor
	private PrivateConstructor() {

	}
}

class ExceptionInConstructor{
	
	public ExceptionInConstructor() throws Exception {
		throw new Exception("can't create an instance");
	}
}