package game ;

import game.*;
import java.util.*;


public class Player{
    protected int score;
    protected String name;
    protected int gold;
    protected HashMap<Ressource, Integer> ressource;

    /** consturct the player object
      *  @param name the name of the player
      */
    public Player(String name){
        this.name = name;
        this.gold = 0;
        this.score = 0;
        this.ressource = new HashMap<Ressource, Integer>();
        this.ressource.put(Ressource.ROCHE, 0);
        this.ressource.put(Ressource.BLE, 0);
        this.ressource.put(Ressource.SABLE, 0);
        this.ressource.put(Ressource.BOIS, 0);
    }

    /** get the ressource value
      *  @param r ressource
      *  @return ressource value
      */
    public int getRessource(Ressource r){
        return this.ressource.get(r);
    }

    /** add ressource value by the quantity given in the param
      *  @param r ressource
      *  @param qte quantity
      */
    public void addRessource(Ressource r, int qte){
      this.ressource.put(r, this.ressource.get(r)+qte);
    }

    /** get the name of the player
      *  @return name
      */
    public String getName(){
        return this.name;
    }

    /** get the score of the player
      *  @return score
      */
    public int getScore(){
        return this.score;
    }

    /** add points
      *  @param pts int
      */
    public void addPoints(int pts){
        this.score +=pts;
    }

    public String toString(){
        return "le score est de " + this.score + ", le nom du joueur est"
        + this.name + "le nombre de pieces d'or est de" + this.gold;
    }

    /** equals methode for players
      *  @param o object
      *  @return boolean
      */
    public boolean equals (Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player other = (Player) o;
        return this.name == other.name;
    }

    /** get the gold value
      *  @return gold value
      */
    public int getGold(){
        return this.gold;
    }

    /** add the value of the gold
      *  @param g quantityOfTheGold

      */
    public void addGold(int g){
      this.gold += g;
    }

    /** remove a quantity from the value of the gold
      *  @param g a int
      */
    public void removeGold(int g){
      this.gold = this.gold - g;
    }
}
