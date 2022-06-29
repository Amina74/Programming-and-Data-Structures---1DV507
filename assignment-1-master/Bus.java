package ah224uq_assign1.Ex3;

public class Bus extends Vehicle{
	//private int passenger;
	private int size = 20;
	private Passenger[] passengers;

	Bus(int passenger, int id) {
		super(id);
		setPassenger(passenger);
		super.setPassengers(getPassenger());
		super.setFee(getFee());
		super.setPassengerFee(15);
	}

	public void setPassenger(int passenger) throws IllegalArgumentException {
		if (passenger == 0) {
			this.passengers = new Passenger[0];
		} else if (passenger > 20 || passenger < 0) {
			throw new IllegalArgumentException(
					"Car can have 3 more passengers along with one driver so add up to 3 passenger!");
		} else
			passengers = new Passenger[passenger + 1];
	}

	public int getPassenger() {
		return this.passengers.length;
	}

	public int getFee() {
		return 200;
	}

	@Override
	public int getSize() {
		return size;
	}

}
