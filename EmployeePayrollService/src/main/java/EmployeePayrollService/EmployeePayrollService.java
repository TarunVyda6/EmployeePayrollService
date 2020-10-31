package EmployeePayrollService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tarun vyda
 *
 */
public class EmployeePayrollService {

	private ArrayList<EmployeePayroll> employeePayrollList;

	public EmployeePayrollService(ArrayList<EmployeePayroll> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/**
	 * @param consoleInputReader : Read the user information from console
	 */
	private void readEmployeePayroll(Scanner consoleInputReader) {
		System.out.print("Enter Employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.print("Enter Employee Name: ");
		consoleInputReader.nextLine();
		String name = consoleInputReader.nextLine();
		System.out.print("Enter Employee Salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayroll(id, name, salary));
	}

	/**
	 * prints the data in console
	 */
	private void writeEmployeePayroll() {
		System.out.println("\nWriting Employee Payroll Data to Console\n" + employeePayrollList);
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayroll(consoleInputReader);
		employeePayrollService.writeEmployeePayroll();

	}

}
