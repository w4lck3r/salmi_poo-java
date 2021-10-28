package rental;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import rental.vehicle.Vehicle;
/**
  * A test class for the class SuspiciousRentalAgency in the package rental.
  * @author TARMELLIT Lydia | SALMI badr-eddine

  */
public class SuspiciousRentalAgencyTest {

	//Instance variables :
	/*A suspicious rental agency*/
	private SuspiciousRentalAgency agency;
	/*First client of the agency*/
	private Client client1;
	/*Client client2 corresponds to same client than client1 since names are equals*/
	private Client client2;
	/*An other client of the agency, he was young people*/
	private Client client3;
	/*Client client4 corresponds to same client than client3 since names are equals*/
	private Client client4;
	/*A Vehicle for agency*/
	private Vehicle v;
	/*A second Vehicle for agency*/
	private Vehicle v2;
	/*A map to check the good work of the SuspiciousRentalAgency database*/
	private Map<Client,Vehicle> rentedVehicles;
	/*A list to check the good work of the SuspiciousRentalAgency's Vehicle panel available*/
	private	List<Vehicle> availableVehicle;
	/*Filter to test adding and selecting one vehicle into the rental agency*/
	private BrandFilter filter;

	//Executed before each test :
	@Before
	public void before() {
		this.agency = new SuspiciousRentalAgency();
		this.client1 = new Client("Tim Oleon", 25);
		this.client2 = new Client("Tim Oleon", 25);
		this.client3 = new Client("Jeune Conducteur", 18);
		this.client4 = new Client("Jeune Conducteur", 18);
		this.v= new Vehicle("Vroum", "Vroum", 2000, 100);
		this.v2= new Vehicle("Peugeot", "208 T16", 2018, 300);
		this.rentedVehicles  = new HashMap<Client,Vehicle>();
		this.availableVehicle= new ArrayList<Vehicle>();
		this.filter= new BrandFilter("Peugeot");
	}

	//Test for check if 2 client with the same name corresponds to the same client :
	@Test
	public void twoClientObjectsWithSameNameCorrespondsToSameClient() throws IllegalStateException, UnknownVehicleException {
		this.agency.addVehicle(v);
		assertEquals(100,this.agency.rentVehicle(client1, v),0.0001);
		assertTrue(this.agency.hasRentedAVehicle(client1));
		assertTrue(this.agency.hasRentedAVehicle(client2));
	}

	//Test for adding and selecting a Vehicle into the SuspiciousRentalAgency :
	@Test
	public void addAndSelectVehicleTest(){
		//At start both List are empty list
		assertTrue(this.agency.select(this.filter).equals(this.availableVehicle));
		this.agency.addVehicle(this.v2);
		assertFalse(this.agency.select(this.filter).equals(this.availableVehicle));
		this.availableVehicle.add(this.v2);
		//At end both List are composed by same vehicles
		assertTrue(this.agency.select(this.filter).equals(this.availableVehicle));
	}

	//Test to check the return of a vehicle after a rent :
	@Test
	public void returnAfterRentTest()throws IllegalStateException, UnknownVehicleException{
		assertFalse(this.agency.hasRentedAVehicle(this.client1));
		this.agency.returnVehicle(this.client1);
		assertFalse(this.agency.hasRentedAVehicle(this.client1));
		this.agency.addVehicle(this.v2);
		this.agency.rentVehicle(this.client3,this.v2);
		assertTrue(this.agency.hasRentedAVehicle(this.client3));
		assertTrue(this.agency.isRented(this.v2));
		this.agency.returnVehicle(this.client3);
		assertFalse(this.agency.hasRentedAVehicle(this.client3));
		assertFalse(this.agency.isRented(this.v2));
	}

	//Test if this suspicious rental agency is more expensive for people under 25 years :
	@Test
	public void moreExpensiveAgencyForBeginnerTest()throws IllegalStateException, UnknownVehicleException{
		this.agency.addVehicle(v);
		this.agency.addVehicle(v2);
		assertEquals(100,this.agency.rentVehicle(client1, v),0.0001);
		this.agency.returnVehicle(this.client1);
		assertEquals(300,this.agency.rentVehicle(client1, v2),0.0001);
		this.agency.returnVehicle(this.client1);
		assertEquals(110,this.agency.rentVehicle(client3, v),0.0001);
		this.agency.returnVehicle(this.client3);
		assertEquals(330,this.agency.rentVehicle(client3, v2),0.0001);
	}

	//Test for a problem-free rental and for allRentedVehicles method:
	@Test
	public void getAllRentedVehiclesTest() throws IllegalStateException, UnknownVehicleException {
		/*
		RentalAgency#allRentedVehicles returns a Collection<Vehicle> then to compare if 2 Collection are equal,
		we can compare if Collection 1 is in Collection 2 and conversely.
		(In this test equals method doesn't work because both used Collection have differents hashCode)
		*/
		//At start both Collection are empty
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		this.agency.addVehicle(this.v);
		this.agency.addVehicle(this.v2);
		assertEquals(110,this.agency.rentVehicle(this.client3,this.v),0.0001);
		assertEquals(300,this.agency.rentVehicle(this.client1,this.v2),0.0001);
		//Here the agency contains a Vehicle, the other Collection is empty (By default the agency contains the empty value see this assertTrue :)
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertFalse(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		rentedVehicles.put(this.client3,this.v);
		rentedVehicles.put(this.client1,this.v2);
		//At end both Collection have same vehicles
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		/*Now reverse action by removing a rent :*/
		this.agency.returnVehicle(this.client3);
		this.agency.returnVehicle(this.client1);
		//Here the other Collection contains a Vehicle, the agency's Collection is empty
		assertFalse(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		rentedVehicles.remove(this.client3);
		rentedVehicles.remove(this.client1);
		//At end both Collection are empty
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
	}

	//Test for renting different client and vehicle in the agency :
	@Test
	public void rentedVehicleByDifferentClientAndVehicleTest() throws IllegalStateException, UnknownVehicleException {
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		this.agency.addVehicle(this.v);
		this.agency.addVehicle(this.v2);
		assertEquals(100,this.agency.rentVehicle(this.client1,this.v),0.0001);
		assertEquals(330,this.agency.rentVehicle(this.client3,this.v2),0.0001);
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertFalse(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		rentedVehicles.put(this.client1,this.v);
		rentedVehicles.put(this.client3,this.v2);
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
	}

	//Test for rent an unknown Vehicle :
	@Test(expected =rental.UnknownVehicleException.class)
	public void rentVehicleUnknownTest()throws IllegalStateException, UnknownVehicleException{
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		assertEquals(110,this.agency.rentVehicle(client3, v),0.0001);
	}

	//Test for rent a Vehicle already rented by an other client:
	@Test(expected =java.lang.IllegalStateException.class)
	public void rentVehicleAlreadyRentedByDifferentClientTest()throws IllegalStateException, UnknownVehicleException{
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		this.agency.addVehicle(this.v);
		assertEquals(110,this.agency.rentVehicle(client3, v),0.0001);
		assertEquals(110,this.agency.rentVehicle(client1, v),0.0001);
	}

	//Test for renting by another different Object instance but client :
	@Test(expected =java.lang.IllegalStateException.class)
	public void rentVehicleAlreadyRentedBySameClientAndDifferentInstanceTest()throws IllegalStateException, UnknownVehicleException{
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		this.agency.addVehicle(this.v);
		this.agency.addVehicle(this.v2);
		assertEquals(110,this.agency.rentVehicle(client3, v),0.0001);
		assertEquals(330,this.agency.rentVehicle(client4, v2),0.0001);
	}

	//Test for renting by a customer who already rent a vehicle :
	@Test(expected =java.lang.IllegalStateException.class)
	public void rentVehicleAlreadyClientTest()throws IllegalStateException, UnknownVehicleException{
		assertTrue(this.agency.allRentedVehicles().containsAll(this.rentedVehicles.values()));
		assertTrue(this.rentedVehicles.values().containsAll(this.agency.allRentedVehicles()));
		this.agency.addVehicle(this.v);
		this.agency.addVehicle(this.v2);
		assertEquals(110,this.agency.rentVehicle(client3, v),0.0001);
		assertEquals(330,this.agency.rentVehicle(client3, v2),0.0001);
	}

	//Test to check if client has already rent a vehicle :
	@Test
	public void hasRentedVehicleTest()throws IllegalStateException, UnknownVehicleException{
		this.agency.addVehicle(this.v);
		assertFalse(this.agency.hasRentedAVehicle(this.client3));
		this.agency.rentVehicle(this.client3,this.v);
		assertTrue(this.agency.hasRentedAVehicle(this.client3));
	}

	//Test to check if a vehicle was already rented :
	@Test
	public void vehicleIsRentedTest()throws IllegalStateException, UnknownVehicleException{
		this.agency.addVehicle(this.v);
		assertFalse(this.agency.isRented(this.v));
		this.agency.rentVehicle(this.client3,this.v);
		assertTrue(this.agency.isRented(this.v));
	}

	// ---For test execution----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.SuspiciousRentalAgencyTest.class);
	}

}
