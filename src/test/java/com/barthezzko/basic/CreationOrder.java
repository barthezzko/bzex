package com.barthezzko.basic;

import org.junit.Test;

public class CreationOrder {

	@Test
	public void testCreation(){
		Child c = new Child();
	}
}

class Parent {

	{
		System.out.println("Parent initializer");
	}
	static {
		System.out.println("Parent static initializer");
	}
	
	public Parent() {
		System.out.println("Parent constructor");
	}
}

class Child {
	{
		System.out.println("Child initializer");
	}
	static {
		System.out.println("Child static initializer");
	}
	
	public Child() {
		super();
		System.out.println("Parent constructor");
	}
}