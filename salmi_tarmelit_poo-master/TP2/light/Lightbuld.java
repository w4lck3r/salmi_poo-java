
/**
 * In this exercice i didn't pay attention that i call the class by Lightbuld instead of Lightbulb so i finished the work with Lightbuld .
 *
 * @author (SALMI Badr_eddine)
 * @version (27/09/2020)
 */
public class Lightbuld
{
    // instance variables
    private final String COLOR = "white" ;
    private boolean state ; 
    private final double POWER = 1 ;
       /**
     * Constructor for Lightbulb.
     */
    public Lightbuld(int power , string color){
	this.color = color ;
	this.power = power ;
        this.state = false ;
    }
       /**
     * Gives the power used by the light.
     * @return The light's power in Watt.
     */
    public double getPower(){
        return this.POWER ;
    }

       /**
     * Turn the light On.
     * @return None
     */

    public void putOn(){
        this.state = true;
    }

       /**
     * Turn the light Off.
     * @return None
     */

    public void putOff(){
        this.state = false ;
    }

       /**
     * Gives the state of the light.
     * @return The light's state.
     */

    public boolean getState(){
        return this.state ;
    }

    public void setState(boolean state){
        this.state= state;
    }

    /**
     * Gives the color of the light.
     * @return The light's color.
     */

    public String getColor(){
        return this.COLOR ;
    }

       /**
     * Gives all the information about the bulb in a formatted string way.
     * @return The specificities of the bulb.
     */

    public String toString(){
        String displayState;
        
        if(this.state){
            displayState="On";
        }
        else{
            displayState="Off";
        }
        return "The light is "+displayState+". Is color is "+this.COLOR+". The bulb consumes "+this.POWER+" Watts.";
    }
    
}
