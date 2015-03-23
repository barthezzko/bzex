package com.barthezzko.concurrent;

import org.junit.Test;

public class FailedDoubleStart {

	@Test(expected=IllegalThreadStateException.class)
	public void startTest(){
		Thread t = new Thread();
		t.start(); 
		t.start();
	} 
	
	
}
