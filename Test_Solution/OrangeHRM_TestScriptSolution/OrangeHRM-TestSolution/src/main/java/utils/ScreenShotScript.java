package utils;

//	public static void captureScreenshot(
//			WebDriver driver, String name) {
//
//		File src = ((TakesScreenshot)driver)
//				.getScreenshotAs(OutputType.FILE);
//
//	}


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenShotScript {
	
	public static String captureScreenshot(
	        WebDriver driver,
	        String screenshotName) {

	    File source =
	            ((TakesScreenshot) driver)
	                    .getScreenshotAs(OutputType.FILE);

	    String folderPath =
	            System.getProperty("user.dir")
	                    + "/screenshots/";

	    File directory = new File(folderPath);

	    if (!directory.exists()) {
	        directory.mkdirs();
	    }

	    String destination =
	            folderPath + screenshotName + ".png";

	    try {

	        FileUtils.copyFile(
	                source,
	                new File(destination));

	    } catch (IOException e) {

	        e.printStackTrace();
	    }

	    return destination;
	}

//	public static String captureScreenshot(
//			WebDriver driver,
//			String screenshotName){
//
//		File source =
//				((TakesScreenshot)driver)
//				.getScreenshotAs(OutputType.FILE);
//
//		String destination =
//				System.getProperty("user.dir")
//				+"/screenshots/"
//				+screenshotName+".png";
//
//		try {
//
//			FileUtils.copyFile(
//					source,
//					new File(destination));
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		return destination;
//	}

}
