package Sample;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestGeneral  extends Reports{

	@Test(threadPoolSize = 2,invocationCount = 4,timeOut = 5000)

	  public static void setup(){
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
	
	logger=extent.startTest("Login", "Try to ogin with the valid details");
	driver.findElement(By.name("name")).sendKeys("Pavitha");
	driver.findElement(By.name("phone")).sendKeys("6379431899");
	driver.findElement(By.name("email")).sendKeys("Pavithadr@gmail.com");
	WebElement county= driver.findElement(By.xpath("//select[@name='country']"));
	Select select= new Select(county);
	select.getOptions().contains("India");
	driver.findElement(By.name("city")).sendKeys("Chennai");
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='username']"))).sendKeys("Pavitha");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='password']"))).sendKeys("asdfg");
	driver.findElement(By.xpath("//div[@id='load_box']//input[@class='button']")).click();
	WebElement alert =driver.findElement(By.xpath("//div[@id='load_box']/form/p"));
	System.out.println(alert.getText());
	if (alert.isDisplayed()) {
		System.out.println("User is registered already");
		
	}else 
		System.out.println("check pls");
	
}
	
}