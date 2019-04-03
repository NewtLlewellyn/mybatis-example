package com.github.newtllewellyn.thread;

import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskExecutor extends Thread {
	private static Logger log = Logger.getLogger(TaskExecutor.class.getName());
	private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	private static final int MAX_COUNT = 3;

	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public void putIn(String temp) {
		try {
			lock.lock();
			if (queue.size() >= (MAX_COUNT))
				try {
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			queue.add(temp);
//			full.notify();
			notEmpty.signalAll();
			log.log(Level.INFO, "put in " + temp);
		} finally {
			lock.unlock();
		}

//		if (queue.size() >= MAX_COUNT)
//			lock.lock();
//		queue.add(temp);
//		log.log(Level.INFO, "put in "+ temp);		
	}

	public void run() {
		while (true) {
			lock.lock();
			try {
				String temp = null;
				if (queue.isEmpty()) {
					try {
						notEmpty.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				temp = queue.remove();
				notFull.signalAll();
				log.log(Level.INFO, "get " + temp);
			} finally {
				lock.unlock();
			}
		}
//		while (true) {
//			String temp = null;
//			if (!queue.isEmpty()) {
//				temp = queue.remove();
//			}
//			if (temp == null) {
//				lock.lock();
//			}

//			lock.isHeldByCurrentThread();

		// do something
//			log.log(Level.INFO, "get " + temp);

	}
}
