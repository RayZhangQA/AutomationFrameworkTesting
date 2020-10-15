package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {

	public WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By accountBtn = By.xpath("//a[@role='button']//child::img");
	public WebElement getAccountBtn() {
		return driver.findElement(accountBtn);
	}

	By signOutBtn = By.linkText("Sign out");
	public WebElement getSignOutBtn() {
		return driver.findElement(signOutBtn);
	}

	By logoutMessage = By.xpath("//h1[@jsname='r4nke']");
	public WebElement getLogoutMessage() {
		return driver.findElement(logoutMessage);
	}

}
