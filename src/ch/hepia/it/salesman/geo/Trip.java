package ch.hepia.it.salesman.geo;

import java.util.ArrayList;

public class Trip {
	private int[] trip;
	private Map map;

	public Trip (Map map) {
		this.map = map;
		this.trip = new int[this.map.count()];
		for (int i = 0; i < trip.length; i++) {
			trip[i] = i;
		}
	}

	public Trip (Trip trip) {
		this.map = trip.map;
		this.trip = new int[trip.trip.length];
		for (int i = 0; i < this.trip.length; i++) {
			this.trip[i] = trip.trip[i];
		}
	}

	public double getTotalLength(){
		double distance = 0;
		for (int i = 0; i < trip.length; i++) {
			distance += map.getCity(trip[i]).distanceTo(map.getCity(trip[(i+1) % trip.length]));
		}
		return distance;
	}

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

	public void swapTwoCities(int idxA, int idxB){
		int temp = this.trip[idxA];
		this.trip[idxA] = this.trip[idxB];
		this.trip[idxB] = temp;
	}

	public City getStopFromTrip(int idx){
		return map.getCity(this.trip[idx]);
	}
}
