package com.barthezzko.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphores {

	private static Semaphore semaphore = new Semaphore(0);
	
	public static void main(String[] args) throws InterruptedException {
		for (int i=0;i<10;i++){
			final int k = i;
		new Thread(()->{
				try {
					System.out.println("before executing query: " + k);
					semaphore.acquire();
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Executed query " + k);
				
				semaphore.release();
			}).start();
		}
		semaphore.release(2);
		System.out.println("DB pool size: " + semaphore.availablePermits());
	}
}
