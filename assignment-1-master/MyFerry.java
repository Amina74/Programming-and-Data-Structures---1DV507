package ah224uq_assign1.Ex3;
import java.util.ArrayList;

public class MyFerry implements Ferry{
	
	private ArrayList<Vehicle> vehicles;
    private ArrayList<Integer> vehicleIds;
    private ArrayList<Passenger> passengers;
    private int money;
    private int maximunSpace = 200; // Assuming 1 Lorry = 40 bikes, 1 bus = 20 bikes, 1 car = 5 bicycles and since ferry can have 40 cars that gives us 200 cycles in total.

  MyFerry(){
      vehicles = new ArrayList<>();
      vehicleIds = new ArrayList<>();
      passengers = new ArrayList<>();
      this.money = 0;
  }
    @Override
    public int countPassengers() {
        return passengers.size();
    }

    @Override
    public int countVehicleSpace() {
        return this.maximunSpace;
    }

    @Override
    public int countMoney() {
        return this.money;
    }

    @Override
    public Vehicle[] getAllVehicles() {
      Vehicle [] vehicles1 = new Vehicle[vehicles.size()];
      for(int i = 0;i<vehicles.size();i++){
          vehicles1[i] = vehicles.get(i);
      }
        return vehicles1 ;
    }

    @Override
    public void embark(Vehicle v) throws IllegalArgumentException {

        if (!vehicleIds.contains(v.getVehicleId())) {
            vehicles.add(v);
            vehicleIds.add(v.getVehicleId());
            this.money = v.getFee()+money;
            this.maximunSpace = this.maximunSpace - v.getSize();
            for (int i=0;i<v.getPassengers();i++){
                Passenger p = new Passenger(v.getPassengerFee());
                embark(p);
            }
        }else{
            throw new IllegalArgumentException("Vehicle is already onboard!");

        }


    }

    @Override
    public void embark(Passenger p) throws IllegalArgumentException {
      if (!(passengers.size() >= 200)){
          passengers.add(p);
          this.money = p.getFee() + money;
      }
      else
          throw new IllegalArgumentException("No more space for passengers!!");

    }

    @Override
    public void disembark() {
        vehicleIds.clear();
        passengers.clear();
        vehicles.clear();
        this.maximunSpace = 200;
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        return maximunSpace >= v.getSize();
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return !(passengers.size() >=200);
    }
    
    @Override
    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append("Number of Vehicles onboard "+vehicles.size()+"\n");
    	str.append("Number of Passenger on board "+ passengers.size()+"\n");
    	str.append("Total money earned "+countMoney());
    	return str.toString();
    }
}
