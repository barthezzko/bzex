package com.barthezzko.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;


public class QueueMultiT {

	private static PriorityBlockingQueue<String> tasks = new PriorityBlockingQueue<String>();
	//private static LinkedBlockingQueue<String> tasks = new LinkedBlockingQueue<String>();
	private static ExecutorService execService = Executors.newSingleThreadExecutor(); 
	private static volatile boolean stopThis = false;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread(); 
		execService.submit(() -> {
			for (TeamMates mate : TeamMates.values()){
				try {
					tasks.put(mate.name());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			stopThis = true;//will not work. already blocked for taking
			t.interrupt();
		});
		execService.shutdown();
		TimeUnit.SECONDS.sleep(3);
		
		while(!stopThis){
			System.out.println(tasks.take());	
		}
	}
	
	
	static enum TeamMates{
		Mike,
		Lev,
		Lesha,
		YuriP,
		YuriK,
		Arkadiy
	} 	
}

