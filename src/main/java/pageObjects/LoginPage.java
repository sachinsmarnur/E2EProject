package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.cssSelector(".form-control.input-hg");
	By pass = By.id("user_password");
	By login = By.xpath("//input[@value='Log In']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPass() {
		return driver.findElement(pass);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	}
}
