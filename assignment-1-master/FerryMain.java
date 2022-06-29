package ah224uq_assign1.Ex3;

public class FerryMain {

	public static void main(String[] args) {
	    /*
        Wheneve I initiate a Vehicle 1 Passenger is included as it was not mentioned that
        this is a cargo ship so vehicle should have one passenger at least and total cost
        for vehicle is price for vehicle + one driver.
        In this manner we can initiate a car object with max 3, lorry with max 1 and
        bus with max 19 passengers and bicycle comes with one passenger which we do not need
        to mention in bicycle constructer.
        Vehicle id should given manually. If you repeat an id, exception will be thrown!

        Bicycle is considered as unit of space onboard so when a car is embarked 5, when a
        loory is embarked 40, when a bus is embarked 20 and 1 space is removed when one bicycle
        is embarked out of 200.
         */
        try {
            Vehicle car = new Car(2, 1001);
            Vehicle lorry = new Lorry(1, 1002);
            Vehicle bus = new Bus(19,1003);
            Bicycle cycle = new Bicycle(1004);
            Bicycle cycle1 = new Bicycle(1006);
            
            MyFerry ferry = new MyFerry();
            ferry.embark(car);
            ferry.embark(lorry);
            ferry.embark(bus);
            ferry.embark(cycle);
            ferry.embark(cycle1);
            
            // For adding passengers in ferry
           	int noOfPassenger = 100;
            for (int i=0;i<noOfPassenger;i++){
                Passenger p = new Passenger(25);
                ferry.embark(p);
            }
           System.out.println(ferry.toString());
            
            ferry.disembark();
            System.out.println("\n*******************"+"\nAfter disembarking the boat ->");
            
            
            System.out.println(ferry.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        
        
        
    

	}

}
