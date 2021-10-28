/**
 * An example of main program for the Bike class.
 *
 * @author SALMI Badr_eddine && TARMELIT Lydia
 * @version V1.0 | 09/10/2020
 */
public class MainBike {
    /**
     * Main function
     * @param args Argument given by the user in the control terminal.
     */
    public static void main(String[] args){
        Bike bike1 = new Bike("b001",BikeModel.CLASSICAL);
        Bike bike2 = new Bike("b002",BikeModel.ELECTRIC);
        System.out.println(bike1.equals(bike2));
        System.out.println(bike1.toString());
    }

}
