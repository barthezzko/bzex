package com.barthezzko.java8.streams;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SimpleOperationsTest {

	private Logger logger = Logger.getLogger(SimpleOperationsTest.class);

	private final List<String> employees = Arrays.asList(new String[] { "Mike", "YuriK", "YuriP", "Alex", "Arkadiy" });

	@Test
	public void test() {
		assertEquals(3, employees.stream().map(s -> {
			logger.info("name: " + s);
			return s.length();
		}).filter(num -> {
			logger.info("str length: " + num);
			return num > 4;
		}).count());
	}

}
