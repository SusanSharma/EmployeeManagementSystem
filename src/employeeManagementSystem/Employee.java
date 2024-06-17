package employeeManagementSystem;

public class Employee {
	private int employeeid;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String jobRole;
	
	public Employee(int employeeid, String firstName, String lastName, String phoneNumber, String address, String jobRole) {
		this.employeeid = employeeid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.jobRole = jobRole;
	}
	
	



	//overloading the constructor	
	public Employee(String firstName, String lastName, String phoneNumber, String address, String jobRole) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.jobRole = jobRole;
	}
	
	
public Employee() {
	}





	//getters and setters
	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String toString() {
		return "EmployeeID: " + employeeid + " \t FirstName: " + firstName + " \t LastName: " + lastName
				+ " \t Phone Number: " + phoneNumber +" \t JobRole: " + jobRole+ "\n";
	}
	

}
