import java.util.ArrayList;
import java.util.Calendar;
public class Customer extends Person {//Person is the superclass of customer
	//MEHMET ALPER KARABAY 150119044
private	ArrayList<Product> products = new ArrayList<>();
//Creating the constructors of customer
public Customer(int id , String firstName , String lastName , String gender ,
	      Calendar birthDate , String maritalStatus , String hasDriverLicence , ArrayList<Product> products) {
	super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence);
	this.products = products;
}
public Customer(Person person , ArrayList<Product> products) {
	super(person.getId(),person.getFirstName() , person.getLastName(), person.getGender() ,
			person.getBirthDate() , person.getMaritalStatus() , person.getHasDriverLicence());
	this.products=products;
}
public ArrayList<Product> getProducts() { //Creating getters and setters
	return products;
}
public void setProducts(ArrayList<Product> products) throws Exception{
	if(products.equals(null))
		throw new Exception("Products cant be null");
	this.products = products;
}
@Override
public String toString() {
	return "Customer id=" + getId() +  " products=" + products + "]" ;
}




}
