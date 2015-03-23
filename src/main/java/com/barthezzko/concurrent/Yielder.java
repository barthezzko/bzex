package com.barthezzko.concurrent;

public class Yielder {
	
	public static void main(String[] args) {
	
		Runnable yielder = new Runnable() {
			public void run() {
				for (int i=0;i<10;i++){
					System.out.println(Thread.currentThread().getName() + "  "+i);
					Thread.yield();
				}
			}
		};
		Thread t = new Thread(yielder);
		Thread t2 = new Thread(yielder);
		t.start();
		t2.start();
	}
	
	
}
