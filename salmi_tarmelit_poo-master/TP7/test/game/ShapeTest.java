package shifumi;
import org.junit.*;
import static org.junit.Assert.*;
import shifumi.Shape;

public class ShapeTest{

  private Shape paper;
  private Shape rock;
  private Shape scissors;

  @Before
  public void before(){
    this.paper=Shape.PAPER;
    this.rock=Shape.ROCK;
    this.scissors=Shape.SCISSORS;
  }

  @Test
  public void compareShapesTest(){
    assertEquals(paper.compareShape(Shape.PAPER),0);
    assertEquals(rock.compareShape(Shape.ROCK),0);
    assertEquals(scissors.compareShape(Shape.SCISSORS),0);
    assertEquals(paper.compareShape(Shape.ROCK),1);
    assertEquals(paper.compareShape(Shape.SCISSORS),-1);
    assertEquals(rock.compareShape(Shape.SCISSORS),1);
    assertEquals(rock.compareShape(Shape.PAPER),-1);
    assertEquals(scissors.compareShape(Shape.ROCK),-1);
    assertEquals(scissors.compareShape(Shape.PAPER),1);
  }

  @Test
  public void containsShapeByGivenStringTest(){
    assertFalse(Shape.contains("rock1"));
    assertFalse(Shape.contains("Timoléon."));
    assertTrue(Shape.contains("ROCK"));
    assertTrue(Shape.contains("PAPER"));
    assertTrue(Shape.contains("SCISSORS"));
    assertFalse(Shape.contains("rock"));
    assertFalse(Shape.contains("paper"));
    assertFalse(Shape.contains("scissors"));
  }

  @Test
  public void randomShapeTest(){
    Shape tirage = Shape.randomShape();
    assertTrue(Shape.contains(tirage.toString()));
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(ShapeTest.class);
  }
}
