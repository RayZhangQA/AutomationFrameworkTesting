package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) { // setup Chrome WebDriver
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			options.setExperimentalOption("excludeSwitches",
					Arrays.asList("disable-popup-blocking"));
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) { // setup Firefox WebDriver
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) { // setup IE WebDriver
			driver = new InternetExplorerDriver();
		}

		// Add implicit wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void getScreenshot(String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss")
				.format(new Date());
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String scrFileName = System.getProperty("user.dir") + "\\Screenshots\\"
				+ testCaseName + "_" + timestamp + ".png";
		FileUtils.copyFile(scrFile, new File(scrFileName));
		System.out.println("The screenshot of failed testcase has stored as "
				+ scrFileName);
	}

	public static void loginHome() {
		LoginPage login = new LoginPage(driver);
		login.getIdentifier().sendKeys(prop.getProperty("username"));
		// Login by using the "Username" defined in dataProvider-"getUsername"
		login.getIdentifierNext().click();

		// Using Explicit Wait for waiting "password" enter box to be visible
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(login.getPassword()));

		// Login by using the "password" defined in dataProvider-"getPassword"
		login.getPassword().sendKeys(prop.getProperty("password"));
		login.getPasswordNext().click();
	}

	public static void logoutHome() {
		LogoutPage logout = new LogoutPage(driver);
		logout.getAccountBtn().click();
		// click "account" button to get the "sign out" button
		logout.getSignOutBtn().click();
		// click "sign out" button will logout the account
	}

}
