package rental;
import rental.vehicle.Vehicle;
/**
  * A MaxPriceFilter allows to select a vehicle if its daily rental price is lower than a given price.
  * @author TARMELLIT Lydia | SALMI badr-eddine
 
  */
public class MaxPriceFilter implements VehicleFilter {
  //Instances variables :
  /*Price of a vehicle*/
  private int price;

  /**
    * Constructor for MaxPriceFilter.
    * @param price The maximal rental price.
    */
  public MaxPriceFilter(int price){
      this.price = price;
  }
  /**
    * Gives <code>true</code> if the vehicle was accepted by this max price filter.
    * @return <code>true</code> if vehicle v's daily rental price is lower than the maximal price, otherwise <code>false</code>.
    * @see VehicleFilter#accept(Vehicle)
    */
  public boolean accept(Vehicle v){
      return this.price > v.getDailyPrice();
  }
}
