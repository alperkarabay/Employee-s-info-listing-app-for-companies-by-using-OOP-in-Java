import java.util.Calendar;
public class RegularEmployee extends Employee { //Employee is the superclass of RegularEmployee
	//MEHMET ALPER KARABAY 150119044
private double performanceScore;
private double bonus;          //creating data fields of RegularEmployee class
public RegularEmployee() {
}
//creating regularEmployees constructors
public RegularEmployee(int id , String firstName , String lastName , String gender ,
	      Calendar birthDate , String maritalStatus , String hasDriverLicence,
	      double salary, Calendar hireDate , Department department , double performanceScore) {
	super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence, salary, hireDate , department);
	this.performanceScore = performanceScore;
}
public RegularEmployee(Employee employee, double performanceScore) {
	super(employee.getId() , employee.getFirstName() , employee.getLastName() , employee.getGender() , 
			employee.getBirthDate() , employee.getMaritalStatus() , employee.getHasDriverLicence() ,
			   employee.getSalary() , employee.getHireDate() , employee.getDepartment());
	this.performanceScore = performanceScore;
	
}

@Override
public String toString() {
	return "RegularEmployee \n\t\t\t\tPerson Info [id=" + getId() + " , firstName: " + getFirstName() + " , lastName: " + getLastName() + " , gender: " + getGender() +
	"]\n\t\t\t\tEmployee Info [salary= " + getSalary() + " , hireDate=" + getHireDate().get(Calendar.DAY_OF_MONTH) + "/" + getHireDate().get(Calendar.MONTH) + "/"  + getHireDate().get(Calendar.YEAR) +
	"]\n\t\t\t\tRegularEmployee Info [performanceScore= " + getPerformanceScore() + 
	" , bonus= " + Math.round(getBonus()*100.0)/100.0 + "]";
}
//creating getters and setters
public double getPerformanceScore() {
	return performanceScore;
}
public void setPerformanceScore(double performanceScore) throws Exception {
	if(performanceScore<0)
		throw new Exception("Performance Score cant be negative");
	this.performanceScore = performanceScore;
}  
public double getBonus() {
	return this.bonus;
}
public void setBonus(double bonus) throws Exception {
	if(bonus<0)
		throw new Exception("Bonus cant be negative");
	this.bonus = bonus;
}
}
