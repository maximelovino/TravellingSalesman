package ch.hepia.it.salesman;

import ch.hepia.it.salesman.core.SimulatedAnnealing;
import ch.hepia.it.salesman.geo.Map;
import ch.hepia.it.salesman.geo.Trip;
import ch.hepia.it.salesman.gui.MapView;

import javax.swing.*;
import java.util.ArrayList;

public class Salesman {
	public static void main (String[] args) throws InterruptedException {
		Map map = new Map(10,100,100);
		map.generateRandomCities();
		Trip trip = new Trip(map);
		System.out.println(map);
		System.out.println(trip);
		JFrame frame = new JFrame("Travelling salesman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MapView view = new MapView(map, trip);
		frame.add(view,"Center");
		frame.setSize(1000,1000);
		frame.setVisible(true);

		SimulatedAnnealing sim = new SimulatedAnnealing(new Trip(trip));
		Trip bestTrip = sim.computeBestTrip();
		System.out.println("The best is: "+bestTrip+" total distance "+bestTrip.getTotalLength());
		view.setTrip(bestTrip);
	}
}
