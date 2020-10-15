package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import utilities.Base;

public class HomeValidation extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		// open google account login page
		Base.loginHome();
	}

	@Test
	public void homeValidations() {
		HomePage home = new HomePage(driver);
		// valid "username" and "password" will successfully log into homepage
		// Verify the visible message of "Welcome, automation test"
		Assert.assertEquals(home.getWelcomeHome().getText(),
				"Welcome, automation test");
	}

	@AfterMethod
	public void teardown() {

		Base.logoutHome();
		driver.close();
		driver = null;
	}

}
