/**
 * a small class for some manipulations of a rectangle
 *  tasks : -get the length and the width
 *          -calculat the area
 *          -calculat the perimer
 *          -know if the rect is a box
 *
 * @author SALMI badr-eddine
 * @version 1.0
 */


package com.company;

public class Rectangle {
    /*
    //instance variables of the object
    */
    private double lar , lon ;
    /*
 //Constructor of the Rectangle Class
 */
    public Rectangle(double l , double L){
        this.lar = l ;
        this.lon = L ;
    }
    /*
    //Methode to get the width
    /@width
    */
    public double getLar() {
        return this.lar;
    }
    /*
    //Methode to get the length
    /@length
    */
    public double getLon() {
        return this.lon;
    }
    /*
    //Methode to calculat area
    /@area
    */
    public double area(){
        return this.lon*this.lar*2;
    }
    /*
    //Methode to calculat perimeter
    /@perimeter
    */
    public double perimeter(){
        return (this.lar+this.lon)*2;
    }
    /*
    //Methode to know if the rec is a box
    /@ture or false
    */
    public boolean isBox(){
        if(this.lon==this.lar){
            return true ;
        }
            return false;
    }
    /*
    //The famouse method to test the equality between two object
    // in our exercice we gonna see if the other is actually a rect or no
    /@ture or false
    */
    public boolean isEqual(Object other){
        if(other instanceof Rectangle){
            Rectangle rectangle = (Rectangle) other;
            if(this.lon==((Rectangle) other).lon && this.lar==((Rectangle) other).lar){
                return true ;
            }
            return false ;
        }
        return false;
    }
    /*
    //Another famouse methode to get a results
    /@string
    */
    public String toString(){
        return "lar = "+this.lar+" long = "+this.lon;
    }
    public static void main(String[] args){
        Rectangle box = new Rectangle(2,2);
        Rectangle notBox = new Rectangle(3 , 4);
        box.toString();
        System.out.println("le rectangle a un largeur = "+box.getLar()+" et un longueur = "+box.getLon());
        System.out.println("le rectangle a un aire de : "+box.area());
        System.out.println("le rectangle a un perimetre de : "+box.perimeter());
        if(box.isBox()){
            System.out.println("le rectangle est un carré");
        }
        else{
            System.out.println("le rectangle n'est pas un carré");
        }
        if(box.isEqual(notBox)){
            System.out.println("le premiére rectangle est le deuxiéme sont égaux");
        }
        else{
            System.out.println("les deux rectangles sont différent ");
        }
    }
}

