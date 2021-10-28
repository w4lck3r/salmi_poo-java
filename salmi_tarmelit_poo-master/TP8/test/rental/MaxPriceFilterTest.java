package rental;
import static org.junit.Assert.*;
import org.junit.Test;
import rental.vehicle.Vehicle;
/**
  * A test class for the filter class MaxPriceFilter in the package rental.
  * @author TARMELLIT Lydia | SALMI badr-eddine

  */
public class MaxPriceFilterTest {

	//Test to check if the vehicle was accepted according to this criterion :
	@Test
	public void testAccept() {
		MaxPriceFilter criterion = new MaxPriceFilter(150);
		Vehicle v1 = new Vehicle("brand1","model1",2015,100);
		Vehicle v2 = new Vehicle("brand2","model2",2000,200);
		assertTrue(criterion.accept(v1));
		assertFalse(criterion.accept(v2));
	}

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
  	return new junit.framework.JUnit4TestAdapter(rental.MaxPriceFilterTest.class);
  }
}
