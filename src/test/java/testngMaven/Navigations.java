package testngMaven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;

public class Navigations extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@Test(dataProvider="getData")
	public void navigationPage(String mailID, String pwd, String txt) throws IOException {
		driver =bowserinit();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		HomePage home = new HomePage(driver);
		LoginPage loginWith= home.login();
		log.info("Login link is clicked");
		loginWith.userName().sendKeys(mailID);
		loginWith.password().sendKeys(pwd);
		System.out.println(txt);
		loginWith.submit().click();
		log.info("Tried to login with credentials");
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] o = new Object[2][3];
		o[0][0]="KavyaChithra27@gmail.com";
		o[0][1]="Kavya@93";
		o[0][2]="Non-Restricted User";
		o[1][0]="yuyui27@gmail.com";
		o[1][1]="jjhhga@93";
		o[1][2]="Restricted User";
		return o;
	}
	@AfterMethod
	public void after() {
		driver.close();
	}
}
