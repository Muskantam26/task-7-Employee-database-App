import java.sql.*;
public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

	    private static final String USER = "root";
	    private static final String PASSWORD = "Muskan@1234";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root","Muskan@1234");
	    }}
