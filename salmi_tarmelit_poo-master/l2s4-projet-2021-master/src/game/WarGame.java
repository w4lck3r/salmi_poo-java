package game;

import game.*;
import java.util.*;

public class WarGame extends Game{
  protected static final int NBROUND = 10;
  protected WarPlayer warPlayer1;
  protected WarPlayer warPlayer2;

  /** create a war game
    *  @param nbCells the number of cells of the board
    */
  public WarGame(int nbCells){
    super(nbCells);
  }

  /** add players to the game
    *  @param p1 the first player
    *  @param p2 the second player
    */
  public void addPlayer(WarPlayer p1, WarPlayer p2){
    this.warPlayer1 = p1;
    this.warPlayer2 = p2;
  }

  /** get the warPlayer 1
    *  @return warPlayer 1
    */
  public WarPlayer getPlayer1(){
    return this.warPlayer1;
  }

  /** get the warPlayer 2
    *  @return warPlayer 2
    */
  public WarPlayer getPlayer2(){
    return this.warPlayer2;
  }

  /** return the next WarPlayer who have to play
    *  @param currentWarPlayer the current WarPlayer
       @return the next WarPlayer who have to play
    */
  public WarPlayer nextPlayer(WarPlayer currentWarPlayer){
    if(currentWarPlayer == null){
      return this.warPlayer1;
    }
    else if(currentWarPlayer.equals(warPlayer1)){
      return this.warPlayer2;
    }
    else{
      return this.warPlayer1;
    }
  }

  /** get the number of round
    *  @return number of round
    */
  public int getNbRound(){
    return this.NBROUND;
  }

  /** gerenate a random army
    *  @return arrau of 3 number, x of the cell, y of the cell and length of the army
    */
  public int[] armeeAleatoire(){
    boolean ocean = true;
    int[] res = new int[3];
    while(ocean){
      // coordonnées x alèatoire
      res[0] = (int)(Math.random()*this.board.getNbCells());
      // coordonnées y alèatoire
      res[1] = (int)(Math.random()*this.board.getNbCells());
      if(!(this.board.getCell(res[0], res[1]) instanceof OceanCell)){
        ocean = false;
      }
    }
    if(this.board.getCell(res[0], res[1]) instanceof MontainCell || this.board.getCell(res[0], res[1]) instanceof DesertCell){
      res[2] = (int)((Math.random()*3)+1);
    }
    else{
      res[2] = (int)((Math.random()*5)+1);
    }
    return res;
  }

  /** deploy an army depends of the number of soldiers
    *  @param p the warPlayer
    */
  public void deployOrNothing(WarPlayer p){
    if((int)(Math.random()*2) == 0){
      int[] army = this.armeeAleatoire();
      System.out.println("-Déploie une armée de "+ army[2] + " guerriers");
      System.out.println(" sur " + this.board.getCell(army[0], army[1]));
      if(army[2] > p.soldiers){
        System.out.println(" pas assez de guerriers disponible");
      }
      else{
        if(p.deploy(army[2], this.board.getCell(army[0], army[1]), this.board, this.nextPlayer(p))){
          System.out.println(" " + this.board.getCell(army[0], army[1]) + " n'est pas occupee, l'armée a été deployer");
        }
        else{
          System.out.println(" " + this.board.getCell(army[0], army[1]) + " est occupee, l'armée n'a pas été deployer");
        }
      }
    }
    else{
      System.out.println("-Ne fait rien");
    }
  }

  /** play the game for just a single round
    *  @param p the name of the warPlayer d
    */
  public void play1Round(WarPlayer p){
    System.out.println("Joueur : " + p);
    // alèatoire entre deployer une armée et ne rien faire
    this.deployOrNothing(p);
    // le joueur recolte les ressources
    System.out.println("-Recolte des ressources");
    p.harvest();
    // transformation des ressources en nouritures
    p.changeRessource();
    // le joueurs nourrit ses armées
    System.out.println("-Nourrit ses armées");
    p.feed();
    System.out.println("----------");
  }

  /** calcul of the points collected by the warplayer
    *  @param p the name of the warPlayer
    */
  public void comptagePoints(WarPlayer p){
    p.addPoints(p.getGold());
    for(int i=0; i<p.allArmy().size(); i++){
      p.addPoints(p.getArmy(i).getGold());
      p.addPoints(p.getArmy(i).getCell().getPoints());
    }
    if(p.allArmy().size() >= 10){
      p.addPoints(5);
    }
  }

  /**play the game
    */
  public void play(){
    System.out.println("\nLancement d'une partie de Guerre :");
    System.out.println("----------");
    this.board.initBoard();
    System.out.println(this.board);
    System.out.println("----------");
    for(int i = 0; i<NBROUND; i++){
      System.out.println("Tour " + (i+1));
      System.out.println("----------");
      if(this.canPlay()){
        this.play1Round(this.warPlayer1);
      }
      if(this.canPlay()){
        this.play1Round(this.warPlayer2);
      }
    }
    System.out.println("Fin du jeu");
    System.out.println("----------");
    this.comptagePoints(this.warPlayer1);
    this.comptagePoints(this.warPlayer2);
    this.whoWin(this.warPlayer1, this.warPlayer2);
  }

  /** predicat, there are free cell
    *  @return true if a cell is free, false if not
    */
  public boolean canPlay(){
    return super.nb_cells>(this.warPlayer1.allArmy().size()+this.warPlayer2.allArmy().size());
  }
}
