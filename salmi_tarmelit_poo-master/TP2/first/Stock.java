
/**
 * A class to manupilate an object it could add , remove and show the results of a quantity  .
 *
 * @author (SALMI Badr-eddine)
 * @version (27/09/2020)
 */
public class Stock
{
    // Attribut of the Stock's Class
    private int quantity ;
    
    //creat an object  
    public Stock(){
        this.quantity = 0 ; //let the quantity be 0
    }
	//method to get the quantity value 

    public int getQuantity(){
        return this.quantity ;
    }

	//method to increase quantity
        /**
        * @param  n (quantity number)
        */

    public void add(int n){
        this.quantity +=  n ;
    }

        //Methode decreas quantity
        /**
        * @param  n (quantity numbre)
        */

    public int remove(int n){
        if(n <= this.quantity){
        this.quantity -= n ;
        return n;
        }  
        else{
        int rest = this.quantity ;     
        this.quantity = 0 ;
        return rest;
        }    
    }


       public String toString()
   {
       return "The stock's quantity is "+this.getQuantity();
   }


}
