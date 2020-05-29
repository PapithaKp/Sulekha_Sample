package Sample;

import java.awt.Frame;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFrames {

WebDriver driver;

		@Test

		public void setup() throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
			driver.get("http://www.way2automation.com/demo.html");
			driver.findElement(By.xpath("//h2[contains(text(),'Draggable')]")).click();
			Set<String> it = driver.getWindowHandles();
			Iterator<String> id = it.iterator();
			String parentid = id.next();
			String childid = id.next();
			driver.switchTo().window(childid);
		    Thread.sleep(5000);
			driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='username']")))
					.sendKeys("Pavitha");
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='password']")))
					.sendKeys("asdfg");
			driver.findElement(By.xpath("//div[@id='login']//input[@class='button']")).click();
		//Frame tab
			
			driver.navigate().refresh();
					driver.findElement(By.xpath("//div[@class='container main-nav']/ul[@id='toggleNav']/li[4]")).click();
				int framesize=driver.findElements(By.tagName("iframe")).size();
					System.out.println(framesize);
					//driver.findElement(By.xpath("//a[contains(text(),'New Browser Tab')]")).click();
				
				}	
	
		}
		
		



