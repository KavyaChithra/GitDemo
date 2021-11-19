package testngMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	By lg = By.cssSelector("[href*='sign_in']");
	By tx = By.cssSelector("#content .text-center");
	By lnk = By.xpath("//*[text()='Interview Guide']");
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage login() {
		driver.findElement(lg).click();
		return new LoginPage(driver);
	}
	public WebElement textCenter() {
		return driver.findElement(tx);
	}
	public WebElement interviewLink() {
		return driver.findElement(lnk);
	}
}
