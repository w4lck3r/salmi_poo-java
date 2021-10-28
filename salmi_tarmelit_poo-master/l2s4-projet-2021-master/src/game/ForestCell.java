package game ;

import game.*;

public class ForestCell extends Cell{
  protected static final int POINTS = 2;
  protected static final int COST = 1;
  protected static final Ressource RESSOURCE = Ressource.BOIS;

  /** create a forest cell
    *  @param x position x of the cell
    *  @param y position y of the cell
    */
  public ForestCell(int x, int y){
    super(x,y);
  }

  /** return the numbers of points of the cell
    *  @return the numbers of points of the cell
    */
  public int getPoints(){
    return this.POINTS;
  }

  /** return the cost of the cell
    *  @return the cost of the cell
    */
  public int getCost(){
    return this.COST;
  }

  /** return the ressource of the cell
    *  @return the ressource of the cell
    */
  public Ressource getRessource(){
    return this.RESSOURCE;
  }

  public String toString() {
    return "F " + super.posX + "," + super.posY;
  }

  /** return the type of the cell
    * return text
    */
  public String type() {
    return "F ";
  }
}
