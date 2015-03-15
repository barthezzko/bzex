package com.barthezzko.collections;

import java.util.ArrayList;
import java.util.List;

public class TestBadLegacy {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(6);
		//myList.add("aaa"); //<-- can't do that 
		Inserter in = new Inserter();
		in.insert(myList); // pass List<Integer> to legacy code
	}
}

class Inserter {
	// method with a non-generic List argument
	void insert(List list) {
		list.add(new Integer(42)); // adds to the incoming list
		//Type erasure!!!
		list.add(new String("42"));
	}
}