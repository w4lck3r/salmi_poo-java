package shifumi.util;
import org.junit.*;
import static org.junit.Assert.*;
import shifumi.Shape;
import shifumi.util.Strategy;
import shifumi.util.PaperStrategy;

public class PaperStrategyTest{

  @Test
  public void workingTest(){
    Strategy PaperStrat = new PaperStrategy();
    Shape hand = PaperStrat.getShape();
    assertSame(hand,Shape.PAPER);
    hand = PaperStrat.getShape();
    assertSame(hand,Shape.PAPER);
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(PaperStrategyTest.class);
  }

}
