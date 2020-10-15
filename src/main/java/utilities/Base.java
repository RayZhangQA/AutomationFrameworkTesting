package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;

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
}
