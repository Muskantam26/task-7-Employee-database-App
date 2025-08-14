import java.sql.*;
import java.util.*;

public class EmployeeDAO {

	public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getEmail());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
        }
    }
	
	  public List<Employee> getAllEmployees() throws SQLException {
	        List<Employee> list = new ArrayList<>();
	        String sql = "SELECT * FROM employees";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                list.add(new Employee(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("email"),
	                    rs.getDouble("salary")
	                ));
	            }
	        }
	        return list;
	  }
	  

	    public void updateEmployee(Employee emp) throws SQLException {
	        String sql = "UPDATE employees SET name = ?, email = ?, salary = ? WHERE id = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, emp.getName());
	            stmt.setString(2, emp.getEmail());
	            stmt.setDouble(3, emp.getSalary());
	            stmt.setInt(4, emp.getId());
	            stmt.executeUpdate();
	        }
	    }

	    public void deleteEmployee(int id) throws SQLException {
	        String sql = "DELETE FROM employees WHERE id = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	        }
	
}}
