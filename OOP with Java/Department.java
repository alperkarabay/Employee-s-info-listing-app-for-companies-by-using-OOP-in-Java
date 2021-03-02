
public class Department {
	//MEHMET ALPER KARABAY 150119044
private int departmentId;      //Creating data fields
private String departmentName;
public Department() {
}
//Creating constructors
public Department(int departmentId , String departmentName) {
	this.departmentId = departmentId;
	this.departmentName = departmentName;
}
@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
}
public int getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(int departmentId) throws Exception{
	if(departmentId<1) {                                                  //Creating getters and setters
		throw new Exception("Id must be bigger than 0");
	}
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) throws Exception {
	if(departmentName.length()<3)
		throw new Exception("Department name should have at least 3 characters");
	this.departmentName = departmentName;
}
}
