/**
 * a small class for some manipulations of a complexe number
 *  tasks : -get the conjugate , module , real part , imaginary part
 *          -know is the number is real
 *          -the sum of two complexe numbers
 *          -the multiply of two complexe numbers
 *
 *
 * @author SALMI badr-eddine
 * @version 1.0
 */

package com.company;

public class Complexe {
        /*
    //instance variables of the object
    */
    private double real;
    private double imaginary;
    /*
 //Constructor of the Rectangle Class
 */
    public Complexe(double re , double im){
        this.imaginary = im ;
        this.real = re ;
    }
/*
    //test methode if the number is real
    // return boolean
 */

    public boolean isReal(){
        if(this.imaginary==0){return true ; }
        return false;
    }
/*
    // get the real part of the number
    // @ real
**/
    public double realPart(){
        return this.real;
    }
/*
    // get the imaginary part of the number
    // @ imaginary
* */
    public double imaginaryPart(){
        return this.imaginary;
    }
/*
    //methode to get the conjugate "A new object is created here"
    @conjugate
* */
    public Complexe conjugate(){
            return new Complexe(this.real , -this.imaginary) ;
    }
    /*
        //methode to get the module of a complexe number
        @module
    * */
    public double module(){
        return Math.sqrt(Math.pow(this.real,2)+Math.pow(this.imaginary,2));
    }
    /*
        //methode to calculat the some of two numbers
        @c1+c2
    * */
    public Complexe add(Complexe other){
        return new Complexe(this.real+ other.real,this.imaginary+ other.imaginary);
    }
    /*
        //methode to calculat the multiply of two numbers
        @c1*c2
    * */
    public Complexe multi(Complexe other){
        return new Complexe(((this.real* other.real)-(this.imaginary*other.imaginary)),((this.imaginary*other.real)+(this.real* other.imaginary))) ;
                //(a+ib) * (z+iy) = a*z -by +i(b*z + a*y)
    }
    /*
    //The famouse method to test the equality between two object
    // in our exercice we gonna see if the other is actually a Complexe number or no
    /@ture or false
    */
    public boolean isEqual(Object other){
        if(other instanceof Complexe){
            Complexe c = (Complexe) other ;
            if(c.real==this.real && c.imaginary==this.imaginary){
                return true ;
            }
            return false;
        }
        return false ;
    }
    /*
    //Another famouse methode to get a results
    /@string
    */
    public String toString(){
        return +this.real+" + i ("+this.imaginary+")" ;
    }
    public static void main(String[] args){
        Complexe c1 = new Complexe(1,2);
        Complexe c2 = new Complexe(3,1);
        c1.toString();
        c2.toString();
        System.out.println("le conjugué de c1 = "+c1.conjugate());
        System.out.println("le conjugué de c2 = "+c2.conjugate());
        System.out.println("|c1| = "+c1.module());
        System.out.println("|c2| = "+c2.module());
        System.out.println("c1 + c2 = "+c1.add(c2));
        System.out.println("c1 * c2 = "+c1.multi(c2));
        if(c1.add(c2).isEqual(c1.multi(c2))){
            System.out.println("egalite des complexes somme et produit obtenus");
        }
        else{
            System.out.println("la somme est le produit sont différent");
        }

    }
}
