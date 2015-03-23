package com.barthezzko.concurrent;


public class SimpleThread {

	public static void main(String [] args){
		Thread t = new Thread(new SimpleThread().new RunnableGoal());
		t.setDaemon(false);
		t.start();
	}
	
	
	class RunnableGoal implements Runnable {
		public void run() {
			
			while(true){
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}


