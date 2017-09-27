package com.shawn.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo3_Timer {
	public static void main(String[] args) {
		MyTimerTask myTimerTask = new MyTimerTask();
		
		Timer t = new Timer();
//		t.schedule(new MyTimerTask(), new Date(117, month, date, hrs, min, sec));
	}
}

class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Having breakfast in the morning...");
	}
	
}