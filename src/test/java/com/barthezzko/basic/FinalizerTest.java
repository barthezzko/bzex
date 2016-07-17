package com.barthezzko.basic;

import org.junit.Test;

public class FinalizerTest {
	
	@Test
	public void testFinalize(){
		B b = new B();
		b = null;
		System.gc();
	}

}

class A {
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize A");
		super.finalize();
	}
}

class B extends A {
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize B");
		super.finalize();
	}
}
