package ch.hepia.it.salesman.geo;

import java.util.Random;

public class Map {
	private Coordinates[] cities;
	private int xSize;
	private int ySize;
	private Random rnd;

	public Map (int numberCities, int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.cities = new Coordinates[numberCities];
		this.rnd = new Random();
	}

	public void generateRandomCities(){
		for (int i = 0; i < cities.length; i++) {
			int x = rnd.nextInt(xSize);
			int y = rnd.nextInt(ySize);
			cities[i] = new Coordinates(x,y);
		}
	}
}
