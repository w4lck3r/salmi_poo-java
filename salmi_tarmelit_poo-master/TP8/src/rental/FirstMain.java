package rental;
import rental.vehicle.*;
import java.util.*;
/**
  * A class to show an example of use of the package rental
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public class FirstMain{

  /**
    * Main function which display differents behavior of rental agency.
    * @param args Arguments given by the user in the control terminal (not used here).
    */
  public static void main(String[] args){
    RentalAgency agency =new RentalAgency();
    Vehicle v1 = new Vehicle("Peugeot","205",1982,23.55f);
    Vehicle v2 = new Vehicle("Peugeot","208 T16",2018,300);
    Vehicle v3 = new Vehicle("Autobot","Bumblebee",2018,128.7f);
    Client c1 = new Client("Tim Oléon",25);
    Client c2 = new Client("Tim Oléon",25);
    Client c3 = new Client("Sébastien Loeb",45);
    MaxPriceFilter criterion1 = new MaxPriceFilter(150);
    BrandFilter criterion2 = new BrandFilter("Peugeot");
    AndFilter interCriterion = new AndFilter();
    interCriterion.addFilter(criterion1);
    interCriterion.addFilter(criterion2);
    MaxPriceFilter criterion3 = new MaxPriceFilter(15);
    BrandFilter criterion4 = new BrandFilter("Autobot");
    AndFilter interCriterion2 = new AndFilter();
    interCriterion2.addFilter(criterion3);
    interCriterion2.addFilter(criterion4);
    //Now the AndFilter interCriterion provides vehicle with Peugeot brand and price under 150
    //Before use of agency (Show operation of Client and Vehicle classes) :
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### EXAMPLES OF ALLOWED OPERATION FOR CLIENTS AND VEHICLES #####");
    System.out.println("Existing Vehicles : ");
    System.out.println("  - "+v1.toString());
    System.out.println("  - "+v2.toString());
    System.out.println("  - "+v3.toString());
    System.out.println("Existing Client : ");
    System.out.println("  - "+c1.toString());
    System.out.println("  - "+c2.toString()+"\n");
    if(c1.equals(c1))
      System.out.println(c1.toString()+" equals "+c1.toString()+" but they are the same Object instance.");
    if(c1.equals(c2))
      System.out.println(c1.toString()+" equals "+c2.toString()+" but they are not the same Object instance.");
    if(!v1.equals(v2))
      System.out.println(v1.toString()+" not equals "+v2.toString()+".");
    if(!c1.equals(c3))
      System.out.println(c1.toString()+" not equals "+c3.toString());
    System.out.println("\nSome getters example :");
    System.out.println("The name of the first client is : "+c1.getName()+" and he has "+c1.getAge()+" years old.");
    System.out.println("The brand of the third vehicle is : "+v3.getBrand()+", his model : "+v3.getModel()+", his production year : "+v3.getProductionYear()+" and it cost "+v3.getDailyPrice()+"€ per days.");
    //Uses of agency :
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### EXAMPLES OF AGENCY'S OPERATION #####");
    if(!agency.hasRentedAVehicle(c1))
      System.out.println(c1.toString()+" no rent a vehicle currently.");
    if(!agency.isRented(v1))
      System.out.println(v1.toString()+" not rented currently.");
    System.out.println("Agency's vehicles whose brand is Peugeot :");
    agency.displaySelection(criterion2);
    System.out.println("\nWait please adding some vehicle into agency ...\nDone.");
    agency.addVehicle(v1);
    agency.addVehicle(v3);
    System.out.println("\nRent behavior :");
    //Problem-free rent :
    try{
      System.out.println(c1.toString()+" rent "+v1.toString()+" for "+agency.rentVehicle(c1,v1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent an unknown vehicle :
    try{
    agency.rentVehicle(c2,v2);
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent an already rented vehicle :
    try{
      System.out.println(c2.toString()+" rent "+v1.toString()+" for "+agency.rentVehicle(c2,v1)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    //Tries to rent to a client who already rent a vehicle :
    try{
      System.out.println(c1.toString()+" rent "+v3.toString()+" for "+agency.rentVehicle(c1,v3)+"€ per days.");
    }
    catch(UnknownVehicleException e){
      System.out.println(e);
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
    System.out.println("\nCurrently rented vehicles :");
    Collection<Vehicle> rentedV=agency.allRentedVehicles();
    for(Vehicle vehicleRented :rentedV)
      System.out.println("  - "+rentedV.toString());
    agency.returnVehicle(c1);
    System.out.println("Client : "+c1.toString()+" returns vehicle then currently rented vehicles :");
    if(agency.allRentedVehicles().isEmpty())
      System.out.println("No vehicle rented.");
    //Shows uses of filters :
    System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("##### FILTERS EXAMPLES #####");
    System.out.println("Agency's vehicles whose brand is Peugeot :");
    agency.displaySelection(criterion2);
    System.out.println("\nAgency's vehicles whose price is up to 150 € per day :");
    agency.displaySelection(criterion1);
    System.out.println("\nAgency's vehicles whose price is up to 150 € per day and brand is Peugeot :");
    agency.displaySelection(interCriterion);
    System.out.println("\nAgency's vehicles whose price is up to 15 € per day and brand is Autobot :");
    agency.displaySelection(interCriterion2);
  }

}
