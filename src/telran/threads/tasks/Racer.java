package telran.threads.tasks;


import java.util.*;

import telran.threads.controller.Race;

public class Racer extends Thread  {
	private String nameThread;
	private int distance;
	static int minSleepTime = 2;
	static int maxSleepTime = 4;
	static Random random = new Random();
	long timeResult;
	
	public Racer(String name, int distance) {
		this.nameThread = name;
		this.distance = distance;
		
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return timeResult;
	}

	/**
	 * @param l the timeResult to set
	 */
	public void setTimeResult(long l) {
		this.timeResult = l;
	}

	@Override
	public void run() {
		System.out.println(nameThread + " start...");
		for (int i = 0; i < distance; i++) {
			if (i<distance-1) {
				System.out.println(nameThread + ", finished " + (i + 1) + " loop ");
			}
			try {
				int sleepTime = minSleepTime + random.nextInt(maxSleepTime + 1 - minSleepTime);
				sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				Race.addPrizePlace(this);
	}


	/**
	 * @return the name
	 */
	public String getThreadName() {
		return nameThread;
	}


	

}
