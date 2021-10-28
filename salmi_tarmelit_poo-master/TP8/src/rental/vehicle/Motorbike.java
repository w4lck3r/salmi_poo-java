package rental.vehicle;
/**
  * A class to create and manage Motorbike vehicle.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  */
public class Motorbike extends Vehicle{
  //Instances variables :
  /*The cubic cylinder capacity (in cm3) of the Motorbike*/
  private int cylinderCapacity;

  /**
    * Constructor for Motorbike.
		* Creates a motorbike with given informations.
		* @param brand The motorbike's brand.
		* @param model The motorbike's model.
		* @param productionYear The motorbike's production year.
		* @param dailyRentalPRice The motorbike's daily rental price.
    * @param cylinderCapacity The motorbike's cubic cylinder capacity (in cm3).
    * @see Vehicle#Vehicle(String,String,int,float)
		*/
	public Motorbike(String brand, String model, int productionYear, float dailyRentalPRice,int cylinderCapacity){
    super(brand,model,productionYear,dailyRentalPRice);
    this.cylinderCapacity=cylinderCapacity;
  }

  /**
    * Gives the cubic cylinder capacity of the Motorbike.
    * @return Cubic cylinder capacity (in cm3) of the Motorbike.
    */
  public int getCylinderCapacity(){
    return this.cylinderCapacity;
  }

  /**
    * This motorbike is equals to another if they have same brand, model,
    * production year, daily rental price and same cubic cylinder capacity.
    * @param o The object to test the equality with Motorbike.
    * @return <code>true</code> if other is the same motorbike than this motorbike, otherwise <code>false</code>.
    * @see java.lang.Object#equals(java.lang.Object)
    */
  public boolean equals(Object o) {
    if (o instanceof Motorbike) {
      Motorbike theOther = ((Motorbike) o);
      return super.equals(theOther) && this.cylinderCapacity == theOther.getCylinderCapacity();
    } else {
      return false;
    }
  }

  /**
		* Displays the specs of the motorbike.
		* @return The representation of the motorbike.
		* @see java.lang.Object#toString()
		*/
	public String toString() {
    return super.toString()+ " " +this.cylinderCapacity+" cm3";
	}

}
