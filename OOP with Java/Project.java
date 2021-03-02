import java.util.Calendar;
public class Project {
	//MEHMET ALPER KARABAY 150119044
private String projectName;
private Calendar startDate;
private boolean state;
public Project() {
}
public Project(String pName, Calendar startDate, String state) throws Exception {
	this.projectName=pName;
	this.startDate=startDate;
	setState(state);
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) throws Exception {                  //Creating getters and setters
	if(projectName.equals(null))
		throw new Exception("Invalid name");
	this.projectName = projectName;
}
public Calendar getStartDate() {
	return startDate;
}
public void setStartDate(Calendar startDate) {
	this.startDate = startDate;
}
public String getState() {
	if(state==true)
		return "Open";
	else 
		return "Close";
}
public void setState(String state) throws Exception{
	if(!state.equals("Open") && !state.equals("open") && !state.equals("Close") && !state.equals("close") )
		throw new Exception("Invalid state");
	if (state.equals("Open") || state.equals("open"))
		this.state = true;
	else if (state.equals("Close") || state.equals("close"))
		this.state = false;
	else
		System.out.println("State input should be 'Open' or 'Close' " );
}
public void close() {
	this.state=false;
}
@Override
public String toString() {
	return "Project [projectName=" + projectName + ", startDate=" + getStartDate().get(Calendar.DAY_OF_MONTH) + "/" + getStartDate().get(Calendar.MONTH) + "/" +
			getStartDate().get(Calendar.YEAR) + ", state=" + state + "]";
}
}
