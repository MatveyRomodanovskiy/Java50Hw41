package telran.threads.controller;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

import telran.threads.tasks.Racer;

public class Race {
	public static Instant startTime;
	Racer[] racers;
	int distance;
	public static ArrayList <Racer> prizePlaces;
	
	
	public Race (int numberOfRacers, int distance) {
		this.racers = new Racer[numberOfRacers];
		prizePlaces = new ArrayList<>();
		for (int i = 0; i < numberOfRacers; i++) {
			racers[i] = new Racer("thread #" + (i + 1), distance);	
		}
	
	}
	/**
	 * @return the racers
	 */
	public Racer[] getRacers() {	
		return Arrays.copyOf(racers, racers.length);
	}
	
	/**
	 * @add the prizePlaces
	 */
	synchronized public static void addPrizePlace(Racer racer) {
		prizePlaces.add(racer);
		racer.setTimeResult( ChronoUnit.MILLIS.between(Race.startTime, Instant.now()));
	}
	
	/**
	 * @return the prizePlaces
	 */
	public ArrayList<Racer> getPrizePlaces() {
		 return new ArrayList<>(prizePlaces);
	}
	
}
