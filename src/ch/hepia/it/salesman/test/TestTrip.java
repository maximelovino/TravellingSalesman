package ch.hepia.it.salesman.test;

import ch.hepia.it.salesman.geo.Map;
import ch.hepia.it.salesman.geo.Trip;

public class TestTrip {
	public static void main (String[] args) {
		Map map = new Map(10,100,100);
		map.generateRandomCities();
		Trip trip = new Trip(map);
		System.out.println(map);
		System.out.println("Total distance: "+trip.getTotalLength());
	}
}
