package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import utils.waitUtils;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver){

		this.driver = driver;

		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboard;

	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimMenu;

	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement addEmployee;
	
	@FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
	private WebElement userDropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLink;


	public boolean dashboardVisible(){
		waitUtils.waitForVisibility(driver, pimMenu);

		return dashboard.isDisplayed();
	}

	public void navigateToAddEmployee(){
		waitUtils.waitForClickability(driver, pimMenu);
		pimMenu.click();
		waitUtils.waitForClickability(driver, addEmployee);
		addEmployee.click();
	}
	
	public void logout() {

	    waitUtils.waitForClickability(driver, userDropdown);
	    userDropdown.click();

	    waitUtils.waitForClickability(driver, logoutLink);
	    logoutLink.click();
	}


}
