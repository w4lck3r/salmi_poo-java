package game;

import game.*;

public abstract class Game{
  protected Board board;
  protected int nb_cells;

  /** create a game
    *  @param nbCells the number of cells of the board
    */
  public Game(int nbCells){
    this.board = new Board(nbCells);
    this.nb_cells = this.getBoard().getNbCells()*this.getBoard().getNbCells()/3;
  }

  /** get the bord of the game
    *  @return board
    */
  public Board getBoard(){
    return this.board;
  }

  /** get the score of the game
    *  @param p1 the first player
    *  @param p2 the second player
    */
  public void whoWin(Player p1, Player p2){
    if(p1.getScore() > p2.getScore()){
      System.out.println("Le gagnant est " + p1.getName() + " avec " + p1.getScore() + " points");
      System.out.println("Le perdant est " + p2.getName() + " avec " + p2.getScore() + " points");
      System.out.println("----------");
    }
    else if(p1.getScore() < p2.getScore()){
      System.out.println("Le gagnant est " + p2.getName() + " avec " + p2.getScore() + " points");
      System.out.println("Le perdant est " + p1.getName() + " avec " + p1.getScore() + " points");
      System.out.println("----------");
    }
    else{
      System.out.println("Il y a une égalité entre les deux joueurs avec " + p1.getScore() + " points");
    }
  }

  /**play the game
    */
  public  abstract  void play();
}
