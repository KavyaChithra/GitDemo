package testngMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	By u = By.id("user_email");
	By p = By.id("user_password");
	By t = By.cssSelector("[type='submit']");
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement userName() {
		return driver.findElement(u);
	}
	public WebElement password() {
		return driver.findElement(p);
	}
	public WebElement submit() {
		return driver.findElement(t);
	}
}
