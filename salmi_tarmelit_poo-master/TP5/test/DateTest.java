import org.junit.*;
import static org.junit.Assert.*;

import date.Date;
import date.util.Month;
/**
 * @author SALMI badr eddine || TARMELIT lydia
 * @version v1.0 | 20/10/2020
 */
public class DateTest{

  //For getters :
  @Test
  public void getDayOk(){
      Date date = new Date(1,Month.january,1970);
      assertEquals(date.getDay(),1);
  }

  @Test
  public void getMonthOk(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.getMonth(),Month.january);
  }

  @Test
  public void getYearOk(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.getYear(),1970);
  }

  //For nbDaysAfter method :
  @Test
  public void nbDaysAfterTestOk(){
    Date date = new Date(1,Month.january,1970);
    Date dateAfter = date.nbDaysAfter(10);
    assertEquals(dateAfter,new Date(11,Month.january,1970));
    assertEquals(date.nbDaysAfter(365),new Date(1,Month.january,1971));
    assertEquals(date.nbDaysAfter(31),new Date(1,Month.february,1970));
  }

  @Test(expected =java.lang.IllegalArgumentException.class)
  public void nbDaysAfterTestKo(){
    Date date = new Date(1,Month.january,1970);
    date.nbDaysAfter(-10);
  }

  //For nbDaysBetween method :
  @Test
  public void nbDaysBetweenSameYear(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.nbDaysBetween(new Date(31,Month.december,1970)),364);
  }

  @Test
  public void nbDaysBetweenDifferentYear(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.nbDaysBetween(new Date(29,Month.february,1972)),789);
  }

  //For tomorrow method :
  @Test
  public void tomorrowInTheSameMonth(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.tomorrow(),new Date(2,Month.january,1970));
  }

  @Test
  public void tomorrowBetweenDifferentMonth(){
    Date date = new Date(31,Month.january,1970);
    assertEquals(date.tomorrow(),new Date(1,Month.february,1970));
  }

  @Test
  public void tomorrowBetweenDifferentYear(){
    Date date = new Date(31,Month.december,1970);
    assertEquals(date.tomorrow(),new Date(1,Month.january,1971));
  }

  //For isLeapYear method :
  @Test
  public void isLeapYearOk(){
    assertTrue(Date.isLeapYear(2008));
  }

  @Test
  public void isLeapYearKo(){
    assertFalse(Date.isLeapYear(1900));
  }

  //For compareTo method :
  @Test
  public void compareToWithMainDateInThePast(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.compareTo(new Date(31,Month.december,1970)),-1);
  }

  @Test
  public void compareToWithSameDate(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.compareTo(date),0);
  }

  @Test
  public void compareToWithMainDateInTheFuture(){
    Date date = new Date(1,Month.january,1970);
    Date secondDate = new Date(31,Month.december,1970);
    assertEquals(secondDate.compareTo(date),1);
  }

  //For toString method :
  @Test
  public void toStringOk(){
    Date date = new Date(1,Month.january,1970);
    assertEquals(date.toString(),"1 january 1970");
  }

  //For equals method :
  @Test
  public void equalsOk(){
    Date date = new Date(1,Month.january,1970);
    assertTrue(date.equals(date));
  }

  @Test
  public void equalsKo(){
    Date date = new Date(1,Month.january,1970);
    assertFalse(date.equals(new Date(1,Month.february,1970)));
  }

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
      return new junit.framework.JUnit4TestAdapter(DateTest.class);
  }
}
