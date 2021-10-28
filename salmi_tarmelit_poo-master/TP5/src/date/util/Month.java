package date.util;
import date.Date;
/**
 * An enumerate class to create and manage month.
 * @author SALMI badr eddine || TARMELIT lydia
 * @version v1.0 | 20/10/2020
 */
public enum Month{
  january(31),
  february(29),
  march(31),
  april(30),
  may(31),
  june(30),
  july(31),
  august(31),
  september(30),
  october(31),
  november(30),
  december(31);

  //Instance variables :
  /*Number of day in the month*/
  private final int nbDays;

  /**
    * Constructor for Month.
    * @param nbDays The number of days in the month.
    */
  private Month(int nbDays){
    this.nbDays=nbDays;
  }

  /**
    * Gives the number of the month.
    * @return A number between 1 and 12.
    */
  public int getMonthNumber(){
    return this.ordinal()+1;
  }

  /**
    * Give the number of day in the month.
    * @param year The year in link with the month to know if it's a leap year.
    * @return The number of days in the month.
    */
  public int getNbDay(int year){
    if (this==Month.february){
      if(Date.isLeapYear(year)){
        return this.nbDays;
      }
      else{
        return this.nbDays-1;
      }
    }
    else
      return this.nbDays;
  }

  /**
    * Gives the next month.
    * @return The next month.
    */
  public Month next(){
    return Month.values()[this.getMonthNumber()%12];
  }

}
