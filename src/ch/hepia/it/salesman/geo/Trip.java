package ch.hepia.it.salesman.geo;

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

	public double getTotalLength(){
		double distance = 0;
		for (int i = 0; i < trip.length; i++) {
			distance += map.getCity(trip[i]).distanceTo(map.getCity(trip[(i+1) % trip.length]));
		}
		return distance;
	}

}
