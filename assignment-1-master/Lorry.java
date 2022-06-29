package ah224uq_assign1.Ex3;

public class Lorry extends Vehicle {
	
	//private int passenger;
    private int size = 40;
    private  Passenger[]  passengers;


    Lorry(int passenger,int id){
        super(id);
        setPassenger(passenger);
        super.setPassengers(getPassenger());
        super.setFee(getFee());
        super.setPassengerFee(20);
    }
    public void  setPassenger(int passenger) throws IllegalArgumentException{
        if (passenger == 0){
            this.passengers = new Passenger[0];
        }else if (passenger>1 || passenger<0){
            throw new IllegalArgumentException("Car can have 3 more passengers along with one driver so add up to 3 passenger!");
        }
        else
        passengers = new Passenger[passenger+1];
    }
    public int getPassenger(){
        return this.passengers.length;
    }
    public int getFee(){
        return 300 ;
    }

    @Override
    public int getSize() {
        return size;
    }

}
