package ch.hepia.it.salesman.core;

import ch.hepia.it.salesman.geo.Trip;

import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing {
	private static final int INITIAL_TEMP = 1000;
	private int currentTemp;
	private Trip trip;
	private Random rnd;

	public SimulatedAnnealing (Trip trip) {
		this.trip = trip;
		rnd = new Random();
		currentTemp = INITIAL_TEMP;
	}

	public Trip computeBestTrip(){
		while(currentTemp > 0){
			ArrayList<Trip> neighbours = trip.neighbours();
			Trip tmp = neighbours.get(rnd.nextInt(neighbours.size()));
			trip = p(tmp,trip) ? tmp : trip;
			System.out.println(trip.getTotalLength());
			currentTemp--;
		}
		return trip;
	}

	private double tempFunction(double fitA, double fitB){
		return Math.exp(Math.abs(fitA-fitB)/currentTemp);
	}

	private boolean p(Trip a, Trip current){
		double fitA = a.getTotalLength();
		double fitCurrent = current.getTotalLength();

		if (fitA < fitCurrent)
			return true;

		double tmp = rnd.nextDouble();

		return tmp <= tempFunction(fitA, fitCurrent);
	}
}
