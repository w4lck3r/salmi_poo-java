package rental;
import rental.vehicle.Vehicle;
/**
  * Interface for vehicle filter(s).
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public interface VehicleFilter {
	/**
    * Gives <code>true</code> if the vehicle was accepted by a filter.
    * @param v The vehicle that must be tested by the filter.
    * @return <code>true</code> if and only if the vehicle v is accepted by this filter,
    * v is said to be selected by this filter, otherwise <code>false</code>.
    */
  public boolean accept(Vehicle v);
}
