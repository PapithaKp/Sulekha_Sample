package Sample;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {
	static ExtentReports extent;
	static ExtentTest logger;
	static WebDriver driver;

	@BeforeTest
	public ExtentReports startReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/listingpage.html");
		extent.addSystemInfo("Host Name", "SulekhaYP").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Papitha");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		return extent;
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		// String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

//	@AfterMethod
//	public static void getResult(ITestResult result) throws Exception {
//
//		String Screenshots = Reports.getScreenhot(driver, result.getName());
//		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.log(LogStatus.FAIL, "Script is getting failed ");
//			logger.log(LogStatus.INFO, logger.addScreenCapture(Screenshots));
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			logger.log(LogStatus.PASS, "Script is getting PASSED ");
//			logger.log(LogStatus.INFO, logger.addScreenCapture(Screenshots));
//		} else {
//			logger.log(LogStatus.SKIP, "Script is getting PASSED ");
//			logger.log(LogStatus.INFO, logger.addScreenCapture(Screenshots));
//		}
//	}
	
	@AfterMethod
	public static void getresult(ITestResult result) throws Exception {
		String Screenshots = Reports.getScreenhot(driver, result.getName());
		logger.addScreenCapture(Screenshots);
		logger.log(LogStatus.INFO, "tes1");
	}


	@AfterTest 
	public void teardown() {
		extent.flush();
	}

}