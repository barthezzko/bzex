package com.barthezzko.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubmitAfterShutdown {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(new Runnable() {
			public void run() {
				for (int i=0;i<10;i++){
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		service.shutdown();
		System.out.println("shutdown");
		service.submit(new Runnable() {
			public void run() {
				for (int i=0;i<10;i++){
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}
