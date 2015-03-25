package com.barthezzko.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTask {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		Callable<Integer> callableTask = new Callable<Integer>() {
			public Integer call() throws Exception {
				for (int i = 0; i < 50; i++) {
					Thread.sleep(100);
				}
				return 1;
			}
		};
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<Integer> result = exec.submit(callableTask);

		exec.shutdownNow();
		Thread.sleep(2000);
		System.out.println("cancel");
		result.cancel(true);
		System.out.println("canceled");
		while (!result.isDone()) {
			System.out.println("check");
			Thread.sleep(100);
		}
		System.out.println(result.get());
	}

}
