package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import model.EmployeeData;
import utils.ConfigReader;
import utils.JsonReader;
import utils.waitUtils;

public class EmployeeListPage {

	WebDriver driver;

	public EmployeeListPage(WebDriver driver){

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//span[text()='PIM']")
	WebElement pim;

	@FindBy(xpath="//a[text()='Employee List']")
	WebElement empList;

	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement employeeName;
	
	@FindBy(xpath="//label[text()='Employee Id']//parent::div//following-sibling::div/input")
	WebElement employeeID;

	@FindBy(xpath="//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath="//a[text()='Job']")
	WebElement jobTab;
	
	@FindBy(xpath="//label[text()='Job Title']//parent::div//following-sibling::div/div")
	WebElement jobTitleDropdown;
	
	@FindBy(xpath="//label[text()='Job Title']//parent::div//following-sibling::div//i")
	WebElement jobTitleDropdownClick;
	
	@FindBy(xpath="//label[text()='Employment Status']//parent::div//following-sibling::div/div")
	WebElement employmentStatusDropdown;
	
	@FindBy(xpath="//label[text()='Employment Status']//parent::div//following-sibling::div//i")
	WebElement empStatusDropdownClick;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath = "(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[2]")
	WebElement selectEmployeeCheckbox;

	@FindBy(xpath = "//button[contains(.,'Delete Selected')]")
	WebElement deleteButton;

	@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
	WebElement confirmDeleteButton;
	
	@FindBy(xpath = "(//div[@role='row']//div[@role='cell'])[3]")
	WebElement employeeRecord;
	
	@FindBy(xpath = "//span[normalize-space()='PIM']")
	private WebElement pimMenu;

	@FindBy(xpath = "//a[contains(text(),'Employee List')]")
	private WebElement employeeListMenu;
	
	@FindBy(xpath = "//p[text()='Successfully Deleted']")
	WebElement deletedToastMsg;
	
	@FindBy(xpath = "//p[text()='Successfully Updated']")
	WebElement updatedToastMsg;
	
	@FindBy(xpath = "//label[text()='Job Title']//parent::div//following-sibling::div//div[contains(@class,'text-input')]")
	WebElement jobTitleValidate;
	
	@FindBy(xpath = "//label[text()='Employment Status']//parent::div//following-sibling::div//div[contains(@class,'text-input')]")
	WebElement empStatusValidate;
	
	@FindBy(xpath = "//p[text()='No Records Found']")
	WebElement noUserToastMsg;
	
	EmployeeData employeeData = new EmployeeData();
	
	EmployeeData employeeDataJson = JsonReader.getEmployeeData();
	
	
	public void searchEmployee(String employeeId){

		waitUtils.waitForClickability(driver, pim);
		pim.click();

		waitUtils.waitForClickability(driver, empList);
		empList.click();

//		employeeName.sendKeys(name);
		waitUtils.waitForClickability(driver, employeeID);
		employeeID.sendKeys(employeeId);

		searchBtn.click();
	}
	
//	public void openEmployeeRecord(String employeeId) {
//
//	    String employeeXpath ="//div[contains(text(),'" + employeeId + "')]";
//
//	    WebElement employeeRecord =driver.findElement(By.xpath(employeeXpath));
//
//	    waitUtils.waitForClickability(driver, employeeRecord);
//
//	    employeeRecord.click();
//	}
	
	public void openEmployeeRecord() {

	    waitUtils.waitForClickability(driver, employeeRecord);

	    employeeRecord.click();
	}

	public void updateJobDetails() throws InterruptedException {

		waitUtils.waitForClickability(driver, jobTab);
		
		jobTab.click();
		
		Thread.sleep(Duration.ofSeconds(2));
		
		waitUtils.waitForClickability(driver, jobTitleDropdownClick);
		jobTitleDropdownClick.click();
		String jobTitle = employeeDataJson.getJobTitle();
		driver.findElement(By.xpath("//*[contains(text(),'"+jobTitle+"')]")).click();
		
		empStatusDropdownClick.click();

		String employeeStatus = employeeDataJson.getEmploymentStatus();
		driver.findElement(By.xpath("//*[contains(text(),'"+employeeStatus+"')]")).click();

//		List<WebElement> employmentStatuses = driver.findElements(
//		        By.xpath("//div[@role='listbox']//div[contains(@class,'option')]"));

//		for (WebElement status : employmentStatuses) {
//		    System.out.println(status.getText());
//		    String employeests = employeeData.getEmploymentStatus();
//		    if(status.getText().equalsIgnoreCase(employeests)) {
//		        status.click();
//		        break;
//		    }
//		}

		saveButton.click();
		
		waitUtils.waitForVisibility(driver, updatedToastMsg);
		Assert.assertEquals(updatedToastMsg.isDisplayed(), true);
		
		String updatedJobTitle = jobTitleValidate.getText();
		
		if(!updatedJobTitle.equals(jobTitle)) {
			Assert.fail("Job Title has not been updated, Actual job title is "+updatedJobTitle +" and expected title is "+jobTitle);
		}
		
		String updatedEmpStatus = empStatusValidate.getText();
		
		if(!updatedEmpStatus.equals(employeeStatus)) {
			Assert.fail("Employment Status has not been updated, Actual Status is "+updatedJobTitle +" and expected Status is "+jobTitle);
		}
		
		
	}
	
	public void deleteEmployee() throws InterruptedException {

	    waitUtils.waitForClickability(driver, selectEmployeeCheckbox);
	    selectEmployeeCheckbox.click();

	    waitUtils.waitForClickability(driver, deleteButton);
	    deleteButton.click();

	    waitUtils.waitForClickability(driver, confirmDeleteButton);
	    confirmDeleteButton.click();
	    
		waitUtils.waitForVisibility(driver, deletedToastMsg);
		Assert.assertEquals(deletedToastMsg.isDisplayed(), true);
		
		Thread.sleep(Duration.ofSeconds(2));
		searchBtn.click();
		
		waitUtils.waitForVisibility(driver, noUserToastMsg);
		Assert.assertEquals(noUserToastMsg.isDisplayed(), true);
		
		
	}
//	public void deleteEmployee(String employeeId) {
//
//	    String checkboxXpath =
//	            "//div[contains(text(),'" + employeeId +
//	            "')]/ancestor::div[@role='row']//span[contains(@class,'oxd-checkbox-input')]";
//
//	    WebElement selectEmployeeCheckbox =
//	            driver.findElement(By.xpath(checkboxXpath));
//
//	    WaitUtils.waitForClickability(driver, selectEmployeeCheckbox);
//	    selectEmployeeCheckbox.click();
//
//	    WaitUtils.waitForClickability(driver, deleteButton);
//	    deleteButton.click();
//
//	    WaitUtils.waitForClickability(driver, confirmDeleteButton);
//	    confirmDeleteButton.click();
//	}
	
	public void navigateToEmployeeList() {

		waitUtils.waitForClickability(driver, pimMenu);
	    pimMenu.click();
	    
	    waitUtils.waitForClickability(driver, employeeListMenu);
	    employeeListMenu.click();
	}

}
