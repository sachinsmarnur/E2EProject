package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class validateNavigation extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(validateNavigation.class.getName());
	
	@Test
	public void validateAppNavBar() throws IOException {
		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertTrue(lp.getNav().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
