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

public class AssetValidations extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(AssetValidations.class.getName());
	@BeforeTest
	public void browserInit() throws IOException {
		driver =bowserinit();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test
	public void validations() {
		
		HomePage home = new HomePage(driver);
		Assert.assertEquals(home.textCenter().getText(),"Featured COurce");
		log.info("Validating text");
	}
	@AfterTest
	public void after() {
		driver.close();
	}
}
