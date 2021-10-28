package shifumi.util;
import org.junit.*;
import static org.junit.Assert.*;
import shifumi.Shape;
import shifumi.util.Strategy;
import shifumi.util.RandomStrategy;

public class RandomStrategyTest{

  @Test
  public void workingTest(){
    Strategy randomStrat = new RandomStrategy();
    Shape hand = randomStrat.getShape();
    assertTrue(Shape.contains(hand.toString()));
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(RandomStrategyTest.class);
  }

}
