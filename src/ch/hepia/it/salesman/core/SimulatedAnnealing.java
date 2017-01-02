package ch.hepia.it.salesman.core;

import ch.hepia.it.salesman.geo.Trip;

import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing {
	private static final int INITIAL_TEMP = 100000;
	private static final double COOLING_RATE = 0.003;
	private double currentTemp;
	private Trip trip;
	private Random rnd;

	public SimulatedAnnealing (Trip trip) {
		this.trip = trip;
		rnd = new Random();
		currentTemp = INITIAL_TEMP;
	}

	public Trip computeBestTrip(){
		while(currentTemp > 1){
			ArrayList<Trip> neighbours = trip.neighbours();
			Trip tmp = neighbours.get(rnd.nextInt(neighbours.size()));
			trip = p(tmp,trip) ? tmp : trip;
			currentTemp *= (1-COOLING_RATE);
		}
		return trip;
	}

	private double tempFunction(double fitA, double fitB){
		return Math.exp((fitB-fitA)/currentTemp);
	}

	private boolean p(Trip a, Trip current){
		double fitA = a.getTotalLength();
		double fitCurrent = current.getTotalLength();

		if (fitA < fitCurrent)
			return true;

		double tmp = rnd.nextDouble();
		double tempFuncValue = tempFunction(fitA,fitCurrent);
		return tmp <= tempFuncValue;
	}
}
