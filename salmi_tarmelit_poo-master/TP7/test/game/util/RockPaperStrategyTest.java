package shifumi.util;
import org.junit.*;
import static org.junit.Assert.*;
import shifumi.Shape;
import shifumi.util.Strategy;
import shifumi.util.RockPaperStrategy;

public class RockPaperStrategyTest{

  @Test
  public void workingTest(){
    Strategy RPStrat = new RockPaperStrategy();
    Shape hand = RPStrat.getShape();
    assertSame(hand,Shape.ROCK);
    hand = RPStrat.getShape();
    assertSame(hand,Shape.PAPER);
    hand = RPStrat.getShape();
    assertSame(hand,Shape.ROCK);
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(RockPaperStrategyTest.class);
  }

}
