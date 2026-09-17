package listeners;

import org.testng.*;
import utils.*;

import com.aventstack.extentreports.*;

public class TestListener implements ITestListener {

	ExtentReports extent =
			ExtentManager.getInstance();

	ExtentTest test;

	@Override
	public void onTestStart(
			ITestResult result){

		test= extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result){
		test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result){
		test.fail(result.getThrowable());
		test.fail(result.getThrowable());
		String screenshotPath =
		ScreenShotScript.captureScreenshot(DriverFactory.driver,result.getName());
		try {
			test.addScreenCaptureFromPath(screenshotPath,"Failure Screenshot");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(
			ITestContext context){
		extent.flush();
	}

}
