package rental.vehicle;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
  * A test class for the class Car in the package rental.vehicle.
  */
public class CarTest {
 	
	private Car car1;
	private Car car2;

  
	@Before
	public void before() {
		this.car1 = new Car("brand1","model1",2015,100.0f,5);
		this.car2 = new Car("brand2","model2",2000,200.0f,4);
	}

	
	@Test
	public void testGetBrand() {
		assertEquals("brand1",this.car1.getBrand());
		assertEquals("brand2",this.car2.getBrand());
	}

	
	@Test
	public void testGetModel() {
		assertEquals("model1",this.car1.getModel());
		assertEquals("model2",this.car2.getModel());
	}


	@Test
	public void testGetProductionYear() {
	    assertEquals(2015,this.car1.getProductionYear());
	    assertEquals(2000,this.car2.getProductionYear());
	}

	
	@Test
	public void testGetNbPassengers() {
	    assertEquals(5,this.car1.getNbPassengers());
	    assertEquals(4,this.car2.getNbPassengers());
	}

	
	@Test
	public void testToStringCar(){
		assertEquals("2015 brand1 model1 100.0 5 passengers",this.car1.toString());
		assertEquals("2000 brand2 model2 200.0 4 passengers",this.car2.toString());
	}


  // ---For test execution----------------------
  public static junit.framework.Test suite() {
	   return new junit.framework.JUnit4TestAdapter(CarTest.class);
  }

}
