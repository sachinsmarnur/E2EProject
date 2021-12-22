package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage lo = new LoginPage(driver);
		lo.getEmail().sendKeys(username);
		lo.getPass().sendKeys(password);
		log.info(text);
		lo.login().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		//row stands for how many different data types should run
		//column stands for how many values per each test
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0] = "abc@gmailcom";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		//1st row
		data[1][0] = "xyz@gmail.com";
		data[1][1] = "abcdef";
		data[1][2] = "Non Restricted User";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
