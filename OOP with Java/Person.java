import java.util.Calendar;
public class Person {
	//Creating person's data fields
private int id;
private String firstName;
private String lastName;
private byte gender;
private Calendar birthDate;
private byte maritalStatus;
private boolean hasDriverLicence;
public Person() {
	//MEHMET ALPER KARABAY 150119044
}//Crerating person's constructors
public Person(int id , String firstName , String lastName , String gender ,
		      Calendar birthDate , String maritalStatus , String hasDriverLicence ) {
	this.id  = id;
	this.firstName = firstName;
	this.lastName = lastName;
	try {
		setGender(gender);
	} catch (Exception e) {
		System.out.println("Invalid input");//creating getters and setters
	}
	this.birthDate=birthDate;
	try {
		setMaritalStatus(maritalStatus);
	} catch (Exception e) {
		System.out.println("Invalid input");
	}
	try {
		setHasDriverLicence(hasDriverLicence);
	} catch (Exception e) {
		System.out.println("Invalid input");
	}
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) throws Exception {
	if (firstName.equals(null)) {
		throw new Exception("Name can not be null");
	}
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) throws Exception {
	if (lastName.equals(null)) {
		throw new Exception("Name can not be null");
	}
	this.lastName = lastName;
}
public String getGender() {
	if(this.gender==1)
	return "Woman";
    else if (this.gender==2)
    return "Man";
    else
    return "Invalid content";
}
public void setGender(String gender) throws Exception{
	if(!gender.equals("Woman") && !gender.equals("Man")) {
		throw new Exception("Invalid gender");
	}
	if(gender.equals("Woman"))
    this.gender=1;
	else if (gender.equals("Man"))
	this.gender=2;
}
public java.util.Calendar getBirthDate() {
	return birthDate;
}
public void setBirthDate(java.util.Calendar birthDate) {
	this.birthDate = birthDate;
}
public String getMaritalStatus() {
	if(this.maritalStatus==1)
	return "Single";
	else if (this.maritalStatus==2)
    return "Married";
    else
    return "Invalid content";
	}

public void setMaritalStatus(String Status) throws Exception {
	if(!Status.equals("Single") && !Status.equals("Married")) {
		throw new Exception("Invalid status");
	}
	if(Status.equals("Single"))
	this.maritalStatus=1;
	else if (Status.equals("Married"))
	this.maritalStatus=2;
}
public String getHasDriverLicence() {
	if(hasDriverLicence == true)
		return "Yes";
	else if (hasDriverLicence == false)
		return "No";
	else 
		return "Invalid content";
}
public void setHasDriverLicence(String hasDriverLicence) throws Exception {
	if(!hasDriverLicence.equals("Yes") && !hasDriverLicence.equals("No")) {
		throw new Exception("Invalid status");
	}
	if(hasDriverLicence.equals("Yes"))
	this.hasDriverLicence = true;
	else if(hasDriverLicence.equals("No"))
	this.hasDriverLicence = false;
}
@Override
public String toString() {
	return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender()
			+ ", birthDate=" + getBirthDate().get(Calendar.DAY_OF_MONTH) + "/" + getBirthDate().get(Calendar.MONTH) + "/" +
			getBirthDate().get(Calendar.YEAR) +", maritalStatus=" + getMaritalStatus() + ", hasDriverLicence=" + getHasDriverLicence()
			+ "]";
}

}
