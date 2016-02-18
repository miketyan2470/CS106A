package Sections;
/**
 * The Employee class keeps track of the following data about employees; Name, Tax ID, title, annual salary, and 
 * whether or not employee is active. Information is kept private to this class and can only be accessed by 
 * methods provided.
 */
public class Employee {
	// Private instance variables.
	private String employeeName;
	private int taxIdNumber;
	private String jobTitle;
	private boolean isActive;
	private double annualSalary;
	/**
	 * Creates a new Employee object with following parameters.
	 * @param name Name of employee.
	 * @param taxID Tax ID of employee.
	 * @param title Title of employee.
	 * @param isActive Whether or not employee is active.
	 * @param salary Annual salary of employee.
	 */
	public Employee(String name, int taxID, String title, boolean isActive, double salary) {
		employeeName = name;
		taxIdNumber = taxID;
		jobTitle = title;
		this.isActive = isActive;
		annualSalary = salary;
	}
	/**
	 * Gets name of employee.
	 * @return The name of employee as String.
	 */
	public String getName() {
		return employeeName;
	}
	/**
	 * Gets tax ID of employee.
	 * @return The tax ID of employee as integer.
	 */
	public int getTaxId() {
		return taxIdNumber;
	}
	/**
	 * Gets the title of employee.
	 * @return The title of employee as String.
	 */
	public String getTitle() {
		return jobTitle;
	}
	/**
	 * Gets whether or not employee is active.
	 * @return Whether or not employee is active as boolean.
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * Gets annual salary of employee.
	 * @return The annual salary of employee as double.
	 */
	public double getSalary() {
		return annualSalary;
	}
	/**
	 * Sets the title of employee.
	 * @param title String title of employee.
	 */
	public void setTitle(String title) {
		jobTitle = title;
	}
	/**
	 * Sets whether or not employee is active.
	 * @param active Boolean active employee or not active employee.
	 */
	public void setActive(boolean active) {
		isActive = active;
	}
	/**
	 * Sets annual salary of employee.
	 * @param salary Double annual salary of employee.
	 */
	public void setSalary(double salary) {
		annualSalary = salary;
	}
	/**
	 * Creates a String to identify the employee.
	 * @return The String used to display employee information.
	 */
	public String toString() {
		String isActive;
		if (this.isActive) {
			isActive = "is active";
		} else {
			isActive = "is not active";
		}
		return employeeName + ": " + taxIdNumber + " " + isActive + " " + jobTitle + " with a annual salary of $" + annualSalary + ".";
	}
}
