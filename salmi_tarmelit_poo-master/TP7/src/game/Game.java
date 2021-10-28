package game;
/**
 * A class to create and manage a game of shifumi.
 * @author SALMI Badr-Eddine / TARMELIT Lydia
 * @version v1.0
 */
public class Game{
  //Instance variables :
  /*The first player*/
  private Player player1;
  /*The second player*/
  private Player player2;
  /*The number of rounds before the end of the game*/
  private int nbRounds;
  /*Points awarded to the winner*/
  private final int WIN_POINTS = 2;
  /*Points awarded to both players if they play the same Shape*/
  private final int NULL_POINTS = 1;
  /*Points awarded to the loser*/
  private final int LOSE_POINTS = 0;

  /**
    * Constructor for Game.
    * @param player1 The first Player.
    * @param player2 The second Player.
    * @param nbRounds The number of rounds in the game.
    * @throws IllegalArgumentException If given number of round is lower or equals to 0.
    */
  public Game(Player player1,Player player2,int nbRounds)throws IllegalArgumentException{
    if(nbRounds>0){
      this.player1 = player1;
      this.player2= player2;
      this.nbRounds = nbRounds;
    }
    else
      throw new IllegalArgumentException("Number of rounds must be greater than 0.");
  }

  /**
    * Indicates if the game is over.
    * @return <code>true</code> if the game is over otherwise <code>false</code>
    */
  private boolean isFinished(){
    if (this.nbRounds == 0)
      return true;
    else
      return false;
  }

  /**
    *Play a game of shifumi.
    */
  public void play(){
    while (!this.isFinished()){
      playOneRound();
    }
    int player1Points=this.player1.getPoints();
    int player2Points=this.player2.getPoints();
    if (player1Points > player2Points)
      System.out.println("The winner of the game is "+ this.player1.getName()+" with "+player1Points+" points.\n"
      +this.player2.getName()+" lose with "+player2Points+" points.");
    else if(player1Points == player2Points)
      System.out.println("Equality for both players, nobody win the game.\n"+this.player1.getName()+" and "+this.player2.getName()+" have "+player2Points+" points.");
    else
      System.out.println("The winner of the game is "+ this.player2.getName()+" with "+player2Points+" points.\n"
      +this.player1.getName()+" lose with "+player1Points+" points.");
  }

  /**
    * Gives points to players.
    * @param points The number of given points.
    */
  private void givePoints(int points){
    if (points ==0){
      this.player1.addPoints(this.NULL_POINTS);
      this.player2.addPoints(this.NULL_POINTS);
    }
    else{
      if(points == -1){
        this.player1.addPoints(this.LOSE_POINTS);
        this.player2.addPoints(this.WIN_POINTS);
      }
      else if(points == 1){
        this.player1.addPoints(this.WIN_POINTS);
        this.player2.addPoints(this.LOSE_POINTS);
      }
    }
  }

  /**
    * Play one round of shifumi.
    */
  private void playOneRound(){
    System.out.println(this.player1.getName()+" :");
    this.player1.play();
    System.out.println(this.player2.getName()+" :");
    this.player2.play();
    System.out.println("\n"+this.player1.toString()+" and "+this.player2.toString()+".");
    int res=this.player1.getShape().compareShape(this.player2.getShape());
    if(res==0){
      System.out.println("Equality both players win "+this.NULL_POINTS+" points.");
      givePoints(res);
    }
    else if (res==-1){
      System.out.println(this.player2.getName()+" win and get "+this.WIN_POINTS+" points.");
      givePoints(res);
    }
    else{
      System.out.println(this.player1.getName()+" win and get "+this.WIN_POINTS+" points.");
      givePoints(res);
    }
    System.out.println("The score is now: "+this.player1.getName()+" = "+this.player1.getPoints()+" points - "+this.player2.getName()
    +" = "+this.player2.getPoints()+" points.\n");
    this.nbRounds--;
  }

}
