package Sample;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.qdox.model.JavaExecutable;

public class Drag extends Reports {

	
		@Test(priority=0)

		  public static void setup() throws InterruptedException{

		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
		   driver.get("http://www.way2automation.com/demo.html");
		    logger=extent.startTest("Chromebrowser is iniatiated");
		   
	      
			driver.findElement(By.xpath("//h2[contains(text(),'Draggable')]")).click();
		logger=extent.startTest("Clicked Draggable content ");
			
		Set<String>it = driver.getWindowHandles();
		Iterator<String>id=it.iterator();
		String parentid=id.next();
		String childid=id.next();
		driver.switchTo().window(childid);
		logger=extent.startTest("Navigated to child page");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='username']"))).sendKeys("Pavitha");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='password']"))).sendKeys("asdfg");
		driver.findElement(By.xpath("//div[@id='login']//input[@class='button']")).click();
		}
		
		@Test(enabled=false)
		
		public static void draggable() {
			int i=1;
			System.out.println("Count total number of boxes from below page");
			List<WebElement>drag=driver.findElements(By.xpath("//div[@class='row']/div"));
			int count = drag.size();
			System.out.println(count);
			
			for (i=1;i<=drag.size();i++) {
				List<WebElement>drag2=driver.findElements(By.xpath("//div[@class='container margin-top-20']//div["+i+"]//ul[1]//li[1]//a[1]"));
				
				
			
				System.out.println(drag2);
				for (int j=1;j<=7;j++) {
					List<WebElement>drag3=driver.findElements(By.xpath("//div[@class='container margin-top-20']//div["+i+"]//ul[1]//li["+j+"]//a[1]"));
					
				}
				

		}
		}
		@Test(dependsOnMethods = "setup")
		public void registration() {
			driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			WebElement ret=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/form[1]/fieldset[9]/input[1]"));
			ret.click();
			ret.sendKeys("C:\\Users\\Papitha Venkatraman\\Downloads\\data.xlsx");
			
		}
}
