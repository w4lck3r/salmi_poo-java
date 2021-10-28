package rental.vehicle;
/**
  * A class to create and manage Car vehicle.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public class Car extends Vehicle{
  //Instances variables :
  /*The number of passengers in the Car*/
  private int nbPassengers;

  /**
    * Constructor for Car.
		* Creates a car with given informations.
		* @param brand The car's brand.
		* @param model The car's model.
		* @param productionYear The car's production year.
		* @param dailyRentalPRice The car's daily rental price.
    * @param nbPassengers The car's number of passenger.
    * @see Vehicle#Vehicle(String,String,int,float)
		*/
	public Car(String brand, String model, int productionYear, float dailyRentalPRice,int nbPassengers){
    super(brand,model,productionYear,dailyRentalPRice);
    this.nbPassengers=nbPassengers;
  }

  /**
    * Gives the number of passengers in the Car.
    * @return Number of passengers in the Car.
    */
  public int getNbPassengers(){
    return this.nbPassengers;
  }

  /**
    * This car is equals to another if they have same brand, model,
    * production year, daily rental price and same number of passengers.
    * @param o The object to test the equality with Car.
    * @return <code>true</code> if other is the same car than this car, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof Car) {
      Car theOther = ((Car) o);
      return super.equals(theOther) && this.nbPassengers == theOther.getNbPassengers();
    } else {
      return false;
    }
  }

  /**
		* Displays the specs of the car.
		* @return The representation of the car.
		* @see java.lang.Object#toString()
		*/
	public String toString() {
    return super.toString()+ " " +this.nbPassengers+" passengers";
	}
}
