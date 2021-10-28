package shifumi;
import org.junit.*;
import static org.junit.Assert.*;
import shifumi.Player;
import shifumi.util.*;

public class PlayerTest{
  private Player p1 ;
  private Player p2;

  @Before
  public void before(){
    this.p1 = new Player("badr",new PaperStrategy());
    this.p2 = new Player("lydia",new RockPaperStrategy());
  }

  @Test
  public void initAndGettersTest(){
    assertSame(p1.getName(),"badr");
    assertEquals(p1.getPoints(),0);
    assertSame(p1.getShape(),null);
  }


  @Test
  public void addPointsTestOk(){
    assertEquals(0,p1.getPoints());
    p1.addPoints(1);
    assertEquals(1 ,p1.getPoints());
    p1.addPoints(2);
    assertEquals(3,p1.getPoints());
  }

  @Test(expected =java.lang.IllegalArgumentException.class)
  public void addPointsTestKo(){
    assertEquals(0,p2.getPoints());
    p1.addPoints(-1);
  }

  @Test
  public void playTest(){
    p1.play();
    assertSame(p1.getShape(),Shape.PAPER);
    assertSame(p1.play(),Shape.PAPER);
    assertSame(p2.play(),Shape.ROCK);
    assertSame(p2.play(),Shape.PAPER);
    assertSame(p2.play(),Shape.ROCK);
  }

  @Test
  public void toStringOk(){
    assertEquals(p1.toString(),"badr has not played yet.");
    p1.play();
    assertEquals(p1.toString(),"badr played PAPER");
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
  }

}
