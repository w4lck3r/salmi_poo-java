
/**
 * Décrivez votre classe Lightstring ici.
 *
 * @author (SALMI Badreddine)
 * @version (27/09/2020)
 */
public class Lightstring
{
    // instance variables 
    //The array which contain lightbulbs (by default they are Off,white and consume 1 Watt) :
    private Lightbulb lightArray[];
    //Lightstring state (all light bulb have the same state so if they are On, the lightstring is powered) :
    private boolean globalPowered;

       /**
     * Constructor for Lightstring.
     */
    public Lightstring(int nbbuld){
        this.lightArray = new Lightbuld[nbbuld] ;
        for (int i=0 ; i<this.lightArray.length ; i++){
        this.lightArray[i] = new Lightbuld();
        }
        this.GlobalPowered = false ;
    }

    /**
      * Gives the lightstring's bulb on the i-th position.
      * @param i A lightbulb position (first has number 1).
      * @return Lightbulb or null if there is no bulb in this position.
      */

    public Lightbuld getInBuld(int n){
        if(n>this.lightArray.length || n==0){
            return null ;
        }
        else{
            return this.lightArray[n-1];
        }
    }

    /** Replace the n-th lightbulb of the lightstring by the given lightbulb.
      * Nothing happens if i is not a valid index.
      * The new bulb takes the state of the lightstring.
      * @param i the number of the lightbulb to be changed (first has number 1)
      * @param theBulb the new lightbulb
      */

    public void changeLightbuld(int i , Lightbuld theBuld){
        Lightbuld Lighty = this.getInBuld(i);
        if (Lighty != null){
            theBuld.setState(this.GlobalPowered);
        }
        this.lightArray[i-1] = theBuld ;
    }
    /**
     * Changes the state of all bulbs on the lightstring.
     * If the light is On, she become Off and conversely.
     * @return None
     */ 

    public void changeState(){
        if(this.GlobalPowered){
            for(int i=0;i<this.lightArray.length;i++){
                this.lightArray[i].putOff();
            }
            this.GlobalPowered = false ;
        }
        else{
                for(int i=0;i<this.lightArray.length;i++){
                this.lightArray[i].putOn();
            }
            this.GlobalPowered = true ;
        }
    }
    /**
      * Gives the total power consumption by bulb(s) on the lightstring.
      * If bulbs are On we return the total power otherwise the power is zero because they are Off.
      * @return Total power consumption in Watt.
      */

    public double getConsomedPower(){
        double total = 0.0;
        if(this.GlobalPowered){
            for(int i=0;i<this.lightArray.length;i++){
                total += lightArray[i].getPower(); 
            }
        }
        return total;
    }
    
}
