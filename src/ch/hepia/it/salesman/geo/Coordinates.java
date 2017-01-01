package ch.hepia.it.salesman.geo;

public class Coordinates {
	private int x;
	private int y;

	public Coordinates (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX () {
		return x;
	}

	public int getY () {
		return y;
	}

	public double distanceTo(Coordinates b){
		return Math.sqrt(Math.pow(this.getX()-b.getX(),2)+Math.pow(this.getY()-b.getY(),2));
	}

	@Override
	public String toString () {
		return "{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
