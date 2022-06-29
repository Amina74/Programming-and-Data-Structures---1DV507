package ah224uq_assign1.Ex1;

public class Square  extends Rectangle{

	private int side;

	public Square(String name , int theside) {
		super(name);
		this.side = theside;

	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public double getArea() {

		return side*side;
	}
	@Override
	public double getPerimeter() {
		return 4*side;
	}
















}
