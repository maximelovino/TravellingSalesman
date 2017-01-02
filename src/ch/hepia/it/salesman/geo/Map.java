package ch.hepia.it.salesman.geo;

import java.util.Random;

/**
 * Class representing the map of our salesman
 */
public class Map {
	private City[] cities;
	private int xSize;
	private int ySize;
	private Random rnd;

	/**
	 * @param numberCities	The number of cities of our map
	 * @param xSize			The width of our map
	 * @param ySize			The height of our map
	 */
	public Map (int numberCities, int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.cities = new City[numberCities];
		this.rnd = new Random();
	}

	/**
	 * Method that generates random cities for our map
	 */
	public void generateRandomCities(){
		for (int i = 0; i < cities.length; i++) {
			int x = rnd.nextInt(xSize);
			int y = rnd.nextInt(ySize);
			cities[i] = new City(x,y);
		}
	}

	/**
	 * @param index	The index of the city we're looking for
	 * @return		The city at that index
	 */
	public City getCity(int index){
		return cities[index];
	}

	/**
	 * @return	The number of cities
	 */
	public int count(){
		return cities.length;
	}

	/**
	 * @return	The width of the map
	 */
	public int getxSize () {
		return xSize;
	}

	/**
	 * @return	The height of the map
	 */
	public int getySize () {
		return ySize;
	}

	/**
	 * @return	The string representation of the trip
	 */
	@Override
	public String toString () {
		String str = "";
		for (int i = 0; i < this.cities.length; i++) {
			str += "City "+i+": ";
			str += this.cities[i].toString() + "\n";
		}
		return str;
	}
}
