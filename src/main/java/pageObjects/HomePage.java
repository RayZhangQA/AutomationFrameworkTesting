package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By welcomeHome = By.xpath("//h1[@class='x7WrMb']");
	public WebElement getWelcomeHome() {
		return driver.findElement(welcomeHome);
	}

}
