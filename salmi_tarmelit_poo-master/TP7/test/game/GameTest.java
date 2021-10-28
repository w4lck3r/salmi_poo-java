package game;
import org.junit.*;
import static org.junit.Assert.*;
import shifumi.*;
import shifumi.util.*;

public class GameTest{

  @Test
  public void goodNumberOfRoundsTest(){
    Game goodGame = new Game(new Player("Katia",new RockPaperStrategy()),new Player("Alexandre",new PaperStrategy()),3);
  }

  @Test(expected =java.lang.IllegalArgumentException.class)
  public void badNumberOfRoundsTest(){
    Game badRoundsGame = new Game(new Player("Katia",new RockPaperStrategy()),new Player("Alexandre",new PaperStrategy()),0);
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(GameTest.class);
  }
}
