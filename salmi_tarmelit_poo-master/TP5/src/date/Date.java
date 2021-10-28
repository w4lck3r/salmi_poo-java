package date;
import date.util.Month;
/**
 * A class to create and manage dates.
 * @author SALMI badr eddine || TARMELIT lydia
 * @version v1.0 | 20/10/2020
 */
public class Date{
  //Instance variables :
  /*The digital day of the date.*/
  int day;
  /** The month of the date.
    * @see date.util.Month
    */
  Month month;
  /*The digital year of the date.*/
  int year;

  /**
    * Constructor for Date.
    * @param day The day of the date.
    * @param month The month of the date.
    * @param year The year of the date.
    */
  public Date(int day,Month month,int year){
    this.day=day;
    this.month=month;
    this.year=year;
  }

  /**
    * Gives the day of the date.
    * @return The date day.
    */
  public int getDay(){
    return this.day;
  }

  /**
    * Gives the month of the date.
    * @return The date month.
    */
  public Month getMonth(){
    return this.month;
  }

  /**
    * Gives the year of the date.
    * @return The date year.
    */
  public int getYear(){
    return this.year;
  }

  /**
    * Gives the date of tomorrow.
    * @return The next day.
    */
  public Date tomorrow(){
    if(this.getDay()==this.getMonth().getNbDay(this.getYear())){
      if(this.getMonth()==Month.december)
        return new Date(1,Month.january,this.getYear()+1);
      else
        return new Date(1,this.getMonth().next(),this.getYear());
    }
    else
      return new Date(this.getDay()+1,this.getMonth(),this.getYear());
  }

  /**
    * Gives the date that it will be a number of days later.
    * @param nbDays The number of days between the 2 dates
    * @return The date n day later.
    */
  public Date nbDaysAfter(int nbDays){
    if (nbDays<0)
      throw new IllegalArgumentException("Bad number of days : must be a positive integer");
    else{
      Date res=this;
      for(int i=0;i<nbDays;i++)
        res=res.tomorrow();
      return res;
    }
  }

  /**
    * Gives the number of days between 2 dates in the same year.
    * @param other The target date.
    * @return The number of days between the 2 dates.
    */
  private int nbDaysBetweenSameYear(Date other){
    int nbDaysInSameYear=0;
    Month tmpMonth=other.getMonth();
    while(tmpMonth!=this.getMonth()){
      nbDaysInSameYear=nbDaysInSameYear+tmpMonth.getNbDay(this.getYear());
      tmpMonth=tmpMonth.next();
    }
    nbDaysInSameYear=nbDaysInSameYear+this.getDay()-other.getDay();
    return nbDaysInSameYear;
  }

  /**
    * Gives the number of days between 2 dates in different years.
    * @param other The target date.
    * @return The number of days between the 2 dates.
    */
  private int nbDaysBetweenDifferentYear(Date other){
    int nbDaysInDifferentYear=this.nbDaysBetweenSameYear(other);
    int tmpYear=other.getYear();
    while(tmpYear!=this.getYear()){
      if(Date.isLeapYear(tmpYear))
        nbDaysInDifferentYear=nbDaysInDifferentYear+366;
      else
        nbDaysInDifferentYear=nbDaysInDifferentYear+365;
      tmpYear=tmpYear+1;
    }
    return nbDaysInDifferentYear;
  }

  /**
    * Compare 2 dates.
    * @param otherDate The date to compare.
    * @return (0 if date are the same day,-1 if the other date is in the future otherwise 1 if the other date is in the past)
    */
  public int compareTo(Date otherDate){
    if ((this.getDay()==otherDate.getDay()) && (this.getMonth()==otherDate.getMonth()) && (this.getYear()==otherDate.getYear()))
      return 0;
    else if ((this.getDay()<otherDate.getDay()) || (this.getMonth().getMonthNumber()<otherDate.getMonth().getMonthNumber()) || (this.getYear()<otherDate.getYear()))
      return -1;
    else
      return 1;
  }

  /**
    * Gives the number of days between 2 dates.
    * @param otherDate The target date.
    * @return Number of days between the 2 dates.
    */
  public int nbDaysBetween(Date otherDate){
    if(this.compareTo(otherDate)==-1)
      return otherDate.nbDaysBetween(this);
    if(this.getYear()==otherDate.getYear())
      return this.nbDaysBetweenSameYear(otherDate);
    else
      return this.nbDaysBetweenDifferentYear(otherDate);
  }

  /**
    * Returns if a year is a leap year.
    * @param year The year we want to know if it's a leap year.
    * @return <code>true</code> if the year is a leap year otherwise <code>false</code>.
    */
  public static boolean isLeapYear(int year){
    if ((year%4==0 && year%100!=0)||year%400==0)
      return true;
    else
      return false;
  }

  /**
    * Gives the date in string form.
    * @return The string description of the date.
    */
  public String toString(){
    return this.getDay()+" "+this.getMonth()+" "+this.getYear();
  }

  /**
    * Two dates are equals if they are the same date.
    * @param other The object to test the equality with date.
    * @return <code>true</code> if other is the same date than this date, otherwise <code>false</code>.
    */
  public boolean equals(Object other){
    if(other instanceof Date){
      Date otherDate = (Date) other;
      return this.compareTo(otherDate)==0;
    }
    else
      return false;
  }

}
