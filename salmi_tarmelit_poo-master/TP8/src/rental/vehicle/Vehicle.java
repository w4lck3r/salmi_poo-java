package rental.vehicle;
/**
  * Represents vehicle for a rental agency.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  
  */
public class Vehicle {
	//Instances variables :
	/*Vehicle's brand*/
	private String brand;
	/*Vehicle's model*/
	private String model;
	/*Vehicle's year of production*/
	private int productionYear;
	/*Vehicle's daily rental price*/
	private float dailyRentalPrice;

	/**
		* Creates a vehivle with given informations.
		* @param brand The vehicle's brand.
		* @param model The vehicle's model.
		* @param productionYear The vehicle's production year.
		* @param dailyRentalPRice The daily rental price.
		*/
	public Vehicle(String brand, String model, int productionYear, float dailyRentalPRice) {
		this.brand = brand;
		this.model = model;
		this.productionYear = productionYear;
		this.dailyRentalPrice = dailyRentalPRice;
	}

	/**
		* Gives the brand of the vehicle.
		* @return The brand for this vehicle.
		*/
	public String getBrand() {
		return this.brand;
	}

	/**
		* Gives the model of the vehicle.
		* @return The modelfor this vehicle.
		*/
	public String getModel() {
		return this.model;
	}

	/**
		* Gives the production year of the vehicle.
		* @return The production year for this vehicle.
		*/
	public int getProductionYear() {
		return this.productionYear;
	}

	/**
		* Gives the vehicle's daily price.
		* @return This vehicle daily price.
		*/
	public float getDailyPrice() {
		return this.dailyRentalPrice;
	}

	/**
		* This vehicle is equals to another if they have same brand, model,
		* production year and daily rental price.
		* @param o The object to test the equality with Vehicle.
		* @return <code>true</code> if other is the same vehicle than this vehicle, otherwise <code>false</code>.
		* @see java.lang.Object#equals(java.lang.Object)
		*/
	public boolean equals(Object o) {
		if (o instanceof Vehicle) {
			Vehicle theOther = ((Vehicle) o);
			return this.brand.equals(theOther.brand)
					&& this.model.equals(theOther.model)
					&& this.productionYear == theOther.productionYear
					&& this.dailyRentalPrice == theOther.dailyRentalPrice;
		} else {
			return false;
		}
	}

	/**
		* Displays the specs of the vehicle.
		* @return The representation of the vehicle.
		* @see java.lang.Object#toString()
		*/
	public String toString() {
		return this.productionYear + " " + this.brand + " " + this.model+ " " + this.dailyRentalPrice;
	}

}
