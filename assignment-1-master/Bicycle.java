package ah224uq_assign1.Ex3;

public class Bicycle extends Vehicle{
	//private int passenger;
	private int size = 1;
	private Passenger[] passengers;

	Bicycle(int id) {
		super(id);
		setPassenger();
		int pass = getPassenger();
		super.setPassengers(pass);
		super.setFee(getFee());
		super.setPassengerFee(0);
	}

	public void setPassenger() {
		this.passengers = new Passenger[1];
	}

	public int getPassenger() {
		return this.passengers.length;
	}

	public int getFee() {
		return 40;
	}

	@Override
	public int getSize() {
		return size;
	}
}
