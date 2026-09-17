package baseTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.DriverFactory;

	public class BaseClass {

	    public WebDriver driver;

	    @BeforeClass
	    public void setup() {

	        driver = DriverFactory.initializeDriver();

//	        driver.get("https://opensource-demo.orangehrmlive.com");
	        driver.get(ConfigReader.getUrl());
	    }

	    @AfterClass
	    public void tearDown() {

	        driver.quit();
	    }
	
}
