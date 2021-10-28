package game ;

import game.*;

public class DesertCell extends Cell{
  protected static final int POINTS = 4;
  protected static final int COST = 3;
  protected static final Ressource RESSOURCE = Ressource.SABLE;

  /** create a desert cell
    *  @param x position x of the cell
    *  @param y position y of the cell
    */
  public DesertCell(int x, int y){
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
    return "D " + super.posX + "," + super.posY;
  }

  /** return the type of the cell
    * return text
    */
  public String type() {
    return "D ";
  }
}
