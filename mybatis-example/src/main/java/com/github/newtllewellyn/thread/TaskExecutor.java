package com.github.newtllewellyn.thread;

import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskExecutor extends Thread {
	private static Logger log = Logger.getLogger(TaskExecutor.class.getName());
	private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	private static final int MAX_COUNT = 10;

	private Object lock = new Object();

	public void putIn(String temp) {
		if (queue.size() >= MAX_COUNT)
			synchronized (lock) {
				try {
					lock.wait();
//					Thread.currentThread().wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		queue.add(temp);
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	public void run() {
		while (true) {
			String temp = queue.remove();
			if (temp == null) {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			synchronized (lock) {
				lock.notifyAll();
			}
			// do something
			log.log(Level.INFO, "get " + temp);
		}
	}
}
