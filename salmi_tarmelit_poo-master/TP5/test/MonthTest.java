import org.junit.*;
import static org.junit.Assert.*;

import date.Date;
import date.util.Month;
/**
 * @author SALMI badr eddine || TARMELIT lydia
 * @version v1.0 | 20/10/2020
 */
public class MonthTest{

  //For getMonthNumber method :
  @Test
  public void getMonthNumberOk(){
    assertEquals(Month.january.getMonthNumber(),1);
  }

  //For next method :
  @Test
  public void nextOk(){
    assertEquals(Month.january.next(),Month.february);
    assertEquals(Month.december.next(),Month.january);
  }

  //For getNbDay method :
  @Test
  public void getNbDayOk(){
    assertEquals(Month.january.getNbDay(2008),31);
    assertEquals(Month.february.getNbDay(2008),29);
    assertEquals(Month.february.getNbDay(2019),28);
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(MonthTest.class);
  }
}
