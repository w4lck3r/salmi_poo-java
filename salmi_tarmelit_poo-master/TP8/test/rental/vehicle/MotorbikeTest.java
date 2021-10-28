package rental.vehicle;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
  * A test class for the class Motorbike in the package rental.vehicle.
  */
public class MotorbikeTest {
 
	private Motorbike moto1;
	private Motorbike moto2;

  
	@Before
	public void before() {
		this.moto1 = new Motorbike("brand1","model1",2015,100.0f,125);
		this.moto2 = new Motorbike("brand2","model2",2000,200.0f,500);
	}

	
	@Test
	public void testGetBrand() {
		assertEquals("brand1",this.moto1.getBrand());
		assertEquals("brand2",this.moto2.getBrand());
	}

	
	@Test
	public void testGetModel() {
		assertEquals("model1",this.moto1.getModel());
		assertEquals("model2",this.moto2.getModel());
	}

	
	@Test
	public void testGetDailyPrice() {
	    assertEquals(100.0f,this.moto1.getDailyPrice(),0.0001);
	    assertEquals(200.0f,this.moto2.getDailyPrice(),0.0001);
	}

	
	@Test
	public void testGetProductionYear() {
	    assertEquals(2015,this.moto1.getProductionYear());
	    assertEquals(2000,this.moto2.getProductionYear());
	}

	
	@Test
	public void testGetCylinderCapacity() {
	    assertEquals(125,this.moto1.getCylinderCapacity());
	    assertEquals(500,this.moto2.getCylinderCapacity());
	}

	
	@Test
	public void testToStringMotorbike(){
		assertEquals("2015 brand1 model1 100.0 125 cm3",this.moto1.toString());
		assertEquals("2000 brand2 model2 200.0 500 cm3",this.moto2.toString());
	}

	

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
	   return new junit.framework.JUnit4TestAdapter(MotorbikeTest.class);
  }

}
