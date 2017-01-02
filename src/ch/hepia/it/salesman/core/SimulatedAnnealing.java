package ch.hepia.it.salesman.core;

import ch.hepia.it.salesman.geo.Trip;
import ch.hepia.it.salesman.gui.MapView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class containing the implementation of the simulated annealing algorithm
 */
public class SimulatedAnnealing {
	private static final int INITIAL_TEMP = 100000;
	private static final double COOLING_RATE = 0.003;
	private double currentTemp;
	private Trip trip;
	private Random rnd;
	private MapView view;

	/**
	 * @param trip	The start trip of our simulation
	 * @param view	The view (to update it with every trip)
	 */
	public SimulatedAnnealing (Trip trip, MapView view) {
		this.trip = trip;
		this.view = view;
		rnd = new Random();
		currentTemp = INITIAL_TEMP;
	}

	/**
	 * Simulated annealing to return the best trip (heuristicly)
	 * @return	The best trip
	 */
	public Trip computeBestTrip(){
		while(currentTemp > 1){
			ArrayList<Trip> neighbours = trip.neighbours();
			Trip tmp = neighbours.get(rnd.nextInt(neighbours.size()));
			if (p(tmp,trip)){
				trip = tmp;
				view.setTrip(trip);
				System.out.println("Current best trip: "+trip+" total distance of trip: "+trip.getTotalLength());
			}
			currentTemp *= (1-COOLING_RATE);
		}
		return trip;
	}

	/**
	 * @param fitA	The fitness function of A
	 * @param fitB	The fitness function of B
	 * @return		The probabilistic value of the change
	 */
	private double tempFunction(double fitA, double fitB){
		return Math.exp((fitB-fitA)/currentTemp);
	}

	/**
	 * @param a			The trip we are looking to switch to
	 * @param current	The current trip
	 * @return			If we should switch or not
	 */
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
