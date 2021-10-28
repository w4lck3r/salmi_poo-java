package game;
//import other methods from the project
import game.*;
/**
*army's class Constructor
*/
public class Army extends Caracter{
    //lenght of the army
    protected int length;
    protected int maxLength;

    public Army(Cell c,int length, Player p){
        super(c, p);
        this.veriflength();
        this.length = this.maxLength;
        if(length <= this.maxLength){
          this.length = length;
        }
    }

    /** give length value by the type of the cell
      */
    public void veriflength(){
      if(super.cell instanceof DesertCell || super.cell instanceof MontainCell){
        this.maxLength = 3;
      }
      else{
        this.maxLength = 5;
      }
    }

    /** return the maxLength
      *  @return a int
      */
    public int getMaxLength(){
        return this.maxLength;
    }

    /** setter of the length
      *  @param L the value of the length
      */
    public void setLength(int L){
      if(L <= this.maxLength){
        this.length = L;
      }
      else{
        this.length = this.maxLength;
      }
    }

    /** get length value
      *  @return length
      */
    public int getLength(){
      if(super.cell instanceof MontainCell){
        return this.length+2;
      }
      else{
        return this.length;
      }
    }

    /** increase length value by 1
      */
    public void incrementLength(){
        if(this.length < this.maxLength){
            this.length = this.length + 1;
        }
    }
}
