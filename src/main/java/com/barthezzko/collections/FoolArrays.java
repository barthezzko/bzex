package com.barthezzko.collections;

import org.junit.Test;

public class FoolArrays {

	@Test
	public void foo() {
		Cat[] cats = { new Cat(), new Cat() };
		addAnimal(cats); // no problem, send the Cat[] to the method
	}

	public void addAnimal(Animal[] animals) {
		animals[0] = new Dog(); // Eeek! We just put a Dog
	}

	public static class Animal {
	}

	public static class Cat extends Animal {
	}

	public static class Dog extends Animal {
	}
}
