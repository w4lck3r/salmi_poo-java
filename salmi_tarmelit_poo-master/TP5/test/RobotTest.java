/**
 * @author SALMI badr eddine || TARMELIT lydia
 * @version v1.0 | 20/10/2020
 */
import org.junit.*;
import static org.junit.Assert.*;

import factory.Robot;   
import factory.util.*;   

public class RobotTest {


    @Test
    public void TakeIsOkWhenRobotDoesntCarryABox(){
        Robot robbie = new Robot();
        Box box = new Box(2);
        robbie.take(box);
        assertTrue(robbie.carryBox());
    }



    @Test
    public void CarryBoxIsOkWhenRobotDoesntCarryABox(){
        Robot robbie = new Robot();
        assertFalse(robbie.carryBox());
    }

    @Test
    public void CarryBoxIsOkWhenRobotCarriesABox(){
        Robot robbie = new Robot();
        Box box = new Box(2);
        robbie.take(box);
        assertTrue(robbie.carryBox());
    }

    @Test
    public void DoesntCarryABoxWhenRobotHaveBeenPutItOn(){
        Robot robbie = new Robot();
        Box box = new Box(2);
        ConveyerBelt c = new ConveyerBelt(3);
        robbie.take(box);
        robbie.putOn(c);
        assertFalse(robbie.carryBox());
    }

    @Test
    public void RobotCarriesTheSameBoxWhenTheConveyerBeltHasAlreadyABox(){
        Robot robbie = new Robot();
        Box b1 = new Box(2);
        Box b2 = new Box(2);
        Box b3 = new Box(2);
        ConveyerBelt c = new ConveyerBelt(7);
        robbie.take(b1);
        robbie.putOn(c);
        robbie.take(b2);
        robbie.putOn(c);
        robbie.take(b3);
        robbie.putOn(c);
        Box b4 = robbie.drop();
        assertEquals(b3,b4);
    }



    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(RobotTest.class);
    }

}
