package com.barthezzko.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Latches {

	private static CountDownLatch latch = new CountDownLatch(3);  
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = ()->{
			System.out.println("before latch");
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("after latch released");
		};
		new Thread(r).start();
		new Thread(r).start();
		for (int i=0; i<3;i++){
			latch.countDown();
			System.out.println("countdown");
			TimeUnit.SECONDS.sleep(1);
		}
		
	}
	
	
}
