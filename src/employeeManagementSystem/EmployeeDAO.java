package employeeManagementSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Creating a connection using the getConnection method
    Connection con = ConnectionProvider.getConnection();

    public void createTable() {
        try {
            Statement createTableStatement = con.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS employees ("
                                     + "    employeeid INT AUTO_INCREMENT PRIMARY KEY,"
                                     + "    firstName VARCHAR(50),"
                                     + "    lastName VARCHAR(50),"
                                     + "    phoneNumber VARCHAR(20),"
                                     + "    address VARCHAR(255),"
                                     + "    jobrole VARCHAR(100)"
                                     + ");";
            createTableStatement.executeUpdate(createTableQuery);
            createTableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEmployee(Employee emp) {
        try {
            PreparedStatement insertEmployeeStatement = con.prepareStatement("INSERT INTO employees "
                                                                           + "(firstName, lastName, phoneNumber, address, jobRole)"
                                                                           + "VALUES (?,?,?,?,?);");
            insertEmployeeStatement.setString(1, emp.getFirstName());
            insertEmployeeStatement.setString(2, emp.getLastName());
            insertEmployeeStatement.setString(3, emp.getPhoneNumber());
            insertEmployeeStatement.setString(4, emp.getAddress());
            insertEmployeeStatement.setString(5, emp.getJobRole());
            insertEmployeeStatement.executeUpdate();
            insertEmployeeStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateEmployeeDetail(String valuetoChange, int id, String newValue) {
    	
    	try {
    		
    		String updateEmployeeDetailQuery = "UPDATE employees Set "+ valuetoChange+ "= ? WHERE employeeid = ?";
    		System.out.println(updateEmployeeDetailQuery);
			PreparedStatement updateEmployeeDetailStatement = con.prepareStatement(updateEmployeeDetailQuery);
			updateEmployeeDetailStatement.setString(1, newValue);
			updateEmployeeDetailStatement.setInt(2, id);
			updateEmployeeDetailStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void deleteEmployeeUsingId(int id) {
        try {
            PreparedStatement deleteEmployeeUsingIdStatement = con.prepareStatement("DELETE FROM employees WHERE employeeid = ?");
            deleteEmployeeUsingIdStatement.setInt(1, id);
            deleteEmployeeUsingIdStatement.executeUpdate();
            deleteEmployeeUsingIdStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> listAllEmployees() {
    	
    	List<Employee> employees = new ArrayList<>();
        try {
            Statement listAllEmployeesStatement = con.createStatement();
            String listAllEmployeesQuery = "SELECT * FROM employees";
            ResultSet rs = listAllEmployeesStatement.executeQuery(listAllEmployeesQuery);

            while (rs.next()) {
            	
            	Employee emp = new Employee();
            	emp.setEmployeeid(rs.getInt(1));
            	emp.setFirstName(rs.getString(2));
            	emp.setLastName(rs.getString(3));
            	emp.setPhoneNumber(rs.getString(4));
            	emp.setAddress(rs.getString(5));
            	emp.setJobRole(rs.getString(6));
            	
            	employees.add(emp);
            	
            	//In case you wanted to print one by one
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) +
                                   " " + rs.getString(3) + " | " + rs.getString(4) +
                                   " | " + rs.getString(5) + " | " + rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void findEmployeeById(int id) {
        try {
            PreparedStatement findEmployeeByIdStatement = con.prepareStatement("SELECT * FROM employees WHERE employeeid = ?");
            findEmployeeByIdStatement.setInt(1, id);
            ResultSet rs = findEmployeeByIdStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) +
                                   " " + rs.getString(3) + " | " + rs.getString(4) +
                                   " | " + rs.getString(5) + " | " + rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void findEmployeeByRole(String role) {
        try {
            PreparedStatement findEmployeeByRoleStatement = con.prepareStatement("SELECT * FROM employees WHERE jobRole LIKE ?");
            findEmployeeByRoleStatement.setString(1, "%" + role + "%");
            ResultSet rs = findEmployeeByRoleStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) +
                                   " " + rs.getString(3) + " | " + rs.getString(4) +
                                   " | " + rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTable() {
        try {
            Statement deleteTableStatement = con.createStatement();
            String deleteTableQuery = "DROP TABLE IF EXISTS employees";
            deleteTableStatement.executeUpdate(deleteTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
