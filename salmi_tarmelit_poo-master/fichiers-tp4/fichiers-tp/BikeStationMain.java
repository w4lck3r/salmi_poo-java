/**
 * A class for user that simulate bikes stations.
 *
 * @author SALMI Badr-eddine && TARMELIT Lydia
 * @version V1.0 | 09/01/2020
 */
public class BikeStationMain {
    /**
     * Main function to interact with a bike station by a control terminal.
     * @param args Arguments given by the user in the control terminal.
     * @exception NumberFormatException Only integer are authorized otherwise that exception is triggered.
     */
    public static void main(String []args){
        BikeStation Station1 =new BikeStation("Timoleon",10);
        Bike bike1 = new Bike("b001",BikeModel.CLASSICAL);
        Bike bike2 = new Bike("b002",BikeModel.ELECTRIC);
        Station1.dropBike(bike1);
        Station1.dropBike(bike2);
        if (args.length > 0) {
            //Try to convert the argument to an integer because the bike places are represented by int.
            try{
                int position=Integer.parseInt(args[0]);
                Bike takenBike=Station1.takeBike(position);
                //Custom information for the user :
                if (position<0){
                    System.out.println("Les positions commencent a 0, "+position+"n'est pas une position valide.");
                }
                else if(takenBike==null){
                    System.out.println("Desole, il n'y a pas de velo à l'emplacement "+position);
                }
                else{
                    System.out.println("Vous avez pris le velo : "+takenBike.getId()+"\n de type : "+takenBike.getModel());
                }
            }
            //If we can't get an integer, we need to catch the exception.(float, long int ... are prohibited we only need an int)
            catch(NumberFormatException e){
                System.out.println("L'argument saisi doit etre un nombre entier < 2147483648.\nPar exemple executez : java BikeStationMain 0");
            }
        }
        if (args.length <= 0) {
            System.out.println("Veuillez passer en argument l'emplacement du velo souhaite.\nPar exemple : java BikeStationMain 0");
        }
    }
}
