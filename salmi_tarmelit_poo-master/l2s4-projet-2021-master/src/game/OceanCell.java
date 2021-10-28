package game ;

import game.*;

public class OceanCell extends Cell{

  /** create a desert cell
    *  @param x position x of the cell
    *  @param y position y of the cell
    */
  public OceanCell(int x, int y){
    super(x,y);
  }

  /** return the numbers of points of the cell
    *  @return the numbers of points of the cell
    */
  public int getPoints(){
    return 0;
  }

  /** return the cost of the cell
    *  @return the cost of the cell
    */
  public int getCost(){
    return 0;
  }

  /** return the ressource of the cell
    *  @return the ressource of the cell
    */
  public Ressource getRessource(){
    return null;
  }

  public String toString() {
    return "O " + super.posX + "," + super.posY;
  }

  /** return the type of the cell
    * return text
    */
  public String type() {
    return "O ";
  }
}
