package Com.Sulekha.listingPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.qdox.model.JavaExecutable;

public class TestListingPage extends ExtentReportnew {
	static int i;
	// static WebDriver driver;
	static String h1 = "Get contact details";
	// static JavascriptExecutor jse = (JavascriptExecutor) driver;

	@BeforeClass(alwaysRun = true)
	public static void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ListingUser.Site_url(driver);
		String actualTitle = driver.getTitle();
		logger = extent.startTest("SETUP");
		System.out.println(actualTitle);
	}

	@Test(priority = 1)
	public static void Get_Quote() throws IOException, InterruptedException {

		ListingUser.GetQuote(driver).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
			logger = extent.startTest("GET QUOTE");
	ListingUser.LCF_selection(driver);	
	
		}	

	@Test(priority = 2)
	public static void Save_To_Phone() throws InterruptedException, IOException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		ListingUser.Save_to_mobile(driver).click();
		String Save_1 = driver.findElement(By.xpath("//h4[contains(text(),'Get contact details')]")).getText();
		System.out.println(Save_1);
		logger = extent.startTest("SAVE TO PHONE");
		AssertJUnit.assertEquals(h1, Save_1);
	}

	@Test(priority = 3, alwaysRun = true)
	public static void Filter_listing() throws InterruptedException, IOException {
driver.navigate().refresh();
		driver.findElement(By.xpath("//div[@class='sort-by']/div/a")).click();
		
		WebElement rveiew_filter = driver
				.findElement(By.xpath("//div[@class='sd-menu']/ul/li/a[contains(text(),'Review')]"));
		rveiew_filter.click();
		System.out.println(rveiew_filter.getText());
		logger = extent.startTest("Clicked REVIEW option on droplist");
	}

	@Test(priority = 4, alwaysRun = true)
	public static void Listing_ViewMore() throws InterruptedException, IOException {
		driver.navigate().refresh();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
jse.executeScript("window.scrollBy(0,1000)");
		ListingUser.Listing_View(driver).click();
		Thread.sleep(5000);
		WebElement view = driver.findElement(By.xpath("//a[@class='btn-t pagination loadlist']"));
		if (view.isDisplayed()) {
			System.out.println("VIEW MORE FEATURE is working fine");
			logger = extent.startTest("VIEW_MORE - Link checking");
		} else {
			System.out.println("VIEW MORE FEATURE is  not working fine");
			logger = extent.startTest("VIEW_MORE - Link checking");
		}
	}

	@Test(priority = 5, alwaysRun = true)
	public static void Filter_locality() throws InterruptedException, IOException {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//div[@class='bankoffer active']/span")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(1000,0)");
		WebElement locality_downarrow = driver
				.findElement(By.xpath("//div[@class='filter']/ul/li//strong[contains(text(),'Locality')]"));

		if (locality_downarrow.isDisplayed()) {
			System.out.println("locality section is enabled in the category");
			logger = extent.startTest("Locality section - Visible in city page");
		} else {
			System.out.println("Locality section is not displaye");
			logger = extent.startTest("Locality section - Not-Visible in city page\"");
		}

	}
//	@Test(priority = 6)
//	public static void Save_To_Phones() throws InterruptedException, IOException {
//		driver.navigate().refresh();
//		Thread.sleep(4000);
//		ListingUser.Save_to_mobile(driver).click();
//		logger = extent.startTest("SAVE TO PHONE");
//		
//		// Form submission
//		ListingUser.SAVE_TO_FONE(driver);
//		driver.findElement(By.id("otp-1")).click();
//		driver.findElement(By.id("otp-1")).sendKeys(OTP_Page.otpscreen(driver));
//        logger=extent.startTest("Thank You screen");
//	}
//	@Test(priority=8 ,enabled = true)
//	public static void need_india_page() throws InterruptedException {
//
//		ListingUser.Indiapage_City_lcf(driver);
//		logger = extent.startTest("City section on LCF -INDIA PAGE");
//		
//}
//
//	@Test(priority = 7)
//	public static void filter_india_page() throws InterruptedException {
//		driver.navigate().refresh();
//		Thread.sleep(5000);
//		JavascriptExecutor js= (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1600)");
//		String city_filter_section = driver.findElement(By.xpath("//div[@class='filter']/ul/li[1]")).getText();
//		if (city_filter_section.contains("Chennai")) {
//			System.out.println("City option is displayed");
//			logger=extent.startTest(" Filter - City selection is enabled");
//		}else
//			System.out.println("Filter section , city selection is not displayed");
//	}
	@AfterMethod
	public void endReport() {
		extent.flush();

	}

}