package com.github.newtllewellyn.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import com.github.newtllewellyn.thread.TaskExecutor;

public class TaskExecutorTest {
	private TaskExecutor te = null;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void test() {
		te = new TaskExecutor();
		te.start();
		for(int i = 0; i<200; i++) {
			te.putIn(UUID.randomUUID().toString());
		}
		
//		fail("Not yet implemented");
	}
	
	@After
	public void stop() {
		te.stop();
	}

}
