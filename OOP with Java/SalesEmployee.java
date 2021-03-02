import java.util.ArrayList;
import java.util.Calendar;
public class SalesEmployee extends RegularEmployee { //Regular employee is superclass of SalesEmployee
	//MEHMET ALPER KARABAY 150119044
private ArrayList<Product> sales =new ArrayList<>();
public int numberOfSalesEmployees; //Creating the data fields
//Creating the consturctors
public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, 
		String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, 
		Department department, double pScore, ArrayList<Product> s) {
	super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence, salary, hireDate , department , pScore);
	this.sales = s;
}
public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
	super(re.getId() , re.getFirstName() , re.getLastName() , re.getGender() , 
			re.getBirthDate() , re.getMaritalStatus() , re.getHasDriverLicence() ,
			re.getSalary() , re.getHireDate() , re.getDepartment() , re.getPerformanceScore());
	this.sales = s;
}
//this 2 methods will be used to add their sales to salesEmployees
public boolean addSale(Product s) {
	
	return sales.add(s);
}
public boolean removeSale(Product s) throws Exception {
	if(!sales.contains(s))
		throw new Exception("Product does not exist");
	
	return sales.remove(s);
}
public double getOveralIncome(ArrayList<Product> s) {
	double oInc = 0;
	for(int i = 0 ; i < s.size() ; i++ ) {
		oInc += sales.get(i).getPrice();
	}
	return oInc;
}
@Override
public String toString() {
	return "SalesEmployee \n\t\t\t\tPerson Info [id=" + getId() + " , firstName: " + getFirstName() + " , lastName: " + getLastName() + " , gender: " + getGender() +
			"]\n\t\t\t\tEmployee Info [salary= " + getSalary() + " , hireDate=" + getHireDate().get(Calendar.DAY_OF_MONTH) + "/" + getHireDate().get(Calendar.MONTH) + "/"  + getHireDate().get(Calendar.YEAR) +
			"]\n\t\t\t\tRegularEmployee Info [performanceScore= " + getPerformanceScore() + 
			" , bonus= " + Math.round(getBonus()*100.0)/100.0 + "]\n\t\t\t\tProduct " + sales;
}
public ArrayList<Product> getSales() {
	return sales;
}
public void setSales(ArrayList<Product> sales) throws Exception {
	if(sales.equals(null))                                                     //Creating getters and setters
		throw new Exception("You should add sales");
	this.sales = sales;
}
public int getNumberOfSalesEmployees() {
	return numberOfSalesEmployees;
}
public void setNumberOfSalesEmployees(int numberOfSalesEmployees) throws Exception {
	if(numberOfSalesEmployees<0)
		throw new Exception("Number of sales employees cant be negavetive or zero");
	this.numberOfSalesEmployees = numberOfSalesEmployees;
}
}
