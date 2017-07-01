package com.barthezzko;

public class Initializing {

	{
		System.out.println("Parent instance initializer");
	}
	static {
		System.out.println("Parent static initializer");
	}

	public Initializing() {
		System.out.println("Parent constructor");
	}

	public static void main(String[] args) {
		Child c = new Child();
		try {
			System.out.println("Created");
		} finally {

		}
	}

	static class Child extends Initializing {

		{
			System.out.println("Child instance initializer");
		}
		static {
			System.out.println("Child static initializer");
		}

		public Child() {
			System.out.println("Child constructor");
		}

	}
}
