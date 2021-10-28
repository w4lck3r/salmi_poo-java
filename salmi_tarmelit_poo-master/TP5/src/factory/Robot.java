
/**
 * @author SALMI badr eddine || TARMELIT lydia
 * @version v1.0 | 20/10/2020
 */
//Cette classe Robot appartient au paquetage factory :
package factory;

// il est necessaire d'importer toutes les classes contenus dans le dossier util du paquetage factory

import factory.util.Box;
import factory.util.ConveyerBelt ;

public class Robot {

    /** the box carried by robot  */
    private Box carriedBox;


    /**
     * creates a robot, no Box carried at creation
     */
    public Robot() {
        this.carriedBox = null;
    }


    /**
     * returns <code>true</code> iff this robot is carrying a box
     *
     * @return <code>true</code> iff this robot is carrying a box
     */
    public boolean carryBox() {
        return this.carriedBox != null;
    }

    /** returns the carried box
     * @return the carried box
     */
    public Box getCarriedBox() {
        return this.carriedBox;
    }

    // les methodes de la classe Robot
    /**
     * this robot takes a box if it was not already carrying one, else nothing happens
     * @param box the carried box
     */
    public void take(Box box) {
        if (!this.carryBox()) { // already carrying a box ?
            this.carriedBox = box;
        }
    }

    /**
     * this robot puts the carried box on the belt
     *
     * @param belt the belt on which box is put
     * @return true if box has been put on the belt and false if it
     * has not been possible : either no box was carried, or belt was
     * full or carried box was to heavy
     */

    public boolean putOn(ConveyerBelt belt) {
        if (this.carryBox() && belt.accept(carriedBox) && !belt.isFull()) {
            // put box on belt
            belt.receive(carriedBox);
            // no more box is carried
            this.carriedBox = null;
            return true;
        } else {
            // no box carried, or belt is full or box is to heavy for the belt
            return false;
        }
    }
    /** drop currently carried box, if any
     * @return the droped box, <code>null</code> if none
     */
    public Box drop() {
        Box droped = this.carriedBox;
        this.carriedBox = null;
        return droped;
    }


}
