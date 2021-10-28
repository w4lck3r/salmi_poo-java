package game;

import java.util.*;
/**
 *  main of game
 *
 * @author Vandroemme Téo
 * @version 1.0
 */
 import game.*;

 public class Main {

    public static void main(String[] args) {
      String name1, name2;
      if(args.length == 3){
        name1 = args[1];
        name2 = args[2];
      }
      else{
        name1 = "Salameche";
        name2 = "Moustillon";
      }
      if(args.length == 0){
        // declaration des variables necessaire au lancement d'une partie de developpement agricole
        FarmingPlayer player1 = new FarmingPlayer(name1);
        FarmingPlayer player2 = new FarmingPlayer(name2);
        FarmingGame game1 = new FarmingGame(10);
        // ajout des joueurs à la partie
        game1.addPlayer(player1, player2);
        // lancement du jeu de developpement agricole
        game1.play();

        // declaration des variables necessaire au lancement d'une partie de guerre
        WarPlayer player3 = new WarPlayer(name1);
        WarPlayer player4 = new WarPlayer(name2);
        WarGame game2 = new WarGame(10);
        // ajout des joueurs à la partie
        game2.addPlayer(player3, player4);
        // lancement du jeu de guerre
        game2.play();
      }
      // si le premiers argument est 1 alors on lance le jeu de guerre,
      // sinon on lance le jeu de developpement agricole
      else{
        if(Integer.parseInt(args[0]) == 1){
          // declaration des variables necessaire au lancement d'une partie de guerre
          WarPlayer player3 = new WarPlayer(name1);
          WarPlayer player4 = new WarPlayer(name2);
          WarGame game2 = new WarGame(10);
          // ajout des joueurs à la partie
          game2.addPlayer(player3, player4);
          // lancement du jeu de guerre
          game2.play();
        }
        else{
          // declaration des variables necessaire au lancement d'une partie de developpement agricole
          FarmingPlayer player1 = new FarmingPlayer(name1);
          FarmingPlayer player2 = new FarmingPlayer(name2);
          FarmingGame game1 = new FarmingGame(10);
          // ajout des joueurs à la partie
          game1.addPlayer(player1, player2);
          // lancement du jeu de developpement agricole
          game1.play();
        }
      }

    }
 }
