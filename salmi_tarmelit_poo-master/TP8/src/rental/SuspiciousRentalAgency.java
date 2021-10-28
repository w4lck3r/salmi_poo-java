package rental;

import rental.vehicle.Vehicle;

/**
  * A suspicious rental vehicle agency, client under 25 years pay 10% more expensive.
  */
public class SuspiciousRentalAgency extends RentalAgency{

  /**
    * Constructor for SuspiciousRentalAgency.
    */
  public SuspiciousRentalAgency(){
    super();
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
        throw new IllegalStateException("Le vehicule "+v.toString()+" est deja louer.");
      else if(this.hasRentedAVehicle(client))
        throw new IllegalStateException(client.toString()+"peut louer qu'une voiture a la fois.");
      else{
        this.rentedVehicles.put(client,v);
        if(client.getAge()<25)
          return (v.getDailyPrice()+((v.getDailyPrice()*10)/100));
        else
          return v.getDailyPrice();
      }
    }
    else
      throw new UnknownVehicleException("Le vehicule "+v.toString()+" n'est pas connu dans nos bases .");
  }
}
