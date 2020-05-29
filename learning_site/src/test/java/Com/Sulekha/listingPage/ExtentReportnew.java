package Com.Sulekha.listingPage;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportnew {
	static ExtentReports extent;
	static ExtentTest logger;
	static WebDriver driver;
	

	@BeforeTest
	public ExtentReports startReport() {
		
		extent = new ExtentReports
				(System.getProperty("user.dir") + "/test-output/listingpage.html");
		extent
		.addSystemInfo("Host Name", "SulekhaYP")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "Papitha");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		return extent;
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName 
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	public static void getResult(ITestResult result) throws Exception {
		String screenshotPath = ExtentReportnew.getScreenhot(driver, result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			Thread.sleep(1000);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case Skipped is " + result.getName());
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
	}
		else {
			logger.log(LogStatus.PASS, "Test Case Skipped is " + result.getName());
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		}
	}
	
	@AfterTest
	public void teardown() {
		extent.flush();
	}

}