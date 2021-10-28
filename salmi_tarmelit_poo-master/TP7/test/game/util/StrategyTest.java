package shifumi.util;
import org.junit.*;
import static org.junit.Assert.*;
import shifumi.Shape;
import shifumi.util.*;

public class StrategyTest{

  @Test
  public void workingTest(){
    Strategy RPStrat = new RockPaperStrategy();
    Strategy randomStrat = new RandomStrategy();
    Strategy PaperStrat = new PaperStrategy();
    Shape hand = RPStrat.getShape();
    assertSame(hand,Shape.ROCK);
    hand = PaperStrat.getShape();
    assertSame(hand,Shape.PAPER);
    hand = randomStrat.getShape();
    assertTrue(Shape.contains(hand.toString()));
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(StrategyTest.class);
  }

}
