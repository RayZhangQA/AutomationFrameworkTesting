package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.Base;

public class LoginValidation extends Base {

	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		// open google account login page
	}

	@Test(dataProvider = "getUsername")
	public void usernameValidations(String Username, String identifierMessage)
			throws InterruptedException, IOException {

		LoginPage login = new LoginPage(driver);
		login.getIdentifier().sendKeys(Username);
		// Login by using the "Username" defined in dataProvider-"getUsername"
		login.getIdentifierNext().click();
		Thread.sleep(2000);

		// if the "Username" is invalid
		// Validate whether the error message equals the expected value
		if (!Username.equals(prop.getProperty("username"))) {
			System.out.println(login.getIdentifierError().getText());
			Assert.assertEquals(login.getIdentifierError().getText(),
					identifierMessage);
		} else { // if the "Username" is valid, will show the selected user
					// account
			System.out.println("the selected account is: "
					+ login.getSelectedAccount().getText());
			System.out.println(identifierMessage);
			Assert.assertEquals(login.getSelectedAccount().getText(),
					identifierMessage);
		}
	}

	@Test(dataProvider = "getPassword")
	public void passwordValidations(String Password, String pwdMessage)
			throws InterruptedException, IOException {

		// Login with valid "username" defined in data.properties file
		LoginPage login = new LoginPage(driver);
		login.getIdentifier().sendKeys(prop.getProperty("username"));
		login.getIdentifierNext().click();

		// Login by using the "password" defined in dataProvider-"getPassword"
		login.getPassword().sendKeys(Password);
		login.getPasswordNext().click();

		// if the "Password" is invalid
		// Validate whether the error message equals the expected value
		if (!Password.equals(prop.getProperty("password"))) {
			System.out.println(
					"The error message: " + login.getPasswordError().getText());
			Assert.assertEquals(login.getPasswordError().getText(), pwdMessage);
		} else { // if the "Password" is valid, will login to Welcome Home page
			System.out.println(login.getWelcomeHome().getText());
			Assert.assertEquals(login.getWelcomeHome().getText(), pwdMessage);
		}
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

	// parameterizing the test data
	@DataProvider
	public Object[][] getUsername() {
		Object[][] data = new Object[7][2];

		data[0][0] = "automation558@gmail.com";
		data[0][1] = "automation558@gmail.com";

		data[1][0] = "automation559@gmail.com";
		data[1][1] = "Couldn't find your Google Account";

		data[2][0] = "6472999999";
		data[2][1] = "Couldn't find your Google Account. Try using your email address instead.";

		data[3][0] = "cccccdddddlllll";
		data[3][1] = "Couldn't find your Google Account";

		data[4][0] = "";
		data[4][1] = "Enter an email or phone number";

		data[5][0] = " ";
		data[5][1] = "Enter an email or phone number";

		data[6][0] = "!!!!!@@@@@";
		data[6][1] = "Enter a valid email or phone number";

		return data;
	}

	@DataProvider
	public Object[][] getPassword() {
		Object[][] data = new Object[5][2];

		data[0][0] = "Appium@558";
		data[0][1] = "Welcome, automation test";

		data[1][0] = "";
		data[1][1] = "Enter a password";

		data[2][0] = " ";
		data[2][1] = "Enter your password";

		data[3][0] = "cccccdddddlllll";
		data[3][1] = "Wrong password. Try again or click Forgot password to reset it.";

		data[4][0] = "appium@558";
		data[4][1] = "Wrong password. Try again or click Forgot password to reset it.";

		return data;
	}

}
