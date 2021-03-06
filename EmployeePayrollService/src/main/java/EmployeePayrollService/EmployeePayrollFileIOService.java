package EmployeePayrollService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {

	public static final String PAYROLL_FILE = "employee-payroll-file.txt";

	/**
	 * @param employeeList writes the employee payroll data into the file
	 */
	public void writeData(List<EmployeePayroll> employeeList) {
		StringBuffer employeeBufferString = new StringBuffer();
		employeeList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			employeeBufferString.append(employeeDataString);
		});

		try {
			Files.write(Paths.get(PAYROLL_FILE), employeeBufferString.toString().getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return list of employees along with their details
	 */
	public List<EmployeePayroll> readData() {
		List<EmployeePayroll> employeeReadList = new ArrayList<EmployeePayroll>();
		try {
			Files.lines(Paths.get(PAYROLL_FILE)).map(line -> line.trim()).forEach(line -> {
				String[] data = line.split("[a-zA-Z]+ : ");
				int id = Character.getNumericValue(data[1].charAt(0));
				String name = data[2];
				double salary = Double.parseDouble(data[3]);
				EmployeePayroll employeeobject = new EmployeePayroll(id, name, salary);
				employeeReadList.add(employeeobject);
			});
		} catch (IOException e) {
		}
		return employeeReadList;
	}

	/**
	 * @return no of entries present in the file
	 */
	public long countEntries() {
		long countOfEntries = 0;
		try {
			countOfEntries = Files.lines(Paths.get(PAYROLL_FILE)).count();
		} catch (IOException e) {
		}
		return countOfEntries;
	}

	/**
	 * print all the employee pay roll data in console
	 */
	public void printEmployeePayrolls() {
		try {
			Files.lines(Paths.get(PAYROLL_FILE)).forEach(System.out::println);
		} catch (IOException e) {
		}
	}
}
