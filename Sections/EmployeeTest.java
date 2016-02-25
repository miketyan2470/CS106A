package Sections;

import acm.program.*;
/**
 * File : EmployeeTest.java
 * ------------------------
 * Console program tests class Employee by constructing three test Employees.
 * -Getter and Setter methods tested.
 */
public class EmployeeTest extends ConsoleProgram {
	// Private constants for employee profiles.
	private Employee EScrooge = new Employee("Ebenezer Scrooge", 161803399, "CEO", true, 1000.00);
	private Employee JMarley = new Employee("Jacob Marley", 271828182, "Former Partner", false, 0.00);
	private Employee BCratchit = new Employee("Bob Cratchit", 314159265, "Clerk", true, 25.00);
	/**
	 * Runs the program EmployeeTest.
	 * -Calls different methods to test the class Employee.
	 */
	public void run() {
		println(BCratchit.getSalary());
		BCratchit.setSalary(500.00);
		println(BCratchit);
		println(JMarley.getName() + " " + JMarley.getTitle() + " " + JMarley.isActive());
		JMarley.setActive(true);
		JMarley.setTitle("Partner");
		JMarley.setSalary(1000.00);
		println(JMarley);
		println(EScrooge);
	}
}