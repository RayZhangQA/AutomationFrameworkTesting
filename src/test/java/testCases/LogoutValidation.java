package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import utilities.Base;

public class LogoutValidation extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		// open google account login page
	}

	@Test
	public void logoutValidation() {
		LoginPage login = new LoginPage(driver);
		login.getIdentifier().sendKeys(prop.getProperty("username"));
		// Login by using the "username" defined in data.properties file
		login.getIdentifierNext().click();

		login.getPassword().sendKeys(prop.getProperty("password"));
		// Login by using the "password" defined in data.properties file
		login.getPasswordNext().click();

		// valid "username" and "password" should successfully logged into
		// homepage
		// successful login should see the message of "Welcom, automation test"
		Assert.assertEquals(login.getWelcomeHome().getText(),
				"Welcome, automation test");

		LogoutPage logout = new LogoutPage(driver);
		logout.getAccountBtn().click(); // click "account" button to get the
										// "sign out" button
		logout.getSignOutBtn().click(); // click "sign out" button will logout
										// the account
		Assert.assertEquals(logout.getLogoutMessage().getText(),
				"Choose an account");
		// After logout the message of "Choose an account" should show up.
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
