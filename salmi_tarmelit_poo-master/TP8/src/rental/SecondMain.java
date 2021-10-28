package rental;
import rental.vehicle.*;
import java.util.*;
/**
  * A class to show an example of use of the package rental with Car and Motorbike vehicle.
  * @author TARMELLIT Lydia | SALMI badr-eddine
 
  */
public class SecondMain{

  /**
    * Main function which display differents behavior of rental agency with Car and Motorbike vehicle.
    * @param args Arguments given by the user in the control terminal (not used here).
    */
  public static void main(String[] args){
    RentalAgency agency =new RentalAgency();
    Vehicle v1 = new Vehicle("Basic","Vehicle",1982,23.55f);
    Car car1 = new Car("Basic","Vehicle",1982,23.55f,5);
    Car car2 = new Car("Peugeot","208 T16",2018,125,5);
    Motorbike moto1 = new Motorbike("Kawasaki","H2R",2018,250,998);
    Client c1 = new Client("Tim Oléon",25);
    Client c2 = new Client("Valentino Rossi",40);
    Client c3 = new Client("Sébastien Loeb",45);
    MaxPriceFilter criterion = new MaxPriceFilter(150);
    MaxPriceFilter criterion2 = new MaxPriceFilter(300);
    //Before use of agency (Show operation of Client and Vehicle classes) :
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### EXAMPLES OF ALLOWED OPERATION FOR CLIENTS AND VEHICLES #####");
    System.out.println("Existing Vehicles : ");
    System.out.println("  - "+v1.toString());
    System.out.println("  - "+car1.toString());
    System.out.println("  - "+car2.toString());
    System.out.println("  - "+moto1.toString());
    System.out.println("Existing Client : ");
    System.out.println("  - "+c1.toString());
    System.out.println("  - "+c2.toString());
    System.out.println("  - "+c3.toString()+"\n");
    if(c1.equals(c1))
      System.out.println(c1.toString()+" equals "+c1.toString()+" but they are the same Object instance.");
    if(c1.equals(c2))
      System.out.println(c1.toString()+" equals "+c2.toString()+" but they are not the same Object instance.");
    if(v1.equals(car1))
      System.out.println(v1.toString()+" equals "+car1.toString()+".");
    if(car1.equals(car1))
      System.out.println(car1.toString()+" equals "+car1.toString()+".");
    if(!car1.equals(v1))
      System.out.println(car1.toString()+" not equals "+v1.toString()+".");
    if(!v1.equals(car2))
      System.out.println(v1.toString()+" not equals "+car2.toString()+".");
    if(!car2.equals(moto1))
      System.out.println(car2.toString()+" not equals "+moto1.toString()+".");
    System.out.println("\nSome getters example :");
    System.out.println("The name of the first client is : "+c1.getName()+" and he has "+c1.getAge()+" years old.");
    System.out.println("The second car has : "+car2.getNbPassengers()+ " passengers.");
    System.out.println("The brand of the third vehicle is : "+moto1.getBrand()+", his model : "+moto1.getModel()+", his production year : "+
    moto1.getProductionYear()+", it cost : "+moto1.getDailyPrice()+"€ per days and it cubic cylinder capacity is "+moto1.getCylinderCapacity()+" cm3.");
    //Uses of agency :
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### EXAMPLES OF AGENCY'S OPERATION #####");
    if(!agency.hasRentedAVehicle(c1))
      System.out.println(c1.toString()+" no rent a vehicle currently.");
    if(!agency.isRented(car1))
      System.out.println(car2.toString()+" not rented currently.");
    System.out.println("\nWait please adding some vehicle into agency ...\nDone.");
    agency.addVehicle(car1);
    agency.addVehicle(moto1);
    System.out.println("Now the vehicles belonging to the agency :\n-"+car1.toString()+"\n-"+moto1.toString());
    System.out.println("\nRent behavior :");
    //Problem-free rent :
    try{
      System.out.println(c2.toString()+" rent "+moto1.toString()+" for "+agency.rentVehicle(c2,moto1)+"€ per days.");
      System.out.println(c3.toString()+" rent "+car1.toString()+" for "+agency.rentVehicle(c3,car1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent an unknown vehicle :
    try{
    agency.rentVehicle(c1,car2);
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent an already rented vehicle :
    try{
      System.out.println(c1.toString()+" rent "+moto1.toString()+" for "+agency.rentVehicle(c1,moto1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent to a client who already rent a vehicle :
    try{
      System.out.println(c2.toString()+" rent "+car1.toString()+" for "+agency.rentVehicle(c2,car1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    System.out.println("\nCurrently rented vehicles :");
    System.out.println("  - "+agency.allRentedVehicles().toString());
    agency.returnVehicle(c2);
    System.out.println("Client : "+c2.toString()+" returns vehicle then currently rented vehicles :");
    System.out.println("  - "+agency.allRentedVehicles().toString());
    agency.returnVehicle(c3);
    System.out.println("Client : "+c3.toString()+" returns vehicle then currently rented vehicles :");
    if(agency.allRentedVehicles().isEmpty())
      System.out.println("No vehicle rented.");
    //Show uses of filters :
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### FILTERS EXAMPLES #####");
    System.out.println("\nAgency's vehicles whose price is up to 150 € per day :");
    agency.displaySelection(criterion);
    System.out.println("\nAgency's vehicles whose price is up to 300 € per day :");
    agency.displaySelection(criterion2);
  }

}
