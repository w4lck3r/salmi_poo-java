package game;

import game.*;
import java.util.*;

public class Board{
    private static int nbCells;
    private Cell[][] theCells;
    private int earthCell;

    /** create a board by the number of the cells
      *  @param nbCells the number of cell
      */
    public Board(int nbCells){
        this.nbCells = nbCells;
        this.theCells = new Cell[nbCells][nbCells];
        for(int i=0; i<nbCells; i++){
            for(int j=0; j<nbCells; j++){
              this.theCells[i][j] = new OceanCell(i,j);
            }
        }
        this.earthCell = (nbCells*nbCells)/3;
    }

    /** return the number of cells
      *  @return the number of cells
      */
    public int getNbCells(){
      return this.nbCells;
    }

    /** return a cell
      *  @param i the position x of a cell
      *  @param j the position y of a cell
      *  @return the cell with the position x and y in the param
      */
    public Cell getCell(int i, int j){
      return this.theCells[i][j];
    }

    /** return a earthCell
      *  @return the number of earthCell
      */
    public int getEarthCell(){
      return this.earthCell;
    }

    /** set a random type to the cell with position i and j
      *  @param i the position x of a cell
      *  @param j the position y of a cell
      */
    public void randomCell(int i, int j){
      int type = (int)(Math.random()*4);
      if(type == 0){
        this.theCells[i][j] = new MontainCell(i,j);
      }
      else if(type == 1){
        this.theCells[i][j] = new ForestCell(i,j);
      }
      else if(type == 2){
        this.theCells[i][j] = new PlainCell(i,j);
      }
      else {
        this.theCells[i][j] = new DesertCell(i,j);
      }
      this.earthCellLess();
    }

    /** check the cells around the cell with position i and j
      *  @param i the position x of a cell
      *  @param j the position y of a cell
      *  @return true if there are a earth cell around the cell, false if not
      */
    public boolean checkCellAround(int i, int j){
      boolean result = false;
      if(i != 0 && !(this.theCells[i-1][j] instanceof OceanCell)){
        result = true;
      }
      else if(j != 0 && !(this.theCells[i][j-1] instanceof OceanCell)){
        result = true;
      }
      else if(i < this.nbCells-1 && !(this.theCells[i+1][j] instanceof OceanCell)){
        result = true;
      }
      else if(j < this.nbCells-1 && !(this.theCells[i][j+1] instanceof OceanCell)){
        result = true;
      }
      return result;
    }

    /** decrease the number of earth cells
      */
    public void earthCellLess(){
      if(this.earthCell>0){
        this.earthCell = this.earthCell-1;
      }
    }

    /** initialize the board
      */
    public void initBoard(){
      while(this.earthCell>0){
        int i = (int)(Math.random()*this.nbCells);
        int j = (int)(Math.random()*this.nbCells);
        if(this.theCells[i][j] instanceof OceanCell){
          this.randomCell(i,j);
          if(!(checkCellAround(i,j)) && this.earthCell>0){
            if(i != 0){
              this.randomCell(i-1,j);
            }
            else{
              this.randomCell(i+1,j);
            }
          }
        }
      }
    }

    /** tostring method show the type of the cells
      */
    public String toString() {
      String res = "";
      for(int i=0; i<nbCells; i++){
          for(int j=0; j<nbCells; j++){
            res += this.getCell(i, j).type();
          }
          res += "\n";
      }
      return res;
    }
}
