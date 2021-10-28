package game;

import game.*;

public abstract class Cell{
  protected int posX;
  protected int posY;
  protected Player player;
  protected Army army;
  protected Farmer farmer;

  /** create a cell
    *  @param x position x of the cell
    *  @param y position y of the cell
    */
  public Cell(int x, int y){
    this.posX = x;
    this.posY = y;
    this.player = null;
    this.army = null;
    this.farmer = null;
  }

  /** return position x of the cell
    *  @return position x of the cell
    */
  public int getPosX(){
    return this.posX;
  }

  /** return position y of the cell
    *  @return position y of the cell
    */
  public int getPosY(){
    return this.posY;
  }

  /**
    *set cell's player
    *@param p the new player
    */
  public void setPlayer(Player p){
    this.player = p;
  }

  /**
    *remove cell's player
    *we dont need a param player because the cell have just one player max
    */
  public void removePlayer(){
    this.player = null;
  }

  /**
    *return cells player
    *@return player
    */
  public Player getPlayer(){
    return this.player;
  }

  /**
    *set cell's army
    *@param c the new army
    */
  public void setArmy(Army c){
    this.army = c;
  }

  /**
    *remove cell's army
    *we dont need a param Army because the cell have just one player max
    */
  public void removeArmy(){
    this.army = null;
  }

  /**
    *return cells Army
    *@return Army
    */
  public Army getArmy(){
    return this.army;
  }

  /**
    *set cell's farmer
    *@param c the new farmer
    */
  public void setFarmer(Farmer c){
    this.farmer = c;
  }

  /**
    *remove cell's farmer
    *we dont need a param farmer because the cell have just one player max
    */
  public void removeFarmer(){
    this.farmer = null;
  }

  /**
    *return cells Farmer
    *@return farmer
    */
  public Farmer getFarmer(){
    return this.farmer;
  }

  /**
    *equals methode of two cells
    *@param o a object
    *@return boolean
    */
  public boolean equals(Object o){
    if(o instanceof Cell){
      Cell other = (Cell) o;
      return (this.posX == other.posX)&&(this.posY == other.posY);
    }
    else
      return false;
  }

  /** return the numbers of points of the cell
    *@return a int
    */
  public abstract int getPoints();

  /** return the cost of the cell
    *@return a int
    */
  public abstract int getCost();

  /** return the ressource of the cell
    *@return a ressource
    */
  public abstract Ressource getRessource();

  /** get a text  about the positions of the cell
    * return text
    */
  public String toString() {
    return "X " + this.posX + "," + this.posY;
  }

  /** return the type of the cell
    * @return text
    */
  public String type() {
    return "X ";
  }
}
