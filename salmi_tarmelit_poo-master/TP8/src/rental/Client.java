package rental;
/**
  * Represent clients of a rental agency, the name and the age are supposed to be
  * unique then two Client objects with same name and same age are considered equals.
  * @author TARMELLIT Lydia | SALMI badr-eddine

  */
public class Client {
  //Instances variables :
  /*Client's name*/
  private String name;
  /*Client's age*/
  private int age;

  /**
    * Constructor for client.
    * Creates a client with given name and age.
    * @param name Name of the client
    * @param age Age of the client
    */
  public Client(String name, int age){
      this.name = name;
      this.age = age;
  }

  /**
    * Gives the client's name.
    * @return The client's name.
    */
  public String getName(){
      return this.name;
  }

  /**
    * Gives the client's age.
    * @return The client's age.
    */
  public int getAge(){
      return this.age;
  }

  /**
    * Displays the name of the client.
    * @return The representation of the client.
    * @see java.lang.Object#toString()
    */
  public String toString(){
  	return this.name;
  }

  /**
    * Returns a hash code value for the Client.
    * This method is supported for the benefit of hash tables such as those provided by HashMap.
    * @return The specific hashCode value for a client.
    * @see java.lang.Object#hashCode()
    */
  public int hashCode(){
      return this.name.hashCode()+this.age;
  }

  /**
		* This client is equals to another if they have same name and same age.
		* @param other The object to test the equality with Client.
		* @return <code>true</code> if other is the same client than this client, otherwise <code>false</code>.
		* @see java.lang.Object#equals(java.lang.Object)
		*/
  public boolean equals(Object other){
    if(other instanceof Client){
      Client o =((Client) other);
      return (this.getName().equals(o.getName()) && this.getAge()==o.getAge());
    }
    return false;
  }
}
