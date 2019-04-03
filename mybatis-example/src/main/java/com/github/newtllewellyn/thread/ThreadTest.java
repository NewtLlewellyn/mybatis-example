package com.github.newtllewellyn.thread;

//import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTest {

	private static Logger log = Logger.getLogger(ThreadTest.class.getName());
	private static ReentrantLock lock = new ReentrantLock();
	private final static Condition notFull = lock.newCondition();
	private final static Condition notEmpty = lock.newCondition();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcurrentLinkedQueue<String> hole = new ConcurrentLinkedQueue<String>();
		int MAX_COUNT = 3;
//		Object lock = new Object();

		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("aaa Hello");
				while (true) {
					try {
						lock.lock();
						if (hole.size() >= MAX_COUNT) {
							try {
								notFull.await();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						String temp = UUID.randomUUID().toString();
						hole.add(temp);
						notEmpty.signalAll();
						log.log(Level.INFO, "put in " + temp);
					}finally {
						lock.unlock();
					}
//
//					if (hole.size() < MAX_COUNT) {
//						String temp = UUID.randomUUID().toString();
//						hole.add(temp);
//						log.log(Level.INFO, "put in " + temp);
//						synchronized (lock) {
//							lock.notifyAll();
//						}
//					} else
//						synchronized (lock) {
//							try {
//								lock.wait();
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//						}
				}

			}
		});
//		producer.setDaemon(true);
//		producer.setPriority(10);

		producer.start();

		Thread consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("bbb Hello");
				while (true) {
					try {
						lock.lock();
						if (hole.isEmpty())
							try {
								notEmpty.await();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						String temp = hole.remove();
						notFull.signalAll();
						log.log(Level.INFO, "get " + temp);
					}finally {
						lock.unlock();
					}
					
//					if (hole.size() > 0) {
//						String temp = hole.iterator().next();
//						hole.remove(temp);
//						log.log(Level.INFO, "get " + temp);
//
//						synchronized (lock) {
//							lock.notifyAll();
//						}
//					} else
//						synchronized (lock) {
//							try {
//								lock.wait();
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//
//						}
				}

			}
		});

		consumer.start();
//		try {
//			consumer.stop();
//			consumer.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
