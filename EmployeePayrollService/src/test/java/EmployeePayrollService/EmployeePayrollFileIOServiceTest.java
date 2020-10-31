package EmployeePayrollService;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollFileIOServiceTest {

	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchNumberOfEmployeeEntries() {
		EmployeePayroll[] arrayOfEmployees = { new EmployeePayroll(1, "dhoni", 800000.0),
				new EmployeePayroll(2, "yuvraj", 850000.0),
				new EmployeePayroll(3, "ganguly", 900000.0) };
		EmployeePayrollFileIOService payrollServiceObject = new EmployeePayrollFileIOService();
		payrollServiceObject.writeData((ArrayList<EmployeePayroll>) Arrays.asList(arrayOfEmployees));
		Assert.assertEquals(3, payrollServiceObject.countEntries());
	}	
}
