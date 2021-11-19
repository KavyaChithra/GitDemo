package testngMaven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class ValidateNavigationBar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void browserInit() throws IOException {
		driver =bowserinit();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test
	public void validations() {
		
		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.interviewLink().isDisplayed());
		log.info("Validating if link is displayed");
	}
	@AfterTest
	public void after() {
		driver.close();
	}
}
