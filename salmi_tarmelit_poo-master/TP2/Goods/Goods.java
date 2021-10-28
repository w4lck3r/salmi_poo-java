
/**
 * Décrivez votre classe Goods ici.
 *
 * @author (SALMI Badreddine)
 * @version (27/09/2020)
 */
public class Goods
{
     // instance variables
  /** Value of the merchandise
    * Name of the furniture
    * The merchandise taxe
    */ 
   private double value ;
   private String name ;
   private static double TTC = 0.2 ;
    /**
    * Create a merchandise without value
    * @param name the name of the furniture
    */
     //Q3.1: Le type du paramètre name est: objet String (chaine de caractère).

   public Goods(String name){
    this.name = name;
    }

     /**
    * Create a merchandise with is value
    * @param name the name of the furniture
    * @param value the furniture's value
    */
     //Q3.2: Le type du paramètre name est un objet String, pour value c'est un double.

   public Goods(String name , double value){
    this.name = name ;
    this.value = value ;
    }

     /**
    * Give the furniture's value
    * @param None
    * @return the value of the furniture.
    */

   public double getValue(){
       return this.value ;
    }

   public void setValue(double Val){
       this.value = Val ;
    }

     /**
    * Give the furniture's name
    * @param None
    * @return The name of the furniture.
    */

   public String getName(){
       return this.name;
    }

    /**
    * Change the furniture's name
    * @param new_name The new name
    * @return None
    */

   public void setName(String n_name){
       this.name = n_name;
    }

     /**
    * Tell goods'name and is cost without all taxes
    * @return the name and the cost 
    */

   public String toString()
   {  
       return "The goods "+this.name+" costs "+this.value;
   }
   
   public double TTC_Value(){
       return this.value+(this.value*this.TTC) ;
    }
}
