package Framework;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());
	
	@Test
	public void validateAppTitle() throws IOException {
		driver = launchBrowser();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertEquals(lp.getText().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
