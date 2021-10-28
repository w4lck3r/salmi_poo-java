package rental;
/**
  * An exception class for unknown vehicle of the rental package.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public class UnknownVehicleException extends Exception{
  /**
    * Constructor for UnknownVehicleException
    * Used if unknown vehicle in a rental agency.
    * @param message The explicit message when this error occurs.
    */
  public UnknownVehicleException(String message){
    super(message);
  }
}
