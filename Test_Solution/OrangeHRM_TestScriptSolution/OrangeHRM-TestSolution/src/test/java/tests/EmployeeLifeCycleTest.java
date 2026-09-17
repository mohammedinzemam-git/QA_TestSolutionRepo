package tests;

import baseTest.BaseClass;
import model.EmployeeData;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;
import utils.JsonReader;

public class EmployeeLifeCycleTest extends BaseClass {

	@Test(retryAnalyzer = retry.RetryAnalyzer.class)
	public void employeeLifecycle() throws InterruptedException {

//		LoginPage loginPage =
//				new LoginPage(driver);
//
//		loginPage.login(
////				"Admin"
////				"admin123"
//				ConfigReader.getUsername(),
//				ConfigReader.getPassword()
//				);
//
//		DashboardPage dashboard =
//				new DashboardPage(driver);
//
//		Assert.assertTrue(
//				dashboard.dashboardVisible());
//
//		dashboard.navigateToAddEmployee();
//
//		AddEmployeePage employee =
//				new AddEmployeePage(driver);
//
//		employee.addNewEmployee();
//
//		Assert.assertTrue(
//				driver.getPageSource()
//				.contains("Personal Details"));
//
//		System.out.println(
//				"Employee Added Successfully");
		
		LoginPage loginPage =
		        new LoginPage(driver);

		loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

		DashboardPage dashboard =
		        new DashboardPage(driver);

		dashboard.navigateToAddEmployee();

		AddEmployeePage addEmployeePage =
		        new AddEmployeePage(driver);

		addEmployeePage.addNewEmployee();
		
		
//		EmployeeData employeeData = new EmployeeData();
		EmployeeData employeeData = JsonReader.getEmployeeData();
		
		String employeeId = employeeData.getEmployeeId();

		// Search Employee 

		EmployeeListPage employeeList =
		        new EmployeeListPage(driver);

		employeeList.searchEmployee(employeeId);

		
		employeeList.openEmployeeRecord();

		
		
		// Edit Employee 

		employeeList.updateJobDetails();

		// Back to Employee List 

		employeeList.navigateToEmployeeList();

		employeeList.searchEmployee(employeeId);

		// Delete Employee 

		employeeList.deleteEmployee();

		// Logout 

		dashboard.logout();
		
		
	}

}
