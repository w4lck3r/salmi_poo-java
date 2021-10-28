package date;
import date.Date;
import date.util.Month;
/**
  * A main program to show an example of application of date package.
  * @author SALMI badr eddine || TARMELIT lydia
  * @version v1.0 | 20/10/2020
  */
public class DateMain{

  public static void main(String[] args){
    System.out.println("Welcome for the main program of date package :\nWe will show examples of uses of this package :\n");
    Date date = new Date(1,Month.january,2019);
    Date secondDate = new Date(31,Month.december,2019);
    Date lastDate =new Date(14,Month.february,2020);

    //Specifically for Date
    System.out.println("The first date is : "+date.toString());
    System.out.println("The tomorrow of the first date is : "+date.tomorrow().toString());
    System.out.println("31 days after the first date we will be the : "+date.nbDaysAfter(31).toString());
    System.out.println("The year 2019 is a leap year ? : "+Date.isLeapYear(2019));
    System.out.println("365 days after the first date we will be the : "+date.nbDaysAfter(365).toString());
    System.out.println("The second date is :"+lastDate.toString());
    System.out.println("The last date is :"+secondDate.toString());
    System.out.println("The date : "+date.toString()+" equals "+lastDate.toString()+" ? : "+date.equals(lastDate));
    System.out.println("The date : "+date.toString()+" equals "+date.toString()+" ? : "+date.equals(date));
    System.out.println("The comparison of the date : "+date.toString()+" and the date "+lastDate.toString()+" gives "+date.compareTo(lastDate)+".");
    System.out.println("The comparison of the date : "+date.toString()+" and the date "+date.toString()+" gives "+date.compareTo(date)+".");
    System.out.println("The comparison of the date : "+secondDate.toString()+" and the date "+date.toString()+" gives "+secondDate.compareTo(date)+".");
    System.out.println("The number of days between the "+secondDate.toString()+" and the date "+date.toString()+" is "+secondDate.nbDaysBetween(date)+".");
    System.out.println("The number of days between the "+date.toString()+" and the date "+secondDate.toString()+" is "+date.nbDaysBetween(secondDate)+".");
    System.out.println("The number of days between the "+date.toString()+" and the date "+lastDate.toString()+" is "+date.nbDaysBetween(lastDate)+".");

    //Specifically for Month
    System.out.println("\nThe month of the first date is the : "+date.getMonth().getMonthNumber()+"th month of the year.");
    System.out.println("The month of the last date is the : "+secondDate.getMonth().getMonthNumber()+"th month of the year.");
    System.out.println("For the date : "+lastDate.toString()+" , the month had : "+lastDate.getMonth().getNbDay(lastDate.getYear())+" days.");
    System.out.println("For the date: "+secondDate.toString()+" , the next month is : "+secondDate.getMonth().next());

    System.out.println("\nIf you give a negative number of days later you will obtain the error :");
    try{
      date.nbDaysAfter(-31).toString();
    }
    //If we can't get an integer, we need to catch the exception.(float, long int ... are prohibited we only need an int)
    catch(IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
  }
}
