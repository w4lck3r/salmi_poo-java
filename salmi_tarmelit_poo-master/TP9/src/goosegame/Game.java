package goosegame;
import java.util.*;
import goosegame.cells.*;
/**
  * A class to create a game for goosegame.
 * @author SALMI Badr-eddine / TARMELIT Lydia
 * @version 22/12/2020
  */
public class Game{
  //Instances variables :
  /*The list of player which play in the game.*/
  protected List<Player> thePlayers;
  /*The goose game board.*/
  protected Board board;
  /*The first player is always the player in the index 0 of the list of players.*/
  private static final int FIRST_PLAYER=0;
  /*The number of cell on the game board.*/
  private static int BOARD_CELLS_NUMBER;

  /**
    * Constructor for Game.
    * Creates a goose game and initialize a game board without player.
    * @param board The goose game board.
    */
  public Game(Board board){
    this.board = board;
    this.thePlayers = new ArrayList<Player>();
    this.BOARD_CELLS_NUMBER=this.board.getNumberOfCells()-1;
  }

  /**
    * Adds a player in the Game.
    * @param p The player to add.
    * @throws IllegalArgumentException If player is null.
    */
  public void addPlayer(Player p)throws IllegalArgumentException{
    if(p == null)
      throw new IllegalArgumentException("Player can't be null please give a correct player.");
    this.thePlayers.add(p);
    this.board.getCell(0).setPlayer(p);
    p.setCell(this.board.getCell(0));
  }

  /**
    * Indicates is a player has won the game.
    * @param p The player to know if he win the game.
    * @return <code>true</code> if the player win otherwise <code>false</code>.
    */
  private static boolean hasWon(Player p){
    return p.getCell().getIndex()!=BOARD_CELLS_NUMBER;
  }

  /**
    * Plays a goose game.
    * The game close only if a player win the game.
    * Bad Side effect : An infinite game may occurs if all players are trapped.
    * @throws goosegame.InvalidNumberPlayerException If someone tries to play without putting one or more players on the board.
    */
  public void play()throws InvalidNumberPlayerException{
    if(this.thePlayers.isEmpty()){
      throw new InvalidNumberPlayerException("To play a goose game, players must be set on the board.");
    }
    int playerIndex = this.FIRST_PLAYER;
    Player currentPlayer = thePlayers.get(playerIndex);
    Cell currentCell=currentPlayer.getCell();
    //While one player is not on the last cell, we play (an infinite game may occur):
    while(Game.hasWon(currentPlayer)){
      //Gets current player and increment (after getting the current player) to prepare the next player.
      currentPlayer=thePlayers.get((playerIndex++)%thePlayers.size());
      currentCell=currentPlayer.getCell();
      if(currentCell.canLeave()){
        this.playOneRound(currentPlayer);
      }
      else{//He can't play
        System.out.println(currentPlayer.toString()+" is in "+currentCell.toString()+", "+currentPlayer.toString()+" cannot play.");
      }
    }
    System.out.println(currentPlayer.toString()+" has won.");
  }


  /**
    * Plays a round of the goose game for a given player.
    * Side effect : Displays message on the standard output.
    * @param p The player which play the round.
    */
  private void playOneRound(Player p){
    Cell originalPlayerCell =p.getCell();
    String statusMessage=p.toString()+" is in cell "+originalPlayerCell.getIndex();
    //He can throw dices.
    int diceResult = p.twoDiceThrow();
    statusMessage+=", "+p.toString()+" throws "+diceResult;
    //Calculates the target cell and his action :
    int nextCell = originalPlayerCell.getIndex() + diceResult;
    //If the next cell index is greater than the board cell number, the player go back from the number of cell he has exceeded.
    if (BOARD_CELLS_NUMBER < nextCell){
        nextCell = BOARD_CELLS_NUMBER-(nextCell - BOARD_CELLS_NUMBER);
        statusMessage+=", "+p.toString()+" is out of the board "+p.toString()+" go back to "+nextCell;
    }
    //If the next cell index is lower than the first cell number, the player go forward to complete the number of cell he has exceeded.
    if(nextCell<0){
      nextCell=1;
      statusMessage+=", "+p.toString()+" is behind the board "+p.toString()+" go back to "+nextCell;
    }
    int newCell = this.board.getCell(nextCell).action(diceResult);
    /*If the next cell's action is a forward move, maybe the new index got is greater than the board cell number,
     then the player go back from the number of cell he has exceeded.*/
    if (BOARD_CELLS_NUMBER < newCell){
        newCell = BOARD_CELLS_NUMBER-(newCell - BOARD_CELLS_NUMBER);
        statusMessage+=", "+p.toString()+" is out of the board "+p.toString()+" go back to "+newCell;
    }
    /*If the next cell's action is a forward move, maybe the new index got is lower than the first cell index,
    then the player go forward to complete the number of cell he has exceeded.*/
    if(newCell<0){
      newCell=1;
      statusMessage+=", "+p.toString()+" is behind the board "+p.toString()+" go back to "+newCell;
    }
    Cell target= this.board.getCell(newCell);
    //Moves the player p.
    if(target.isBusy()){
      //If the cell is busy we invert players.
      Player playerFired = target.getPlayer();
      target.removePlayer();
      originalPlayerCell.removePlayer();
      target.setPlayer(p);
      p.setCell(target);
      originalPlayerCell.setPlayer(playerFired);
      playerFired.setCell(originalPlayerCell);
      statusMessage+=" cell is busy, "+playerFired.toString()+" is sent to "+originalPlayerCell.toString();
    }
    else{
      originalPlayerCell.removePlayer();
      target.setPlayer(p);
      p.setCell(target);
      if(newCell!=nextCell)
        statusMessage+=" and reaches "+this.board.getCell(nextCell).toString()+"cell "+newCell;
      else
        statusMessage+=" and reaches "+target.toString();
    }
    System.out.println(statusMessage);
  }

}
