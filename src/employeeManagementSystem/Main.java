package employeeManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;
        List<Employee> employees = dao.listAllEmployees();
        System.out.println("Welcome to the Employee Management System.");
        
        do {
            System.out.println("Press 1 to add an employee");
            System.out.println("Press 2 to update an employee''s detail");
            System.out.println("Press 3 to delete an employee");
            System.out.println("Press 4 to search an employee: ");
            System.out.println("Press 5 to see records of all employees");
            System.out.println("Press 6 to Exit");
            choice = sc.nextInt();
            sc.nextLine();
        
            switch(choice) {
                case 1:{
                    System.out.println("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.println("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Phone Number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.println("Address: ");
                    String address = sc.nextLine();
                    System.out.println("Job Role: ");
                    String jobRole = sc.nextLine();
                    
                    Employee emp = new Employee(firstName, lastName, phoneNumber, address, jobRole);
                    System.out.println(emp);
                    System.out.println("Press y to finalize the insertion.");
                    String userChoice1 = sc.nextLine();
                    if(userChoice1.toLowerCase().equals("y")) {
                    	dao.insertEmployee(emp);
                        employees.add(emp);
                        System.out.println("Successfully added.");
                        System.out.println("Press Y to see the updated list of employees.");
                        String userChoice = sc.nextLine();
                        if(userChoice.toLowerCase().equals("y")) {
                        	System.out.println(employees);
                        }
                        
                    }
                    else {
                    	
                    	choice = 1;
                    }
                    
                    
                    break;
                    
                }
                
                case 2: {
                	System.out.println("Enter the id of the employee you want to update: ");
                	int id = sc.nextInt();
                	System.out.println("Enter what you would like to update: ");
                	System.out.println("Press 1 to update first name.");
                	System.out.println("Press 2 to update last name.");
                	System.out.println("Press 3 to update phone number.");
                	System.out.println("Press 4 to update address.");
                	System.out.println("Press 5 to update job role.");
                	int userChoice = sc.nextInt();
                	sc.nextLine();
                	System.out.println("What would you like the new value to be?");
                	String newValue = sc.nextLine();
                	System.out.println(newValue);
                	if(userChoice>0 && userChoice<6) {
                		
                		switch(userChoice) {
                			case 1:{
                				dao.updateEmployeeDetail("firstName", id, newValue);
                				break;
                			}
                			
                			case 2:{
                				dao.updateEmployeeDetail("lastName", id, newValue);
                				break;
                			}
                			case 3:{
                				dao.updateEmployeeDetail("phoneNumber", id, newValue);
                				break;
                			}
                			case 4:{
                				dao.updateEmployeeDetail("address", id, newValue);
                				break;
                			}
                			case 5:{
                				dao.updateEmployeeDetail("jobRole", id, newValue);
                				break;
                			}
                			default:{
                				System.out.println("Invalid choice");
                			}
                		}
                	}
                	
                	else {
                		System.out.println("Invalid Choice");
                	}
                	break;
                }
                
                case 3:{
                    System.out.println("Enter the id of the employee you want to fire: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    dao.deleteEmployeeUsingId(id);
                    System.out.println("Successfully Deleted");
                    System.out.println("Press Y see the new list of employees: ");
                    String response = sc.nextLine();
                    
                    if(response.equals("Y") || response.equals("y")) {
                        System.out.println();
                        dao.listAllEmployees();
                    }
                    break;
                    
                }
                case 4:{
                    System.out.println("Would you like to find the employee by id or role");
                    String response = sc.nextLine();
                    
                    if(response.toLowerCase().equals("id")) {
                        System.out.println("Enter the employee id: ");
                        int employeeid = sc.nextInt();
                        sc.nextLine();
                        dao.findEmployeeById(employeeid);
                    }
                    
                    else if(response.toLowerCase().equals("role")) {
                        System.out.println("Enter the role: ");
                        String role = sc.nextLine();
                        dao.findEmployeeByRole(role);
                    }
                    break;
                }
                
                case 5:{
                	
                    
                    System.out.println(employees);
                    break;
                }
                
                case 6: {
                    System.out.println("Thank you for using our system.");
                    break;
                }
                
                default:{
                    System.out.println("Invalid choice, try again.");
                    break;
                }
                
            }
            
            if(choice!= 5) {
                System.out.println("Press M to return to menu.");
                System.out.println("Press E to return to menu.");
                String response = sc.nextLine();
                
                if(response.toLowerCase().equals("e")) {
                    choice = 5;
                }
            }
            
        }while(choice!=5);
        
        
        sc.close();
        
    }

}
