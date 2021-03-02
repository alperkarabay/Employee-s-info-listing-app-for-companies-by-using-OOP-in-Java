import java.util.Calendar;
public class Employee extends Person {//Person is the superclass of employee
	//MEHMET ALPER KARABAY 150119044
private double salary;
private Calendar hireDate;
private Department department;
public int numberOfEmployees;  //Creating data fields of Employee
public Employee() {
}
//creating employees contructors
public Employee(int id , String firstName , String lastName , String gender ,
	      Calendar birthDate , String maritalStatus , String hasDriverLicence,
	      double salary, Calendar hireDate , Department department) {
	super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence);
	this.salary=salary;
	this.hireDate=hireDate;
	this.department=department;
	numberOfEmployees++;
}
public Employee(Person person , double salary , Calendar hireDate , Department department) {
	super(person.getId(),person.getFirstName() , person.getLastName(), person.getGender() ,
			person.getBirthDate() , person.getMaritalStatus() , person.getHasDriverLicence());
	this.department=department;
	this.hireDate=hireDate;
	this.salary=salary;
	numberOfEmployees++;
}
//creating salary methods
public double raiseSalary(double percent) {
	if(percent>=0 && percent <= 1) {
		this.salary += this.salary*percent;
	return this.salary;}
	else {
		System.out.println("Invalid input");
		return this.salary;
	}
}
public double raiseSalary(int amount) throws Exception {
	if(amount<0)
		throw new Exception("Amount should be bigger than zero");
	this.salary += amount;
	return this.salary;
}
//creating getters and setters
public double getSalary() {
	return salary;
}
public void setSalary(double salary) throws Exception {
	if(salary<0)
		throw new Exception("Salary cant be negative");
	this.salary = salary;
}
public Calendar getHireDate() {
	return hireDate;
}
public void setHireDate(Calendar hireDate) {
	this.hireDate = hireDate;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}
public int getNumberOfEmployees() {
	return numberOfEmployees;
}
public void setNumberOfEmployees(int numberOfEmployees) {
	this.numberOfEmployees = numberOfEmployees;
}
@Override
public String toString() {
	return "Employee [salary=" + salary + ", hireDate=" + hireDate + ", department=" + department
			+ ", numberOfEmployees=" + numberOfEmployees + "]";
}


}
