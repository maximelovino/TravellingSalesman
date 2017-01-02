package ch.hepia.it.salesman.gui;

import ch.hepia.it.salesman.geo.City;
import ch.hepia.it.salesman.geo.Map;
import ch.hepia.it.salesman.geo.Trip;

import javax.swing.*;
import java.awt.*;

/**
 * GUI for our map view
 */
public class MapView extends JPanel {
	private Map map;
	private Trip trip;
	private final static int CIRCLE_RADIUS = 10;
	private final static int BORDER = 10;
	private int sizeX;
	private int sizeY;

	/**
	 * Default constructor for our MapView
	 * @param map	The map
	 * @param trip	The trip
	 */
	public MapView (Map map, Trip trip) {
		this.map = map;
		this.trip = trip;
		sizeX = this.getWidth();
		sizeY = this.getHeight();
	}

	/**
	 * Override of the paintComponent method
	 * @param g	The graphics context
	 */
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		sizeX = this.getWidth();
		sizeY = this.getHeight();
		int cnt = map.count();
		g.setColor(Color.BLACK);
		g.drawRect(BORDER,BORDER,sizeX-2*BORDER,sizeY-2*BORDER);
		g.setColor(Color.RED);
		for (int i = 0; i < cnt; i++) {
			City tmpCity = trip.getStopFromTrip(i);
			City nextCity = trip.getStopFromTrip((i+1) % cnt);
			int tmpCityX = (int)Math.round(((tmpCity.getX()/(double) map.getxSize()) * (sizeX-2*BORDER))+BORDER);
			int tmpCityY = (int)Math.round(((tmpCity.getY()/(double) map.getySize()) * (sizeY-2*BORDER))+BORDER);
			int nextCityX = (int)Math.round(((nextCity.getX()/(double) map.getxSize()) * (sizeX-2*BORDER))+BORDER);
			int nextCityY = (int)Math.round(((nextCity.getY()/(double) map.getySize()) * (sizeY-2*BORDER))+BORDER);

			g.fillOval(tmpCityX-CIRCLE_RADIUS/2,tmpCityY-CIRCLE_RADIUS/2,CIRCLE_RADIUS,CIRCLE_RADIUS);
			g.drawLine(tmpCityX,tmpCityY,nextCityX,nextCityY);
		}
	}

	/**
	 * @param trip	The trip we want to set
	 */
	public void setTrip (Trip trip) {
		this.trip = trip;
		this.repaint();
	}
}
