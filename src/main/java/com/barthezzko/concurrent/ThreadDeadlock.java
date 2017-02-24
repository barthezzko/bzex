package com.barthezzko.concurrent;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadDeadlock {
	
	static ExecutorService exec = Executors.newSingleThreadExecutor();

	public class RenderPageTask implements Callable<String> {
		public String call() throws Exception {
			Future<String> header, footer;
			header = exec.submit(new LoadFileTask("header.html"));
			footer = exec.submit(new LoadFileTask("footer.html"));
			String page = "body here";
			// Will deadlock -- task waiting for result of subtask
			return header.get() + page + footer.get();
		}
	}
	
	public static void main(String[] args) {
		ThreadDeadlock tdl = new ThreadDeadlock();
		exec.submit(tdl.new RenderPageTask());
	}
	
}
class LoadFileTask implements Callable<String> {

	final String path;
	
	public LoadFileTask(String path) {
		this.path = path;
	}
	
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(1);
		return path + " body";
	}
	
}