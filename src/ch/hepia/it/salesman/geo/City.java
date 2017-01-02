package ch.hepia.it.salesman.geo;

/**
 * A City
 */
public class City {
	private int x;
	private int y;

	/**
	 * Default constructor for a city
	 * @param x	The x coordinate of the city
	 * @param y	The y coordinate of the city
	 */
	public City (int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return	The x coordinate of the city
	 */
	public int getX () {
		return x;
	}

	/**
	 * @return	The y coordinate of the city
	 */
	public int getY () {
		return y;
	}

	/**
	 * @param b	Another city
	 * @return	The distance between this and the other city
	 */
	public double distanceTo(City b){
		return Math.sqrt(Math.pow(this.getX()-b.getX(),2)+Math.pow(this.getY()-b.getY(),2));
	}

	/**
	 * @return	The string representation of the city
	 */
	@Override
	public String toString () {
		return "{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
