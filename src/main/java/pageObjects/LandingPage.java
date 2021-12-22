package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By login = By.cssSelector("a[href*='sign_in']");
	By text = By.cssSelector("div[class='text-center'] h2");
	By nav = By.cssSelector(".navbar-collapse.collapse");

	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getText() {
		return driver.findElement(text);
	}
	
	public WebElement getNav() {
		return driver.findElement(nav);
	}
}
