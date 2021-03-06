package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LogoutPage;
import utilities.Base;

public class LogoutValidation extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		// open google account login page

		Base.loginHome();
	}

	@Test
	public void logoutValidation() {

		LogoutPage logout = new LogoutPage(driver);
		logout.getAccountBtn().click(); // click "account" button to get the
										// "sign out" button
		logout.getSignOutBtn().click(); // click "sign out" button will logout
										// the account
		Assert.assertEquals(logout.getLogoutMessage().getText(),
				"Choose an account");
		// After logout the message of "Choose an account" should show up.
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver = null;
	}
}
