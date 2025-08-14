import java.sql.SQLException;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
	        EmployeeDAO dao = new EmployeeDAO();


	        while (true) {
	            System.out.println("\n======= Employee Management =======");
	            System.out.println("1. Add Employee");
	            System.out.println("2. View Employees");
	            System.out.println("3. Update Employee");
	            System.out.println("4. Delete Employee");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = sc.nextInt();
	            
	            try {
	                switch (choice) {
	                    case 1:
	                        sc.nextLine(); // extra newline consume
	                        System.out.print("Enter Name: ");
	                        String name = sc.nextLine();
	                        System.out.print("Enter Email: ");
	                        String email = sc.nextLine();
	                        System.out.print("Enter Salary: ");
	                        double salary = sc.nextDouble();

	                        dao.addEmployee(new Employee(0, name, email, salary));
	                        System.out.println(" Employee Added Successfully.");
	                        break;
	                        
	                    case 2:
	                        List<Employee> list = dao.getAllEmployees();
	                        System.out.println("\n Employee List:");
	                        for (Employee e : list) {
	                            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getEmail() + " | ₹" + e.getSalary());
	                        }
	                        break;
	                        
	                    case 3:
	                        System.out.print("Enter ID to Update: ");
	                        int idUpdate = sc.nextInt();
	                        sc.nextLine(); // clear buffer
	                        System.out.print("Enter New Name: ");
	                        String uName = sc.nextLine();
	                        System.out.print("Enter New Email: ");
	                        String uEmail = sc.nextLine();
	                        System.out.print("Enter New Salary: ");
	                        double uSalary = sc.nextDouble();

	                        dao.updateEmployee(new Employee(idUpdate, uName, uEmail, uSalary));
	                        System.out.println(" Employee Updated.");
	                        break;
	                        

	                    case 4:
	                        System.out.print("Enter ID to Delete: ");
	                        int idDel = sc.nextInt();
	                        dao.deleteEmployee(idDel);
	                        System.out.println(" Employee Deleted.");
	                        break;

	                    case 5:
	                        System.out.println(" Exiting... Thank you!");
	                        sc.close();
	                        System.exit(0);
	                        break;

	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	                
	            } catch (SQLException e) {
	                System.err.println(" Error: " + e.getMessage());
	            }
	        }
	            
	}
	
}
