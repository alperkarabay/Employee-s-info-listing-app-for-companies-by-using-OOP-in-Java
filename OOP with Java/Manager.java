import java.util.ArrayList;
import java.util.Calendar;
public class Manager extends Employee {
	//MEHMET ALPER KARABAY 150119044
private ArrayList<RegularEmployee> regularEmployees = new ArrayList<>();
private double bonusBudget; //Creating managers data fields
//Creating managers constructors
public Manager (int id , String firstName , String lastName , String gender ,
	      Calendar birthDate , String maritalStatus , String hasDriverLicence,
	      double salary, Calendar hireDate , Department department , double bonusBudget) {
	super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence, salary, hireDate , department);
	this.bonusBudget = bonusBudget;
}
public Manager(Employee employee, double bonusBudget) {
	super(employee.getId() , employee.getFirstName() , employee.getLastName() , employee.getGender() , 
			employee.getBirthDate() , employee.getMaritalStatus() , employee.getHasDriverLicence() ,
			   employee.getSalary() , employee.getHireDate() , employee.getDepartment());
	this.bonusBudget = bonusBudget;
	
}
//this 2 methods will be used to set the regular employees to managers
public void addEmployee(RegularEmployee e) {
	regularEmployees.add(e);
}
public void removeEmployee(RegularEmployee e) {
	regularEmployees.remove(e);
}
//This method will be used to distribute bonus budgets of managers
public void distributeBonusBudget() throws Exception {
	double x=0;
	for(int i=0 ; i<regularEmployees.size() ; i++ ) {
		RegularEmployee a = regularEmployees.get(i);
		x+=a.getSalary()*a.getPerformanceScore();
	}
	double unit = getBonusBudget()/x;
	for(int i=0 ; i<regularEmployees.size() ; i++ ) {
		RegularEmployee a = regularEmployees.get(i);
		a.setBonus(unit*a.getSalary()*a.getPerformanceScore());
		regularEmployees.set(i,a);
	}
}
@Override
public String toString() {
	return "Manager [" + "id: " + super.getId() + "," + super.getFirstName() + " " + super.getLastName() + ", " + "Number of Employees: " + regularEmployees.size() + "]";
}
public ArrayList<RegularEmployee> getRegularEmployees() {
	return regularEmployees;
}
public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) throws Exception {
	if(regularEmployees.equals(null))
		throw new Exception("You should add regular employee");                     //Creating getters and setters
	this.regularEmployees = regularEmployees;
}
public double getBonusBudget() {
	return bonusBudget;
}
public void setBonusBudget(double bonusBudget) throws Exception{
	if(bonusBudget<0)
		throw new Exception("Bonus budget should be bigger than zero");
	this.bonusBudget = bonusBudget;
}
}
