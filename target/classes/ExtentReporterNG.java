package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	

	static ExtentReports extent;
	public static ExtentReports getReportObjects() {
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Wweb Automation Selenium");
	reporter.config().setDocumentTitle("Test Extent Results");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Kavya Chithra");
	return extent;
	}
}
