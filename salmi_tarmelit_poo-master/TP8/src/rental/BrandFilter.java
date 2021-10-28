package rental;
import rental.vehicle.Vehicle;
/**
  * A BrandFilter allows to select a Vehicle for a given brand.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public class BrandFilter implements VehicleFilter {
  //Instances variables :
  /*A vehicle brand*/
  private String brand;

  /**
    * Constructor for BrandFilter.
    * @param brand The required brand.
    */
  public BrandFilter(String brand) {
      this.brand = brand;
  }

  /**
    * Gives <code>true</code> if the vehicle was accepted by this brand filter.
    * @return <code>true</code> if v's brand is the same than the required brand, otherwise <code>false</code>.
    * @see VehicleFilter#accept(Vehicle)
    */
  public boolean accept(Vehicle v) {
      return this.brand.equals(v.getBrand());
  }
}
