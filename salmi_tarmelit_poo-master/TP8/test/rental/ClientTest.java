package rental;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
  * A test class for the class Client in the package rental.
  * @author TARMELLIT Lydia | SALMI badr-eddine

  */
public class ClientTest {
	//Instance variables :
	/*First client */
	private Client c1;
	/*Second client*/
	private Client c2;
	/*Third client : Same than c1*/
	private Client c3;
	/*Client who has same name than c1 but different age*/
	private Client c1SameName;
	/*Client who has same age than c1 but different name*/
	private Client c1SameAge;

	//Executed before each test :
	@Before
	public void before() {
		this.c1 = new Client("client1",20);
		this.c2 = new Client("client2",30);
		this.c3 = new Client("client1",20);
		this.c1SameName =new Client("client1",40);
		this.c1SameAge =new Client("Tim Oléon",20);
	}

	//Test for client's name and the getter associated :
	@Test
	public void testGetName() {
		assertEquals("client1",this.c1.getName());
		assertEquals("client2",this.c2.getName());
	}

	//Test for client's age and the getter associated :
	@Test
	public void testGetAge() {
		assertEquals(20,this.c1.getAge());
	  assertEquals(30,this.c2.getAge());
	}

	//Test to check the good string representation of the client with the toString method :
	@Test
	public void testToStringClient(){
		assertEquals("client1",this.c1.toString());
	}

	//Test for hashCode, 2 client with same name and age have the same hashCode :
	@Test
	public void testHashCode(){
		//Test with a client of different name and age
		assertFalse(this.c1.hashCode()==this.c2.hashCode());
		//Different Object instance but same name and age
		assertEquals(this.c1.hashCode(),this.c3.hashCode());
		//Test with a client of same name but not same age
		assertFalse(this.c1.hashCode()==this.c1SameName.hashCode());
		//Test with a client of same age but not same name
		assertFalse(this.c1.hashCode()==this.c1SameAge.hashCode());
	}

	//Test for the equality between 2 client :
	@Test
	public void areEqualsClientTest(){
		//Test equality with a client of same name but not same age
		assertFalse(this.c1.equals(this.c1SameName));
		//Test equality with a client of same age but not same name
		assertFalse(this.c1.equals(this.c1SameAge));
		//Test equality with a client of different name and age
		assertFalse(this.c1.equals(this.c2));
		//Same instance
		assertTrue(this.c1.equals(this.c1));
		//Different Object instance but same name and age
		assertTrue(this.c1.equals(this.c3));
		//Test equality with an other Object
		assertFalse(this.c1.equals(new Object()));
	}

  // ---For test execution----------------------
  public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.ClientTest.class);
  }

}
