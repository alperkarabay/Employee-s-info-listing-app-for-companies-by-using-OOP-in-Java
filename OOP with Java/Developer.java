import java.util.ArrayList;
import java.util.Calendar;
public class Developer extends RegularEmployee{
	//MEHMET ALPER KARABAY 150119044
	private ArrayList<Project> projects = new ArrayList<>(); //creating data fields
    public int numberOfDevelopers;
    //creating constructors
    public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate,
    		String maritalStatus, String hasDriverLicence, double salary, 
    		Calendar hireDate, Department department, double pScore, ArrayList<Project> p) {
    	super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence , salary , hireDate , department , pScore);
    	this.projects = p;
    	numberOfDevelopers++;
    }
    public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception {
    	super(re.getId(),re.getFirstName(),re.getLastName(),re.getGender(),re.getBirthDate(),re.getMaritalStatus(),
    			re.getHasDriverLicence(),re.getSalary(),re.getHireDate(),re.getDepartment(),re.getPerformanceScore());
    	setProjects(p);
    	numberOfDevelopers++;
    }
    //This 2 methods will set the projects to developers who are working on them.
    public boolean addProject(Project s) {	
    	return projects.add(s);
    }
    public boolean removeProject(Project s) {
    	return projects.remove(s);
    }
	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<Project> projects) throws Exception {
		if(projects.equals(null))
			throw new Exception("You should add projects");
		this.projects = projects;
	}
	public int getNumberOfDevelopers() {
		return numberOfDevelopers;                      //Creating getters and setters
	}
	public void setNumberOfDevelopers(int numberOfDevelopers) throws Exception {
		if(numberOfDevelopers<0)
			throw new Exception("You should add employee");
		this.numberOfDevelopers = numberOfDevelopers;
	}
	@Override
	public String toString() {
		return "Developer \n\t\t\t\tPerson Info [id=" + getId() + " , firstName: " + getFirstName() + " , lastName: " + getLastName() + " , gender: " + getGender() +
				"]\n\t\t\t\tEmployee Info [salary= " + getSalary() + " , hireDate=" + getHireDate().get(Calendar.DAY_OF_MONTH) + "/" + getHireDate().get(Calendar.MONTH) + "/"  + getHireDate().get(Calendar.YEAR) +
				"]\n\t\t\t\tRegularEmployee Info [performanceScore= " + getPerformanceScore() + 
				" , bonus= " + Math.round(getBonus()*100.0)/100.0 + "]\n\t\t\t\tProject " + projects;
	}
	
}
