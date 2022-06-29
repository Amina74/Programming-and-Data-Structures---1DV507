package ah224uq_assign1.Ex1;

public class Rectangle extends Shape {
	int base;
	int height;

	public Rectangle(String name) {
		super(name);
	}

	public Rectangle(String shapeName, int base, int height) {
		super(shapeName);
		this.base = base;
		this.height = height;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getBase() {
		return base;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public double getArea() {

		return this.height * this.base;
	}

	@Override
	public double getPerimeter() {
		return 2 * (this.height + this.base);
	}

}
