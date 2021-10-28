package game;

import java.util.*;
import game.*;

public class WarPlayer extends Player {
    protected int soldiers ;
    protected ArrayList<Army> army ;
    protected int food;

    /** the constructor of the warplayer
      *  @param name the name of the warPlayer
      */
    public WarPlayer(String name){
        super(name);
        this.soldiers = 35;
        this.food = 10;
        this.army = new ArrayList<Army>();
    }

    /**  get the soldiers
      *  @return soldiers
      */
    public int getSoldiers(){
        return this.soldiers;
    }
    /** return the army owned by the player
      *  @return army
      */
    public ArrayList<Army> allArmy(){
      return this.army;
    }

    /** get the army by the index of the list
      *  @param i index of army list
      *  @return the army
      */
    public Army getArmy(int i){
      return this.army.get(i);
    }

    /** add an army to the player and encrease the number of soldiers
      *  @param a army
      */
    public void addArmy(Army a){
      this.army.add(a);
      this.decrementSoldiers(a.getLength());
    }

    /** decrease the number of the soldiers
      *  @param i number of soldiers
      */
    public void decrementSoldiers(int i){
      this.soldiers = this.soldiers - i;
    }

    /** get the food
      *  @return food value
      */
    public int getFood(){
        return this.food;
    }

    /** add food value
      *  @param food a int
      */
    public void addFood(int food){
        this.food += food;
    }

    /** deploy a army
      *  @param l number of soldiers
      *  @param cell cell of the new army
      *  @param board board of the game
      *  @param otherP other player in the game
      *  @return true if a army is deployed
      */
    public boolean deploy(int l , Cell cell, Board board, WarPlayer otherP){
      boolean res = false;
      if(l<=this.soldiers && cell.getPlayer()==null && !(cell instanceof OceanCell)){
        Army newArmy = new Army(cell, l, this);
        cell.setArmy(newArmy);
        cell.setPlayer(this);
        this.affecte4Cells(l, cell, board, otherP);
        this.addArmy(newArmy);
        res = true;
      }
      return res;
    }

    /** affect 4 cells around a cell
      *  @param l number of soldiers
      *  @param cell cell of the new army
      *  @param board board of the game
      *  @param otherP other player in the game
      */
    public void affecte4Cells(int l, Cell cell, Board board, WarPlayer otherP){
      int i = cell.getPosX();
      int j = cell.getPosY();
      Cell other;
      if(i > 0){
        other = board.getCell(i-1,j);
        this.affecte(cell, other, otherP);
      }
      if(j > 0){
        other = board.getCell(i,j-1);
        this.affecte(cell, other, otherP);
      }
      if(i+1 < board.getNbCells()){
        other = board.getCell(i+1,j);
        this.affecte(cell, other, otherP);
      }
      if(j+1 < board.getNbCells()){
        other = board.getCell(i,j+1);
        this.affecte(cell, other, otherP);
      }
    }

    /** affect a cell
      *  @param cell cell of the new army
      *  @param other cell that is affected
      *  @param otherP other player in the game
      */
    public void affecte(Cell cell, Cell other, WarPlayer otherP){
      Army a = other.getArmy();
      if(other.getPlayer()!=null && a.getLength()<cell.getArmy().getLength()){
        System.out.println(" l'armée déployer rentre en conflit avec l'armée sur la case : " + other);
        if(other.getPlayer()==this){
          System.out.println(" l'armée déployer gagne 1 d'or, l'autre armée gagne 1 guerrier");
          a.incrementLength();
          cell.getArmy().addGold(1);
        }
        else{
          System.out.println(" l'armée sur la case : " + other + " voit son nombre de guerriers diviser pas 2");
          a.setLength(a.getLength()/2);
          System.out.println(a.getLength());
          if(a.getLength()<1){
            System.out.println(" l'armée déployer gagne 2 d'or et l'autre armée change de joueur");
            this.addArmy(a);
            otherP.lostArmy(a);
            other.setPlayer(this);
            a.setPlayer(this);
            cell.getArmy().addGold(2);
          }
        }
      }
    }

    /** feed all of the army
      */
    public void feed(){
      for(int i=0;i<this.army.size();i++){
        int f = this.army.get(i).getLength();
        if(this.army.get(i).getCell() instanceof DesertCell){
          f = f*2;
        }
        if(this.army.get(i).getCell() instanceof MontainCell){
          f = f-2;
        }
        if(this.getFood() >= f){
          this.food = this.food - f;
        }
        else{
          this.lostArmy(this.army.get(i));
          i = i-1;
          this.addGold(1);
          System.out.println(" pas assez de nouritures, une armée a été perdue");
        }
      }
    }

    /** lose a army
      *  @param lost a army who lost
      */
    public void lostArmy(Army lost){
       int i = 0;
       boolean find = false;
       while(!find && i<this.army.size()){
         if(this.army.get(i).getCell().equals(lost.getCell())){
           this.army.get(i).getCell().removePlayer();
           this.army.get(i).getCell().removeArmy();
           this.army.remove(i);
           find = true;
         }
         i += 1;
       }
    }

    /** change all of ressources in food
      */
    public void changeRessource(){
      int fRoche = super.ressource.get(Ressource.ROCHE) * Ressource.ROCHE.getFood();
      int fBle = this.ressource.get(Ressource.BLE) * Ressource.BLE.getFood();
      int fSable = this.ressource.get(Ressource.SABLE) * Ressource.SABLE.getFood();
      int fBois = this.ressource.get(Ressource.BOIS) * Ressource.BOIS.getFood();
      this.ressource.put(Ressource.ROCHE, 0);
      this.ressource.put(Ressource.BLE, 0);
      this.ressource.put(Ressource.SABLE, 0);
      this.ressource.put(Ressource.BOIS, 0);
      this.addFood(fRoche);
      this.addFood(fBle);
      this.addFood(fSable);
      this.addFood(fBois);
    }

    /** harvest all of the cell of the player
      */
    public void harvest(){
      for(int i=0;i<this.army.size();i++){
        Ressource r = this.army.get(i).getCell().getRessource();
        this.addRessource(r, 1);
      }
    }

    public String toString() {
      return super.name + ", reste " + this.soldiers + " guerriers, " + super.gold + " pièces d'or, " + this.army.size() + " armées deployées, " + this.food + " nouritures, joue";
    }
}
