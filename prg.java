import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Department department = new Department(1, "IT");

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            String url = "jdbc:mysql://localhost:3306/departments";
            String user = "your_username";
            String password = "your_password";
            Connection connection = DriverManager.getConnection(url, user, password);
            
            // Create statement
            Statement statement = connection.createStatement();
            
            // Insert department into the database
            String sql = "INSERT INTO department (id, name) VALUES (" + department.getId() + ", '" + department.getName() + "')";
            statement.executeUpdate(sql);
            
            // Close statement and connection
            statement.close();
            connection.close();
            
            System.out.println("Department inserted successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}