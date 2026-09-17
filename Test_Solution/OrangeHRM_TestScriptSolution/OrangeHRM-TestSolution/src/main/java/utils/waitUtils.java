package utils;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

public class waitUtils {

	public static void waitForVisibility(WebDriver driver,WebElement element){

		WebDriverWait wait =
				new WebDriverWait(driver,Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForClickability(
			WebDriver driver,
			WebElement element){

		WebDriverWait wait =
				new WebDriverWait(driver,Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
