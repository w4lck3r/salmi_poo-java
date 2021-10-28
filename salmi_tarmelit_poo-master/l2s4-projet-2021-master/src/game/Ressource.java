package game;

    /** enum for the ressources 
      */
public enum Ressource{
    ROCHE, BLE, SABLE, BOIS;

    /** get the gold value by the type of the ressource
      *  @return result 
      */
    public int getGold(){
        int result = 2;
        if(this == Ressource.ROCHE){
            result = 8;
        }
        else if(this == Ressource.SABLE){
            result = 5;
        }
        return result;
    }

    /** get the food value by the type of the ressource
      *  @return result food value
      */
    public int getFood(){
        int result = 0;
        if(this == Ressource.BOIS){
            result = 1;
        }
        else if(this == Ressource.BLE){
            result = 5;
        }
        return result;
    }
}
