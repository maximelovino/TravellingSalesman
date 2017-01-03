package ch.hepia.it.salesman;

import ch.hepia.it.salesman.core.SimulatedAnnealing;
import ch.hepia.it.salesman.geo.Map;
import ch.hepia.it.salesman.geo.Trip;
import ch.hepia.it.salesman.gui.MapView;

import javax.swing.*;
import java.awt.*;

/**
 * Launcher class of our program
 */
public class Salesman {
	public static void main (String[] args) throws InterruptedException {
		Map map = new Map(10,100,100);
		map.generateRandomCities();
		Trip trip = new Trip(map);
		System.out.println(map);
		JFrame frame = new JFrame("Travelling salesman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		MapView view = new MapView(map, trip);


		// ############ HEADER CREATION ##################
		JPanel header = new JPanel(new FlowLayout());
		JButton generateCities = new JButton("Generate new cities");
		JButton launchButton = new JButton("Launch computation");
		JLabel distanceLabel = new JLabel("Total Distance: ");
		JLabel distanceValue = new JLabel(String.format("%.3f km", trip.getTotalLength()));

		header.add(generateCities);
		header.add(launchButton);
		header.add(distanceLabel);
		header.add(distanceValue);

		// ############ ADDING TO FRAME ##################
		frame.getContentPane().add(view,BorderLayout.CENTER);
		frame.getContentPane().add(header,BorderLayout.PAGE_START);
		frame.pack();
		frame.setSize(1000,1000);
		frame.setVisible(true);

		// ############ LISTENERS AND HANDLERS ##################
		launchButton.addActionListener(e -> {
			SimulatedAnnealing sim = new SimulatedAnnealing(new Trip(trip), view);
			Trip bestTrip = sim.computeBestTrip();
			double length = bestTrip.getTotalLength();
			System.out.println("The best is: "+bestTrip+" total distance "+length);
			distanceValue.setText(String.format("%.3f km", length));
			view.setTrip(bestTrip);
		});

		generateCities.addActionListener(e -> {
			map.generateRandomCities();
			trip.changeMap(map);
			distanceValue.setText(String.format("%.3f km", trip.getTotalLength()));
			view.setTrip(trip);
		});
	}
}
