package com.barthezzko.concurrent;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Barriers {

	private static int NUMBER_OF_THREADS = 3;
	private static CyclicBarrier cb = new CyclicBarrier(NUMBER_OF_THREADS);
	private static Random coalaCountingService = new Random();
	private static ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
	private static Map<String, Future<Integer>> results = new HashMap<>();
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		BigDecimal result = BigDecimal.ZERO;
		for(int i=0;i<NUMBER_OF_THREADS-1;i++){
			final int k = i;
			Callable<Integer> countingTask = ()->{
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("before blocking " + k);
					cb.await();
					System.out.println("after releasing " + k);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return coalaCountingService.nextInt(100_000);
			};
			Future<Integer> countingFuture = executor.submit(countingTask);
			results.put("counterTask " + k, countingFuture);
			TimeUnit.SECONDS.sleep(1);
		}
		executor.shutdown();
		cb.await();
		System.out.println("Total task no: " + results.size());
		results.values().forEach(v->{
			try {
				result.add(BigDecimal.valueOf(v.get()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("Result: " + result);
	}
	
}
