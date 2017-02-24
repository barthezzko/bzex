package com.barthezzko.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ESShutdown {

	@Test
	public void test() throws InterruptedException{
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i=0;i<100;i++){
			es.submit(new Task(i));
		}
		TimeUnit.SECONDS.sleep(2);
		es.shutdown();
		TimeUnit.SECONDS.sleep(200);
	}
	
}
class Task implements Runnable{

	private final int i;
	
	public Task(int i) {
		this.i=i;
	}

	public void run() {
		try {
			TimeUnit.SECONDS.sleep(10);
			System.out.println(i + " done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println(i+ " interrupted");
		}
	}
	
}
