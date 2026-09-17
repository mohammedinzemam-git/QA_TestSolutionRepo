package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {

	//	public static ExtentReports getReport(){
	//
	//		ExtentReports extent =
	//				new ExtentReports();
	//
	//		return extent;
	//	}

	private static ExtentReports extent;

	public static ExtentReports getInstance(){

		if(extent==null){

			ExtentSparkReporter spark =
					new ExtentSparkReporter(
							"test-output/ExtentReport.html"
							);

			extent = new ExtentReports();

			extent.attachReporter(spark);
		}
		return extent;
	}

}
