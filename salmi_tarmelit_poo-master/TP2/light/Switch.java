
/**
 * Décrivez votre classe Switch ici.
 *
 * @author (SALMI Badreddine)
 * @version (27/09/2020)
 */
public class Switch
{
    // variables d'instance 
    private Lightbuld light;

    /**
     * Constructeur d'objets de classe Switch
     */
    public Switch()
    {
        this.light = new Lightbuld();
    }
        /**
      * If the light linked with the switch is On it goes Off and conversely.
      * @return None
      */
    public void change(){
        if(this.light.getState()){
            this.light.putOff();
        }
        else{
            this.light.putOn();
        }
    }
        /**
     * Gives the state of the lightbulb linked with the switch.
     * @return The switch's lightbulb state.
     */
    public boolean getLightState(){
        return this.light.getState();
    }
}
