package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By identifier = By.id("identifierId");
	public WebElement getIdentifier() {
		return driver.findElement(identifier);
	}

	By identifierNext = By.id("identifierNext");
	public WebElement getIdentifierNext() {
		return driver.findElement(identifierNext);
	}

	By identifierError = By.className("o6cuMc");
	// By identifierError = By.className("FailTheTestForScreenshotTest");
	public WebElement getIdentifierError() {
		return driver.findElement(identifierError);
	}

	By selectedAccount = By.xpath("//div[@id='profileIdentifier']");
	// By selectedAccount = By.className("KTeGk");
	public WebElement getSelectedAccount() {
		return driver.findElement(selectedAccount);
	}

	By password = By.name("password");
	public WebElement getPassword() {
		return driver.findElement(password);
	}

	By passwordNext = By.id("passwordNext");
	public WebElement getPasswordNext() {
		return driver.findElement(passwordNext);
	}

	By passwordError = By.xpath("//div[@jsname='B34EJ']//child::span");
	public WebElement getPasswordError() {
		return driver.findElement(passwordError);
	}

	By welcomeHome = By.xpath("//h1[@class='x7WrMb']");
	public WebElement getWelcomeHome() {
		return driver.findElement(welcomeHome);
	}
	// By forgetEmail = By.className(className)

}
