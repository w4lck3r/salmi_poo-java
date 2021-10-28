/**
 * A class to manipulate a bike station with some fonctions : drop and take a bike .
 *
 *
 * @author SALMI Badr-eddine // TARMELIT Lydia
 * @version 1.0 | 09/10/2020
 */


public class BikeStation {
	//______________INSTANCE VARIABLES OF BIKESTATION CLASS________________//
	/** array of slots for bikes in the station */
    private Bike bikes[] ;
    /** name of the station */
    private String name ;
	/** how many bikes can a station have */
    private int capacity ;
    /** how many bikes we have in a station */
    private int bikesNumber ;
    //---------------------------------------------------------------------//

    /**
     * CONSTRUCTER OF OUR CLASS "BikeStation"
	 * @param name to get the value of Station's name
	 * @param capacity to get how many bikes can a station handle
	 * intialisation of a blank station in line 27
     */
	public BikeStation(String name, int capacity) {
	    this.name = name ;
	    this.capacity = capacity ;
	    this.bikes = new Bike[capacity] ;
	    this.bikesNumber = 0 ;
	    for(int i=0 ; i<this.bikes.length ; i++) {
			this.bikes[i] = null ;
		}
	}

    /**
     * GETTER METHODE : it give us the name of our station .
	 * @return Name
     */
	public String getName() {
		return this.name;
	}

    /**
     * GETTER METHODE : it give us the capacity of the station .
	 * @return capacity
     */
	public int getCapacity() {
	    return this.capacity;
	}

    /**
     * GETTER METHODE : it give us the number of total of bikes
	 * @return bikesNumber
     */
	public int getNumberOfBikes() {
		return this.bikesNumber ;
	}

    
    /**
     * METHODE : to get the first free position in the slot if the slot is complet it return NULL
	 * @return the first free position in the slot or -1
	 * if we get -1 it means there are no free place in the slot
     */
	public int firstFreeSlot() {
		for(int i = 0 ; i<this.capacity ; i ++ ){
			if(this.bikes[i] == null) return i ;
		}
		return -1 ;
	}
	
    /**
     * METHODE : to add a bike to the slot if there is a free place
	 * @return boolean <code>true</code> if we could add a bike in the position wich we've got from firstFreeSlot || false if we couldn't <code>false</code>
     */
	public boolean dropBike(Bike bike) {
	    if(this.firstFreeSlot() != -1){
	    	this.bikes[this.firstFreeSlot()] = bike;
	    	this.bikesNumber++ ;
	    	return true ;
		}
	    return false ;
	}



	/**
	 * Gives the bike at the given position, if there is one otherwise gives nothing.
	 * @param i The position of the wanted bike.
	 * @return The wanted bike or <code>null</code> if there are not any.
	 */
	public Bike takeBike(int i) {
	    if((i < 0) || (i > this.capacity) || (this.bikes[i] == null)) {
			return null ;
		}
	    Bike takenBike = this.bikes[i] ;
	    this.bikes[i] = null ;
	    this.capacity ++;
	    this.bikesNumber--;
	    return takenBike ;
	}
	
	
}
