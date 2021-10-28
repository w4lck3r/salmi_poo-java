package rental;
import static org.junit.Assert.*;
import org.junit.Test;
import rental.vehicle.Vehicle;
/**
  * A test class for the filter class AndFilter in the package rental.
  * @author TARMELLIT Lydia | SALMI badr-eddine
 
  */
public class AndFilterTest {

	//Test to check if the vehicle was accepted according to this criterion :
	@Test
	public void addAndAcceptTest() {
		BrandFilter brandCriterion = new BrandFilter("brand1");
    MaxPriceFilter maxPriceCriterion = new MaxPriceFilter(150);
    AndFilter criterion = new AndFilter();
    criterion.addFilter(brandCriterion);
    criterion.addFilter(maxPriceCriterion);
		Vehicle v1 = new Vehicle("brand1","model1",2015,100);
    Vehicle v2 = new Vehicle("brand1","model1",2015,250);
		Vehicle v3 = new Vehicle("brand2","model2",2000,100);
		assertTrue(criterion.accept(v1));
		assertFalse(criterion.accept(v2));
    assertFalse(criterion.accept(v3));
	}

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
  	return new junit.framework.JUnit4TestAdapter(rental.AndFilterTest.class);
  }

}
