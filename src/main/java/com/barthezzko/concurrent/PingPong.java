package com.barthezzko.concurrent;

public class PingPong {

	public static void main(String[] args) {
		final Object obj = new Object();
		Runnable player1 = new Runnable() {
			public void run() {
				while (!Thread.interrupted()) {
					synchronized(obj){
						System.out.println("ping");
						try {
							obj.notify();
							obj.wait();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}

				}

			}
		};
		Runnable player2 = new Runnable() {
			public void run() {
				while (!Thread.interrupted()) {
					synchronized(obj){
						System.out.println("pong");
						try {
							obj.notify();
							obj.wait();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}

				}

			}
		};
		Thread t = new Thread(player1);
		Thread t2 = new Thread(player2);
		t.start();
		t2.start();

	}
}
