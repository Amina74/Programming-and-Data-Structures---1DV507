package ah224uq_assign1.Ex1;

public class Cirlce extends Shape {
	private int rip;

	public Cirlce(String shapeName, int theR) {
		super(shapeName);
		this.rip = theR;
	}

	public int getR() {
		return rip;
	}

	public void setR(int theR) {
		this.rip = theR;
	}


	public double getArea() {
		return Math.PI * (Math.pow(this.rip, 2));
	}


	public double getPerimeter() {

		return 2 * (Math.PI * rip);
	}

}
