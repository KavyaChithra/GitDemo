package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public static WebDriver driver; //need to define it here for global scope
	public	Properties prop;// need to give public so that we can use it in other classes also 
	public WebDriver bowserinit() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\sudhe\\eclipse-workspace\\EndtoEndFramework\\src\\main\\java\\Resources\\mainInfo.properties");
		prop = new Properties();
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sudhe\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//instead of defining at each and every testcase, define here
		return driver;
	}
	
public String getScreenshotPath(String testCaseName,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
}
}
