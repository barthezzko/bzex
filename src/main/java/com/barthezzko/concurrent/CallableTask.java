package com.barthezzko.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> callableTask = new Callable<Integer>() {

			public Integer call() throws Exception {
				Thread.sleep(5000);
				return 1;
			}
		};
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<Integer> result =  exec.submit(callableTask);
		while (!result.isDone()){
			System.out.println("check");
			Thread.sleep(100);
		}
		System.out.println(result.get());
		exec.shutdownNow();
		
	}
	
	
}
