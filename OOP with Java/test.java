import java.util.Calendar;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
public class test {

	//MEHMET ALPER KARABAY 150119044
	public static void main(String[] args) throws Exception {
		File iFile = new File("input.txt");
		Scanner input = new Scanner(iFile);
		ArrayList <Department> departmentList = new ArrayList<>();
		ArrayList <Project> projectList = new ArrayList<>();
		ArrayList <Product> productList = new ArrayList<>();
		ArrayList <Person> personList = new ArrayList<>();
		ArrayList <Employee> employeeList = new ArrayList<>();
		ArrayList <RegularEmployee> regularEmployeeList = new ArrayList<>();
		ArrayList <Developer> developerList = new ArrayList<>();
		ArrayList <Customer> customerList = new ArrayList<>();
		ArrayList <Manager> managerList = new ArrayList<>();
		ArrayList<SalesEmployee> salesEmployeeList = new ArrayList<>();
		// reading input from a file and create new objects based on the line read
		while (input.hasNext()) {
			String a = input.next();
		if(a.equals("Department")) { //creating a new Department with an id and name 
			int id = input.nextInt();
			String dName = input.next();
			Department department = new Department(id,dName);
			departmentList.add(department);
		}
		else if(a.equals("Project")) {// creating a new Project with the name, start date and state 
			String pName = input.next();
			String c = input.next();
			String[] b = c.split("/");
			Calendar startDate = Calendar.getInstance() ;
			startDate.set(Integer.parseInt(b[2]) , Integer.parseInt(b[1]) , Integer.parseInt(b[0]));
			String state = input.next();
			Project project = new Project(pName , startDate , state);
			projectList.add(project);
		}
		else if (a.equals("Product")) {// creating a new Product with the name, sale date and price 
			String prName = input.next();
			String c = input.next();
			String[] b = c.split("/");
			Calendar saleDate = Calendar.getInstance() ;
			saleDate.set(Integer.parseInt(b[2]) , Integer.parseInt(b[1]) , Integer.parseInt(b[0]));
			int price = input.nextInt();
			Product product = new Product(prName , saleDate , price);
			productList.add(product);
		}
		else if (a.equals("Person")) {//creating a new Person with the name,surname,gender,birthdate,marital status and driver licence info 
			String firstName = input.next();
			String lastName = input.next();
			int id = input.nextInt();
			String gender = input.next();
			String c = input.next();
			String[] b = c.split("/");
			Calendar birthDate = Calendar.getInstance() ;
			birthDate.set(Integer.parseInt(b[2]) , Integer.parseInt(b[1]) , Integer.parseInt(b[0]));
			String maritalStatus = input.next();
			String hasDriverLicence = input.next();
			Person person = new Person( id  , firstName ,lastName, gender , birthDate , maritalStatus , hasDriverLicence);
			personList.add(person);
		}
		else if (a.equals("Employee")) {	
			// creating a new Employee by finding the Person with the given id and invoking the overloaded constructor of Employee with the Person found,Salary,hire date and department
			int eId = input.nextInt();
			int Salary = input.nextInt();
			for(int i=0 ; i<personList.size() ; i++) {
				if (personList.get(i).getId() == eId) {
					String c = input.next();
					String[] b = c.split("/");
					Calendar hireDate = Calendar.getInstance() ;
					hireDate.set(Integer.parseInt(b[2]) , Integer.parseInt(b[1]) , Integer.parseInt(b[0]));
				    String d = input.next();
					for(int j=0 ; j<departmentList.size() ; j++) {
						if(d.equals(departmentList.get(j).getDepartmentName())) {
							Employee employee = new Employee(personList.get(i),Salary,hireDate,departmentList.get(j));
						    employeeList.add(employee);}
						}}}
		}
		else if (a.equals("Manager")) {
			//creating a new manager by finding the employee with given id, and bonus budget.
			int mId = input.nextInt();
			int bBudget = input.nextInt();
			for(int j=0 ; j<employeeList.size() ; j++) {
				if (employeeList.get(j).getId() == mId) {
					Manager manager = new Manager(employeeList.get(j),bBudget);
					managerList.add(manager);
			}
			}
		}
		else if (a.equals("RegularEmployee")) {
			//creating a new RegularEmployee by finding the Employee with the given id and invoking the overloaded constructor of RegularEmployee with the Employee found and performanceScore
			int rId = input.nextInt();
			double pScore = input.nextDouble();
			for(int i=0 ; i<employeeList.size() ; i++){
				if(employeeList.get(i).getId() == rId) {
					RegularEmployee regularEmployee = new RegularEmployee(employeeList.get(i),pScore);
					regularEmployeeList.add(regularEmployee);
				}
			}
			
		}
		else if (a.equals("SalesEmployee")) {
			//Creating a new sales employee by finding the regular employee with given id and invoking the overloaded constructor of sales employee with the Regular employee found and his/her products.
			int sId = input.nextInt();
			String sProduct=input.next();
			
			for(int i=0 ; i<regularEmployeeList.size() ; i++) {
				if (regularEmployeeList.get(i).getId() == sId) {
					ArrayList<Product> sProducts = new ArrayList<>();
				for(int j=0 ; j<productList.size() ; j++) {
					if(sProduct.equals(productList.get(j).getProductName())) {
						sProducts.add(productList.get(j));
						if(input.hasNext("Person")  || input.hasNext("Employee") || input.hasNext("RegularEmployee") || 
								input.hasNext("Manager") ||input.hasNext("SalesEmployee") ||input.hasNext("Developer") || 
								input.hasNext("Department") || input.hasNext("Project") || !input.hasNext()) {
							break;
						}
						else
							sProduct = input.next(); j=0;
					}
				}
				SalesEmployee sEmployee = new SalesEmployee(regularEmployeeList.get(i),sProducts);
				salesEmployeeList.add(sEmployee);
				}
		}}	
		
		else if (a.equals("Developer")) {
			//creating a new Developer by finding the RegularEmployee with the given id and invoking the overloaded constructor of Developer with the RegularEmployee found, project list.
			int dId = input.nextInt();
			String dProject = input.next();
			for(int i=0 ; i<regularEmployeeList.size() ; i++){
				if(regularEmployeeList.get(i).getId() == dId) {
					ArrayList<Project> dProjects = new ArrayList<>();
					for(int j=0 ; j<projectList.size() ; j++) {
						if(dProject.equals(projectList.get(j).getProjectName())) {
							dProjects.add(projectList.get(j));
							if(input.hasNext("Person") || input.hasNext("Customer") || input.hasNext("Employee") || input.hasNext("RegularEmployee") || 
									input.hasNext("Manager") ||input.hasNext("SalesEmployee") ||input.hasNext("Developer") || input.hasNext("Product")  ||
									input.hasNext("Department") || input.hasNext("Project") || !input.hasNext()) {
								break;
							}
							else
							dProject=input.next(); j=0;
						}
					}
					Developer developer = new Developer(regularEmployeeList.get(i),dProjects);
					developerList.add(developer);
				}
			}
		}
		else if (a.equals("Customer")) {
			// creating a new Customer by finding the Person with the given id and invoke the overloaded constructor of Customer with the Person found, product list.
			int cId = input.nextInt();
			String cProduct = input.next();
			for(int i=0 ; i<personList.size() ; i++) {
				if (personList.get(i).getId() == cId) {
				ArrayList<Product> cProducts = new ArrayList<>();
				for(int j=0 ; j<productList.size() ; j++) {
					if(cProduct.equals(productList.get(j).getProductName())) {
						cProducts.add(productList.get(j));
						if(input.hasNext("Person") || input.hasNext("Customer") || input.hasNext("Employee") || input.hasNext("RegularEmployee") || 
								input.hasNext("Manager") ||input.hasNext("SalesEmployee") ||input.hasNext("Developer") || 
								input.hasNext("Department") || input.hasNext("Project") || !input.hasNext()) {
							break;
						}
						else
							cProduct=input.next(); j=0;
					}
				}
				Customer customer = new Customer(personList.get(i),cProducts);
				customerList.add(customer);
				}
		}}
		
		else
			System.out.println("Invalid input.");
					}
		input.close();
		ArrayList<RegularEmployee> oRegularEmployees = new ArrayList<>(); //This arraylist is to stack only regular employees without sales employees and developers
		for(int i=0 ; i<regularEmployeeList.size() ; i++) {
			oRegularEmployees.add(regularEmployeeList.get(i));
		}
		for(int k=0 ; k<oRegularEmployees.size() ; k++) {
			for(int q=0 ; q<salesEmployeeList.size() ; q++) {
				if(oRegularEmployees.get(k).getId() == salesEmployeeList.get(q).getId()) {
					oRegularEmployees.remove(k);
					k= -1;
					q= -1;
					break;
				}
			}
		}
		for(int k=0 ; k<oRegularEmployees.size() ; k++) {	
			for(int q=0 ; q<salesEmployeeList.size() ; q++) {
				if(oRegularEmployees.get(k).getId() == developerList.get(q).getId()) {
					oRegularEmployees.remove(k);
					k= -1;
					q= -1;
					break;
				}
			}}
		//next statements is for attach the regular employees to their managers
		for(int i=0 ; i<managerList.size() ; i++) {
		for(int k=0 ; k<oRegularEmployees.size() ; k++) {
			if (managerList.get(i).getDepartment().getDepartmentName().equals(oRegularEmployees.get(k).getDepartment().getDepartmentName())) {
				managerList.get(i).addEmployee(oRegularEmployees.get(k));	
			}
		}
		for(int k=0 ; k<salesEmployeeList.size() ; k++) {
			if (managerList.get(i).getDepartment().getDepartmentName().equals(salesEmployeeList.get(k).getDepartment().getDepartmentName())) {
				managerList.get(i).addEmployee(salesEmployeeList.get(k));
				
			}}
		
		for(int k=0 ; k<developerList.size() ; k++) {
			if (managerList.get(i).getDepartment().getDepartmentName().equals(developerList.get(k).getDepartment().getDepartmentName())) {
				managerList.get(i).addEmployee(developerList.get(k));
			}
		}}
		//invoking distribute bonus budget and raise salary methods for managers
		for(int i=0 ; i<managerList.size() ; i++) {
	     managerList.get(i).distributeBonusBudget();
	     managerList.get(i).raiseSalary(0.2);
		}
		//invoking raise salary method for regular employees
		for(int j=0; j<regularEmployeeList.size() ; j++) {
			regularEmployeeList.get(j).raiseSalary(0.3);
		}
		//invoking raise salary method for developers
		for(int k=0; k<developerList.size(); k++) {
			developerList.get(k).raiseSalary(0.23);
		}
		//invoking raise salary method for sales employees
		for(int x=0 ; x<salesEmployeeList.size() ; x++) {
			salesEmployeeList.get(x).raiseSalary(0.18);
		}
		//finding the sales employee with maximun income and giving him/her to exstra salary with raise salary method
		SalesEmployee maximunSale = salesEmployeeList.get(0);
		for(int i = 1 ; i< salesEmployeeList.size() ; i++) {
			if (salesEmployeeList.get(i - 1)
                    .getOveralIncome(salesEmployeeList.get(i - 1).getSales()) > salesEmployeeList.get(i)
                            .getOveralIncome(salesEmployeeList.get(i).getSales())) {
                maximunSale = salesEmployeeList.get(i - 1);
            } else {
                maximunSale = salesEmployeeList.get(i);
            }
		}
		maximunSale.raiseSalary(1000);
		//creating output file
		File file1 = new File("output.txt");
		PrintWriter writer = new PrintWriter(file1); 
		//writing the informations
		try{int a=1;
		writer.println("*****************************************************************");
		for(int q=0 ; q<departmentList.size() ; q++) {
			writer.println(departmentList.get(q).toString());
			for(int z=0 ; z<managerList.size() ; z++) {
				if(managerList.get(z).getDepartment().getDepartmentName().equals(departmentList.get(q).getDepartmentName())) {
					writer.println("\t\t" +managerList.get(z).toString());
					for(int i=0 ; i<personList.size() ; i++) {
						if(personList.get(i).getId()==managerList.get(z).getId())
							personList.remove(i);
					}
					for(int n=0; n<developerList.size(); n++) {
						if(managerList.get(z).getDepartment().getDepartmentName().equals(developerList.get(n).getDepartment().getDepartmentName()))
							writer.println("\t\t\t" + a + ": " +developerList.get(n).toString()); a++;
							for(int i=0 ; i<personList.size() ; i++) {
								if(personList.get(i).getId()==developerList.get(n).getId())
									personList.remove(i);
							}
						}
					for(int b=0 ; b<salesEmployeeList.size() ; b++) {
						if(managerList.get(z).getDepartment().getDepartmentName().equals(salesEmployeeList.get(b).getDepartment().getDepartmentName()))
							writer.println("\t\t\t" + --a + ": " +salesEmployeeList.get(b).toString()); a++;
							for(int i=0 ; i<personList.size() ; i++) {
								if(personList.get(i).getId()==salesEmployeeList.get(b).getId())
									personList.remove(i);
							}
						}
					for(int m=0 ; m<oRegularEmployees.size() ; m++) {
						if(managerList.get(z).getDepartment().getDepartmentName().equals(oRegularEmployees.get(m).getDepartment().getDepartmentName()))
							writer.println("\t\t\t" + --a + ": " +oRegularEmployees.get(m).toString()); a++;
							for(int i=0 ; i<personList.size() ; i++) {
								if(personList.get(i).getId()==oRegularEmployees.get(m).getId())
									personList.remove(i);
							}
						}
					a=0;
					}
				}
				}
		writer.println("********************* Customers *********************" );
		for(int i=0 ; i<customerList.size() ; i++) {
			writer.println(customerList.get(i).toString());
			for(int j=0 ; j<personList.size() ; j++) {
				if(personList.get(j).getId()==customerList.get(i).getId())
					personList.remove(j);
			}
		}
		writer.println("********************* People ************************");
		for(int i=0 ; i<personList.size() ; i++)
			writer.println(personList.get(i).toString());}catch(Exception ex) {
				System.out.println("Error occurs");
			}
        writer.close();
	}
	}
	


