package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import utils.waitUtils;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver,this);
	}

	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;

	public void login(String user,String pass){
		waitUtils.waitForClickability(driver, loginButton);

		username.sendKeys(user);
		password.sendKeys(pass);

		loginButton.click();
	}

}
