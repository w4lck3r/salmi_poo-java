package rental;
import rental.vehicle.*;
import java.util.*;
/**
  * A class to show an example of use of the package rental with a SuspiciousRentalAgency.
  * @author TARMELLIT Lydia | SALMI badr-eddine

  */
public class FinalMain{

  /**
    * Main function which display differents behavior of rental agency with a suspicious rental agency.
    * @param args Arguments given by the user in the control terminal (not used here).
    */
  public static void main(String[] args){
    RentalAgency agency =new RentalAgency();
    SuspiciousRentalAgency suspiciousAgency =new SuspiciousRentalAgency();
    Vehicle v1 = new Vehicle("Basic","Vehicle",1982,23.55f);
    Car car1 = new Car("Basic","Vehicle",1982,23.55f,5);
    Car car2 = new Car("Peugeot","208 T16",2018,125,5);
    Car car3 = new Car("Autobot","Bumblebee",2018,128.7f,5);
    Motorbike moto1 = new Motorbike("Kawasaki","H2R",2018,250,998);
    Client c1 = new Client("Tim Oléon",18);
    Client c1bis = new Client("Tim Oléon",18);
    Client c2 = new Client("Valentino Rossi",40);
    Client c3 = new Client("Sébastien Loeb",45);
    MaxPriceFilter criterion = new MaxPriceFilter(150);
    MaxPriceFilter criterion2 = new MaxPriceFilter(300);
    //##################################################################################################
    //Before use of agency (Show operation of Client and Vehicle classes) :
    //##################################################################################################
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### EXAMPLES OF ALLOWED OPERATION FOR CLIENTS AND VEHICLES #####");
    System.out.println("Existing Vehicles : ");
    System.out.println("  - "+v1.toString());
    System.out.println("  - "+car1.toString());
    System.out.println("  - "+car2.toString());
    System.out.println("  - "+car3.toString());
    System.out.println("  - "+moto1.toString());
    System.out.println("Existing Client : ");
    System.out.println("  - "+c1.toString());
    System.out.println("  - "+c2.toString());
    System.out.println("  - "+c3.toString()+"\n");
    if(c1.equals(c1))
      System.out.println(c1.toString()+" equals "+c1.toString()+" but they are the same Object instance.");
    if(c1.equals(c1bis))
      System.out.println(c1.toString()+" equals "+c1bis.toString()+" but they are not the same Object instance.");
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

    //##################################################################################################
    //Uses of agency :
    //##################################################################################################
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### EXAMPLES OF AGENCY'S OPERATION #####");
    if(!suspiciousAgency.hasRentedAVehicle(c2))
      System.out.println(c2.toString()+" no rent a vehicle currently.");
    if(!suspiciousAgency.hasRentedAVehicle(c3))
      System.out.println(c3.toString()+" no rent a vehicle currently.");
    if(!agency.isRented(car1))
      System.out.println(car2.toString()+" not rented currently.");
    System.out.println("\nWait please adding some vehicle into agency ...\nDone.");
    agency.addVehicle(car1);
    agency.addVehicle(moto1);
    agency.addVehicle(car3);
    System.out.println("Now the vehicles belonging to the agency :\n-"+car1.toString()+"\n-"+moto1.toString()+"\n-"+car3.toString());
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
      System.out.println(c2.toString()+" rent "+car3.toString()+" for "+agency.rentVehicle(c2,car3)+"€ per days.");
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

    //##################################################################################################
    //Uses of suspicious agency :
    //##################################################################################################
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### EXAMPLES OF SUSPICIOUS AGENCY'S OPERATION (PROOF THE SAME BASIC BEHAVIOR THAN AGENCY) #####");
    System.out.println("Suspicious agency increase the price for 10% for driver under 25 years old.\nHere "+c2.getName()+" and "+c3.getName()+" are not concerned.\n");
    if(!suspiciousAgency.hasRentedAVehicle(c2))
      System.out.println(c2.toString()+" no rent a vehicle currently.");
    if(!suspiciousAgency.hasRentedAVehicle(c3))
      System.out.println(c3.toString()+" no rent a vehicle currently.");
    if(!suspiciousAgency.isRented(car1))
      System.out.println(car2.toString()+" not rented currently.");
    System.out.println("\nWait please adding some vehicle into suspicious agency ...\nDone.");
    suspiciousAgency.addVehicle(car1);
    suspiciousAgency.addVehicle(moto1);
    suspiciousAgency.addVehicle(car3);
    System.out.println("Now the vehicles belonging to the suspicious agency :\n-"+car1.toString()+"\n-"+moto1.toString()+"\n-"+car3.toString());
    System.out.println("\nRent behavior :");
    //Problem-free rent :
    try{
      System.out.println(c2.toString()+" rent "+moto1.toString()+" for "+suspiciousAgency.rentVehicle(c2,moto1)+"€ per days.");
      System.out.println(c3.toString()+" rent "+car1.toString()+" for "+suspiciousAgency.rentVehicle(c3,car1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent an unknown vehicle :
    try{
    suspiciousAgency.rentVehicle(c1,car2);
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent an already rented vehicle :
    try{
      System.out.println(c1.toString()+" rent "+moto1.toString()+" for "+suspiciousAgency.rentVehicle(c1,moto1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent to a client who already rent a vehicle :
    try{
      System.out.println(c2.toString()+" rent "+car3.toString()+" for "+suspiciousAgency.rentVehicle(c2,car3)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    System.out.println("\nCurrently rented vehicles :");
    System.out.println("  - "+suspiciousAgency.allRentedVehicles().toString());
    suspiciousAgency.returnVehicle(c2);
    System.out.println("Client : "+c2.toString()+" returns vehicle then currently rented vehicles :");
    System.out.println("  - "+suspiciousAgency.allRentedVehicles().toString());
    suspiciousAgency.returnVehicle(c3);
    System.out.println("Client : "+c3.toString()+" returns vehicle then currently rented vehicles :");
    if(suspiciousAgency.allRentedVehicles().isEmpty())
      System.out.println("No vehicle rented.");

    //##################################################################################################
    //Differences between suspicious agency behavior and agency behavior :
    //##################################################################################################
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### DIFFERENCES BETWEEN THE SUSPICIOUS AGENCY AND THE AGENCY IN THEIR BEHAVIOR. #####");
    System.out.println("Suspicious agency increase the price for 10% for driver under 25 years old.\nHere "+c1.getName()+" is concerned.\n");
    try{
      System.out.println("Rent vehicles in both agencies:");
      System.out.println("| AGENCY |  "+c1.toString()+" rent "+moto1.toString()+" for "+agency.rentVehicle(c1,moto1)+"€ per days.");
      System.out.println("| SUSPICIOUS AGENCY |  "+c1.toString()+" rent "+moto1.toString()+" for "+suspiciousAgency.rentVehicle(c1,moto1)+"€ per days.");
      System.out.println("\nCurrently rented vehicles in both agencies:");
      System.out.println("| AGENCY | - "+agency.allRentedVehicles().toString());
      System.out.println("| SUSPICIOUS AGENCY | - "+suspiciousAgency.allRentedVehicles().toString());
      System.out.println("\n| AGENCY |  Client : "+c1.toString()+" returns vehicle then currently rented vehicles :");
      agency.returnVehicle(c1);
      if(agency.allRentedVehicles().isEmpty())
        System.out.println("No vehicle rented.");
      System.out.println("| SUSPICIOUS AGENCY |  Client : "+c1.toString()+" returns vehicle then currently rented vehicles :");
      suspiciousAgency.returnVehicle(c1);
      if(suspiciousAgency.allRentedVehicles().isEmpty())
        System.out.println("No vehicle rented.\n");
      System.out.println("| AGENCY |  "+c1.toString()+" rent "+car1.toString()+" for "+agency.rentVehicle(c1,car1)+"€ per days.");
      System.out.println("| SUSPICIOUS AGENCY |  "+c1.toString()+" rent "+car1.toString()+" for "+suspiciousAgency.rentVehicle(c1,car1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }

    //##################################################################################################
    //Show uses of filters :
    //##################################################################################################
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### FILTERS EXAMPLES #####");
    System.out.println("\nAgency's vehicles whose price is up to 150 € per day :");
    agency.displaySelection(criterion);
    System.out.println("\nSuspicious agency's vehicles whose price is up to 300 € per day :");
    suspiciousAgency.displaySelection(criterion2);
  }

}
