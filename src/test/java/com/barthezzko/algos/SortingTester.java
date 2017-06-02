package com.barthezzko.algos;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class SortingTester {

	private Map<Integer, int[]> inputData = new HashMap<>();
	private int[] sizes = { 10, 100, 1_000};
	private Random rnd = new Random();
	private Logger logger = Logger.getLogger(SortingTester.class);
	private Sorting sorting = new InsertionSorting();
	int prev = 0;
	
	@Before
	public void before() {
		logger.info("starting filling arrays");
		for (int size : sizes) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = rnd.nextInt(size);
			inputData.put(size, array);
		}
		logger.info("data set");

	}

	@Test
	public void test(){
		inputData.entrySet().forEach(e->{
			prev = Integer.MIN_VALUE;
			logger.info("Checking for size: " + e.getKey());
			int[] arrayIn = e.getValue();
			logger.info(Arrays.toString(arrayIn));
			int[] sorted = sorting.sort(arrayIn);
			for(int k=0; k<sorted.length; k++){
				assertTrue("order is invalid: " + prev + " <-" + sorted[k], prev <= sorted[k]);
				prev = sorted[k];
			}
		});
	}

}
