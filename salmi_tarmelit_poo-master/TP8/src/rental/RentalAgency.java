package rental;
import rental.vehicle.Vehicle;
import java.util.*;
/**
  * A rental vehicle agency, client can rent one vehicle at a time.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public class RentalAgency {
  //Instances variables :
  /* vehicles of this agency */
  protected List<Vehicle> theVehicles;
  /* maps client and rented vehicle (at most one vehicle by client) */
  protected Map<Client,Vehicle> rentedVehicles;

  /**
    * Constructor for RentalAgency.
    * Creates a rental agency which can contains vehicle.
    */
  public RentalAgency() {
  	this.rentedVehicles = new HashMap<Client,Vehicle>();
    this.theVehicles = new ArrayList<Vehicle>();
  }

  /**
    * Adds a vehicle to this agency.
    * @param v The added vehicle.
    */
  public void addVehicle(Vehicle v) {
  	this.theVehicles.add(v);
  }

  /**
    * Provides the list of the vehicles that is accepted by filter.
    * @param filter The selection filter.
    * @return The list of the vehicles accepted by filter.
    */
  public List<Vehicle> select(VehicleFilter filter) {
  	List<Vehicle> result= new ArrayList<Vehicle>();
    for(Vehicle vehicle:this.theVehicles){
      if(filter.accept(vehicle))
        result.add(vehicle);
    }
    return result;
  }

  /**
    * Displays the vehicles accepted by the filter.
    * @param filter The selection filter.
    */
  public void displaySelection(VehicleFilter filter) {
  	List<Vehicle> result=this.select(filter);
    if(result.isEmpty()){
      if(this.theVehicles.isEmpty())
        System.out.println("No vehicle in the agency, then no vehicle concerned by this filter.");
      else
        System.out.println("No vehicle concerned by this filter.");
    }
    for(Vehicle vehicle:result){
      System.out.println(vehicle.toString());
    }
  }

  /**
    * Gives <code>true</code> if client is renting a vehicle.
    * @param client The client for which we want to know it has rented a vehicle.
    * @return <code>true</code> if client is renting a vehicle, otherwise <code>false</code>.
    */
  public boolean hasRentedAVehicle(Client client){
  	return this.rentedVehicles.containsKey(client);
  }

  /**
    * Gives <code>true</code> if vehicle v is rented.
    * @param v The vehicle we want to check if it is rented.
    * @return <code>true</code> if vehicle v is rented, otherwise <code>false</code>.
    */
  public boolean isRented(Vehicle v){
  	return this.rentedVehicles.containsValue(v);
  }

  /**
    * Client rents a vehicle.
    * @param client The renter.
    * @param v The vehicle to rent.
    * @return The daily rental price.
    * @exception UnknownVehicleException if v is not a vehicle of this agency.
    * @exception IllegalStateException if v is already rented or client rents already another vehicle.
    */
  public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
  	if(this.theVehicles.contains(v)){
      if(this.isRented(v))
        throw new IllegalStateException("The vehicle "+v.toString()+" is already rented.");
      else if(this.hasRentedAVehicle(client))
        throw new IllegalStateException(client.toString()+" can rent only one vehicle.");
      else{
        this.rentedVehicles.put(client,v);
        return v.getDailyPrice();
      }
    }
    else
      throw new UnknownVehicleException("The vehicle "+v.toString()+" is unknown in our database.");
  }

  /**
    * The client returns a rented vehicle. Nothing happens if client didn't have rented a vehicle.
    * @param client The client who returns a vehicle.
    */
  public void returnVehicle(Client client){
    if(this.hasRentedAVehicle(client)){
      this.rentedVehicles.remove(client);
    }
  }

  /**
    * Provides the collection of rented vehicles for this agency.
    * @return Collection of currently rented vehicles.
    */
  public Collection<Vehicle> allRentedVehicles(){
    return this.rentedVehicles.values();
  }
}
