package game;

import game.*;

public class Caracter{
  protected Cell cell;
  protected int gold;
  protected Player player;

  /** create a caracter
    *  @param c the cell
    *  @param p the player
    */
  public Caracter(Cell c, Player p){
    if (verifCell(c)){
      this.cell = c;
    }
    this.gold = 0;
    this.player = p;
  }

  /** return the value of the gold
    *  @return gold
    */
  public int getGold(){
      return this.gold;
  }

  /** set the value of the gold
    *  @param g the value of the gold
    */
  public void addGold(int g){
      this.gold += g;
  }

  /** return the cell
    *  @return cell
    */
  public Cell getCell(){
      return this.cell;
  }

  /** set the cell
    *  @param c the new cell
    */
  public void setCell(Cell c){
    this.cell = c;
  }

  /** verifie if the cell doesnt have a player
    *  @param c a cell
    *  @return res boolean
    */
  public boolean verifCell(Cell c){
    boolean res = false;
    if(c.getPlayer() == null){
      res = true;
    }
    return res;
  }

  /** return the cells player
    *  @return player
    */
  public Player getPlayer(){
      return this.player;
  }

  /** set the cells player
    *  @param p the new player
    */
  public void setPlayer(Player p){
    this.player = p;
  }
}
