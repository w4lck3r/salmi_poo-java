package rental.vehicle;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
  * A test class for the class Vehicle in the package rental.vehicle.
  * @author TARMELLIT Lydia | SALMI badr-eddine
  */
public class VehicleTest {
 	//Instance variables :
  /*First Vehicle*/
	private Vehicle v1;
  /*Second Vehicle*/
	private Vehicle v2;

  //Executed before each test :
	@Before
	public void before() {
		this.v1 = new Vehicle("brand1","model1",2015,100.0f);
		this.v2 = new Vehicle("brand2","model2",2000,200.0f);
	}

	//Test for vehicle's brand and the getter associated :
	@Test
	public void testGetBrand() {
		assertEquals("brand1",this.v1.getBrand());
		assertEquals("brand2",this.v2.getBrand());
	}

	//Test for vehicle's model and the getter associated :
	@Test
	public void testGetModel() {
		assertEquals("model1",this.v1.getModel());
		assertEquals("model2",this.v2.getModel());
	}

	//Test for vehicle's daily price and the getter associated :
	@Test
	public void testGetDailyPrice() {
	    assertEquals(100.0f,this.v1.getDailyPrice(),0.0001);
	    assertEquals(200.0f,this.v2.getDailyPrice(),0.0001);
	}

	//Test for vehicle's production year and the getter associated :
	@Test
	public void testGetProductionYear() {
	    assertEquals(2015,this.v1.getProductionYear());
	    assertEquals(2000,this.v2.getProductionYear());
	}

	//Test to check the good string representation of the vehicle with the toString method :
	@Test
	public void testToStringVehicle(){
		assertEquals("2015 brand1 model1 100.0",this.v1.toString());
		assertEquals("2000 brand2 model2 200.0",this.v2.toString());
	}

	//Test for the equality between 2 vehicle :
	@Test
	public void testEquals() {
		Vehicle v3 = new Vehicle("brand1","model1",2015,100.0f);
		Vehicle v4 = new Vehicle("brand1","model1",2015,200.0f);
		assertTrue(this.v1.equals(v3));
		assertFalse(this.v1.equals(v2));
		assertFalse(this.v1.equals(v4));
		assertFalse(this.v1.equals(new Object()));
	}

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
	   return new junit.framework.JUnit4TestAdapter(VehicleTest.class);
  }

}
