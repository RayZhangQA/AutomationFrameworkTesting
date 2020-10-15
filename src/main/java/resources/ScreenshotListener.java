package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.Base;

public class ScreenshotListener implements ITestListener {

	public void onTestFailure(ITestResult result) {

		System.out.println(
				"****** Error " + result.getName() + " test has failed ******");

		String testCaseName = result.getInstanceName() + "." + result.getName();
		System.out.println("The failed method name is: " + result.getName());

		try {
			Base.getScreenshot(testCaseName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}