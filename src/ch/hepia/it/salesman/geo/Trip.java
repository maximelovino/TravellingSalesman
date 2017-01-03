package ch.hepia.it.salesman.geo;

import java.util.ArrayList;

/**
 * Class representing a trip
 */
public class Trip {
	private int[] trip;
	private Map map;

	/**
	 * Default constructor for Trip
	 * @param map	A map
	 */
	public Trip (Map map) {
		this.map = map;
		this.trip = new int[this.map.count()];
		for (int i = 0; i < trip.length; i++) {
			trip[i] = i;
		}
	}

	/**
	 * Copy constructor for a Trip
	 * @param trip	The trip we want to copy
	 */
	public Trip (Trip trip) {
		this.map = trip.map;
		this.trip = new int[trip.trip.length];
		for (int i = 0; i < this.trip.length; i++) {
			this.trip[i] = trip.trip[i];
		}
	}

	/**
	 * Fitness function for our problem
	 * @return	The total length of the trip
	 */
	public double getTotalLength(){
		double distance = 0;
		for (int i = 0; i < trip.length; i++) {
			distance += map.getCity(trip[i]).distanceTo(map.getCity(trip[(i+1) % trip.length]));
		}
		return distance;
	}

	/**
	 * @return	The string representation of the trip
	 */
	@Override
	public String toString () {
		String str = "[";
		for (int i = 0; i < trip.length; i++) {
			str += trip[i];
			if (i != trip.length-1) str += ",";
		}
		str += "]";
		return str;
	}

	/**
	 * @return	A list of "neighbours" of the current trip, that is all the trips obtained by swapping two cities
	 */
	public ArrayList<Trip> neighbours(){
		ArrayList<Trip> toReturn = new ArrayList<>();
		for (int i = 0; i < this.trip.length; i++) {
			for (int j = i+1; j < this.trip.length; j++) {
				Trip newTrip = new Trip(this);
				newTrip.swapTwoCities(i,j);
				toReturn.add(newTrip);
			}
		}
		return toReturn;
	}

	/**
	 * Method to swap cities in the trip
	 * @param idxA	The first index to swap
	 * @param idxB	The second index to swap
	 */
	private void swapTwoCities(int idxA, int idxB){
		int temp = this.trip[idxA];
		this.trip[idxA] = this.trip[idxB];
		this.trip[idxB] = temp;
	}

	/**
	 * @param idx	An index in the trip
	 * @return		The city at that index in the trip
	 */
	public City getStopFromTrip(int idx){
		return map.getCity(this.trip[idx]);
	}

	/**
	 * Method to change the map and reset a basic trip for it
	 * @param map	The new map
	 */
	public void changeMap(Map map){
		this.map = map;
		this.trip = new int[this.map.count()];
		for (int i = 0; i < trip.length; i++) {
			trip[i] = i;
		}
	}
}
