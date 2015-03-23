package com.barthezzko.concurrent;

public class Interrupted {

	public static void main(String[] args) throws InterruptedException {
		Runnable interruptableCounter = new Runnable() {
			
			public void run() {
				while(!Thread.interrupted()){
					System.out.println("heartbeat");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			}
		};
		Thread t = new Thread(interruptableCounter);
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}

}
