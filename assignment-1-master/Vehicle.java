package ah224uq_assign1.Ex3;

public class Vehicle {
	private int fee;
	private int passengers;
	private int vehicleId;
	private int size;
	private int passengerFee;

	Vehicle(int id) {
		this.vehicleId = id;

	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getFee() {
		return fee;
	}

	public int getPassengers() {
		return passengers;
	}

	public int getSize() {
		return size;
	}

	public int getVehicleId() {
		return this.vehicleId;
	}

	public void setPassengerFee(int fee) {
		this.passengerFee = fee;
	}

	public int getPassengerFee() {
		return passengerFee;
	}
}
