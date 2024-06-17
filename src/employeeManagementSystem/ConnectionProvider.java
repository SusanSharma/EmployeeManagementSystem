package employeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    // Initializing important values
    private final static String driver = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3308/employees";
    private final static String user = "root";
    private final static String pass = "";

    public static Connection getConnection() {
        // Creating a connection
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
