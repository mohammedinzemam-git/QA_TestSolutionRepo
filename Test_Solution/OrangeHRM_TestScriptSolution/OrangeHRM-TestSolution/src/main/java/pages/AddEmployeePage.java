package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import model.EmployeeData;
import utils.JsonReader;
import utils.waitUtils;

public class AddEmployeePage {

	WebDriver driver;

	public AddEmployeePage(WebDriver driver){

		this.driver = driver;

		PageFactory.initElements(driver,this);
	}

	@FindBy(name="firstName")
	WebElement firstName;

	@FindBy(name="lastName")
	WebElement lastName;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement empId;

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//p[text()='Successfully Saved']")
	WebElement savedToastMsg;
	
	public String generatedEmpId;

	public void addNewEmployee(){

//		generatedEmpId =
//				String.valueOf(System.currentTimeMillis());

		waitUtils.waitForVisibility(driver, empId);
		
		EmployeeData employee =
		        JsonReader.getEmployeeData();

		firstName.sendKeys(employee.getFirstName());

		lastName.sendKeys(employee.getLastName());

//		empId.clear();
//		Actions action = new Actions(driver);
//		action.keyDown(empId, Keys.CONTROL).sendKeys("a").build().perform();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value = '';", empId);
		
		empId.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE),employee.getEmployeeId());
		;

//		empId.sendKeys(employee.getEmployeeId());

		waitUtils.waitForClickability(driver, saveBtn);
		
		saveBtn.click();
		
		waitUtils.waitForVisibility(driver, savedToastMsg);
		Assert.assertEquals(savedToastMsg.isDisplayed(), true);
		
	}

}
