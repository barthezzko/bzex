package com.barthezzko.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PropagateCancel {
	
	/**
	 * Don't get it
	 * */

	private static ExecutorService execService = Executors.newSingleThreadExecutor(); 
	
	public static void main(String[] args) throws InterruptedException {
		Callable<String> cal = () -> {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			return "OK";
		};
		
		Future<String> fut  = execService.submit(cal);
		execService.shutdown();
		TimeUnit.SECONDS.sleep(3);
		fut.cancel(true);
	}
}
