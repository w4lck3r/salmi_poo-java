package game;
import java.util.*;
import game.*;
public class FarmingPlayer extends Player {
  protected ArrayList<Farmer> deployedFarmers;

  /** construct the farming player by the name , give the player 15 coins of gold
    *  @param name the name of farming player
    */
  public FarmingPlayer(String name){
    super(name);
    super.gold = 15;
    this.deployedFarmers = new ArrayList<Farmer>();
  }

  /** get the deployed farmers
    *  @return deployedFarmers
    */
  public ArrayList<Farmer> getDeployedFarmers(){
    return this.deployedFarmers;
  }

  /** add a deployed farmers
    *  @param f farmers
    */
  public void addFarmer(Farmer f){
    this.deployedFarmers.add(f);
  }

  /** pay the farmers
    */
  public void pay(){
    for(int i=0;i<this.deployedFarmers.size();i++){
      int cost = this.deployedFarmers.get(i).getCell().getCost();
      this.deployedFarmers.get(i).addGold(cost);
      if(this.getGold() >= cost){
        super.gold = super.gold - cost;
      }
      else{
        this.lostFarmer(this.deployedFarmers.get(i));
        i = i-1;
        System.out.println(" pas assez d'or, un ouvrier a été perdue");
      }
    }
  }

  /** method to deploy another cell it could be false if the cell is already taken for ig
    *  @param cell a cell
    *  @return res boolean
    */
  public boolean deploy(Cell cell){
    boolean res = false;
    if(cell.getPlayer()==null && !(cell instanceof OceanCell)){
      Farmer newFarmer = new Farmer(cell, this);
      cell.setFarmer(newFarmer);
      cell.setPlayer(this);
      this.addFarmer(newFarmer);
      res = true;
    }
    return res;
  }

  /** change ressource in gold
    */
  public void changeRessource(){
    int gRoche = this.ressource.get(Ressource.ROCHE) * Ressource.ROCHE.getGold();
    int gBle = this.ressource.get(Ressource.BLE) * Ressource.BLE.getGold();
    int gSable = this.ressource.get(Ressource.SABLE) * Ressource.SABLE.getGold();
    int gBois = this.ressource.get(Ressource.BOIS) * Ressource.BOIS.getGold();
    this.ressource.put(Ressource.ROCHE, 0);
    this.ressource.put(Ressource.BLE, 0);
    this.ressource.put(Ressource.SABLE, 0);
    this.ressource.put(Ressource.BOIS, 0);
    this.addGold(gRoche);
    this.addGold(gBle);
    this.addGold(gSable);
    this.addGold(gBois);
  }

  /** harvest the cells to get ressource
    */
  public void harvest(){
    for(int i=0;i<this.deployedFarmers.size();i++){
      Ressource r = this.deployedFarmers.get(i).getCell().getRessource();
      this.addRessource(r, 1);
    }
  }

  /** looking if we lost a farmer if yes remove him and his super "player" from the cell
    *  @param lost a farmers who lost
    */
  public void lostFarmer(Farmer lost){
    boolean find = false;
    int i = 0;
    while(!find && i<this.deployedFarmers.size()){
      if(this.deployedFarmers.get(i).getCell().equals(lost.getCell())){
        this.deployedFarmers.get(i).getCell().removePlayer();
        this.deployedFarmers.get(i).getCell().removeFarmer();
        this.deployedFarmers.remove(i);
        find = true;
      }
      i += 1;
    }
  }

  /** add gold if the deployed farmers were in desert , plain or forest cell
    */
  public void doNothing(){
    for(int i=0;i<this.deployedFarmers.size();i++){
      if(this.deployedFarmers.get(i).getCell() instanceof DesertCell){
        this.addGold(2);
      }
      else if(this.deployedFarmers.get(i).getCell() instanceof PlainCell || this.deployedFarmers.get(i).getCell() instanceof ForestCell){
        this.addGold(1);
      }
    }
  }

  public String toString() {
    return super.name + ", " + this.deployedFarmers.size() + " fermiers, " + super.gold + " pièces d'or, joue";
  }
}
