package telran.threads.controller;


import java.util.concurrent.atomic.AtomicInteger;

import telran.threads.tasks.Racer;

public class Race {
	Racer[] racers;
	int distance;
	public static AtomicInteger winner = new AtomicInteger();
	
	public Race (int numberOfRacers, int distance) {
		this.racers = new Racer[numberOfRacers];
		for (int i = 0; i < numberOfRacers; i++) {
			racers[i] = new Racer(i + 1, distance);	
		}
		winner.set(-1);
	}
	/**
	 * @return the racers
	 */
	public Racer[] getRacers() {	
		return racers;
	}
	
	public static void setWinner(int name) {
		winner.compareAndExchange(-1, name);
	}
	
	public int getWinner() {
		return winner.get();
	}
	
}
