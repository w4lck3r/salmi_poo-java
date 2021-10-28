package game;

import game.*;

public class FarmingGame extends Game{
  protected static final int NBROUND = 6;
  protected FarmingPlayer farmingPlayer1;
  protected FarmingPlayer farmingPlayer2;

  /** create a farming game
    *  @param nbCells the number of cells of the board
    */
  public FarmingGame(int nbCells){
    super(nbCells);
  }

  /** add player at the game
    *  @param p1 a farmingPlayer
    *  @param p2 a farmingPlayer
    */
  public void addPlayer(FarmingPlayer p1, FarmingPlayer p2){
    this.farmingPlayer1 = p1;
    this.farmingPlayer2 = p2;
  }

  /** get the player 1
    *  @return player 1
    */
  public FarmingPlayer getPlayer1(){
    return this.farmingPlayer1;
  }

  /** get the player 2
    *  @return player 2
    */
  public FarmingPlayer getPlayer2(){
    return this.farmingPlayer2;
  }

  /** return the next player who have to play
    *  @param currentPlayer the current farmingPlayer
    *  @return the next farmingPlayer who have to play
    */
  public FarmingPlayer nextPlayer(FarmingPlayer currentPlayer){
    if(currentPlayer == null){
      return this.farmingPlayer1;
    }
    else if(currentPlayer.equals(farmingPlayer1)){
      return this.farmingPlayer2;
    }
    else{
      return this.farmingPlayer1;
    }
  }

  /** get the number of round
    *  @return number of round
    */
  public int getNbRound(){
    return this.NBROUND;
  }

  /** calcul of points
    *  @param p the farmingPlayer
    */
  public void comptagePoints(FarmingPlayer p){
    p.addPoints(p.getGold());
    for(int i=0; i<p.getDeployedFarmers().size(); i++){
      p.addPoints(p.getDeployedFarmers().get(i).getGold());
    }
  }

  /** test if a random cell is type of ocean
    *  @return ocean boolean
    */
  public int[] cellAleatoire(){
    boolean ocean = true;
    int[] res = new int[2];
    while(ocean){
      // coordonnées x alèatoire
      res[0] = (int)(Math.random()*this.board.getNbCells());
      // coordonnées y alèatoire
      res[1] = (int)(Math.random()*this.board.getNbCells());
      if(!(this.board.getCell(res[0], res[1]) instanceof OceanCell)){
        ocean = false;
      }
    }
    return res;
  }

  /** chosing randomly if the player will deploy change or do nothing
    *  @param p farmingPlayer
    */
  public void deployOrChangeOrNothing(FarmingPlayer p){
    int r = (int)(Math.random()*3);
    if(r == 0){
      int[] cell = this.cellAleatoire();
      System.out.println("-Déploie une fermiers");
      System.out.println(" sur " + this.board.getCell(cell[0], cell[1]));
      if(p.deploy(this.board.getCell(cell[0], cell[1]))){
        System.out.println(" " + this.board.getCell(cell[0], cell[1]) + " n'est pas occupee, le fermiers a été deployée");
      }
      else{
        System.out.println(" " + this.board.getCell(cell[0], cell[1]) + " est occupee, le fermiers n'a pas été deployée");
      }
    }
    else if(r == 1){
      System.out.println("-Echange les ressources");
      p.changeRessource();
    }
    else{
      System.out.println("-Ne fait rien");
    }
  }

  /** methode to get the game be played by just one round
    *  @param p farmingPlayer
    */
  public void play1Round(FarmingPlayer p){
    System.out.println("Joueur : " + p);
    // alèatoire entre deployer une fermiers, échanger les ressources et ne rien faire
    this.deployOrChangeOrNothing(p);
    // le joueur recolte les ressources
    System.out.println("-Recolte des ressources");
    p.harvest();
    // le joueurs paye ses fermiers
    System.out.println("-Paye ses fermiers");
    p.pay();
    System.out.println("----------");
  }

  /**play the game by using the methode of playing just one round
    */
  public void play(){
    System.out.println("\nLancement d'une partie de Développement Agricole :");
    System.out.println("----------");
    this.board.initBoard();
    System.out.println(this.board);
    System.out.println("----------");
    for(int i = 0; i<NBROUND; i++){
      System.out.println("Tour " + (i+1));
      System.out.println("----------");
      if(this.canPlay()){
        this.play1Round(this.farmingPlayer1);
      }
      if(this.canPlay()){
        this.play1Round(this.farmingPlayer2);
      }
      else{
        System.out.println("Impossible de jouer, aucune case n'est disponible");
      }
    }
    System.out.println("Fin du jeu");
    System.out.println("----------");
    this.comptagePoints(this.farmingPlayer1);
    this.comptagePoints(this.farmingPlayer2);
    this.whoWin(this.farmingPlayer1, this.farmingPlayer2);
  }

  /** predicat, there are free cell
    *  @return true if a cell is free, false if not
    */
  public boolean canPlay(){
    return super.nb_cells>(this.farmingPlayer1.getDeployedFarmers().size()+this.farmingPlayer2.getDeployedFarmers().size());
  }
}
