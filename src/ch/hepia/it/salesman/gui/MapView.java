package ch.hepia.it.salesman.gui;

import ch.hepia.it.salesman.geo.Coordinates;
import ch.hepia.it.salesman.geo.Map;
import ch.hepia.it.salesman.geo.Trip;

import javax.swing.*;
import java.awt.*;

public class MapView extends JPanel {
	private Map map;
	private Trip trip;
	private final static int CIRCLE_RADIUS = 10;

	public MapView (Map map, Trip trip) {
		this.map = map;
		this.trip = trip;
		this.setPreferredSize(new Dimension(1000,1000));
	}

	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		int cnt = map.count();
		g.setColor(Color.BLACK);
		g.drawRect(0,0,1000,1000);
		g.setColor(Color.RED);
		System.out.println("Trip from view "+trip);
		for (int i = 0; i < cnt; i++) {
			Coordinates tmpCity = trip.getStopFromTrip(i);
			Coordinates nextCity = trip.getStopFromTrip((i+1) % cnt);
			g.drawOval(tmpCity.getX()*10-CIRCLE_RADIUS/2,tmpCity.getY()*10-CIRCLE_RADIUS/2,CIRCLE_RADIUS,CIRCLE_RADIUS);
			g.drawLine(tmpCity.getX()*10,tmpCity.getY()*10,nextCity.getX()*10,nextCity.getY()*10);
		}
	}

	public void setTrip (Trip trip) {
		this.trip = trip;
		this.repaint();
	}
}
