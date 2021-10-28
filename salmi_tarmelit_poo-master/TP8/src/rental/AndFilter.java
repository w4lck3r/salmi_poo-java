package rental;
import java.util.*;
import rental.vehicle.Vehicle;
/**
  * An AndFilter performs the intersection of filters. It accepts a vehicle if each of its filter accepts it.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public class AndFilter implements VehicleFilter {
    //Instances variables :
    /*Filters list*/
    private List<VehicleFilter> theFilters;

    /**
      * Constructor for AndFilter.
      * Creates an AndFilter with no filter.
      */
    public AndFilter(){
      this.theFilters= new ArrayList<VehicleFilter>();
    }

    /**
      * Adds a new filter
      * @param f The filter to add.
      */
    public void addFilter(VehicleFilter f){
  		this.theFilters.add(f);
    }

    /**
      * Accept the vehicle if each of its filters accepts it.
      * @see VehicleFilter#accept(Vehicle)
      */
    public boolean accept(Vehicle v){
	     for(VehicleFilter filters : this.theFilters){
         if (!filters.accept(v))
          return false;
       }
	     return true;
    }
}
