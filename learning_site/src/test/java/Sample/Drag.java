package Sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.qdox.model.JavaExecutable;

public class Drag {

	WebDriver driver;

	@BeforeClass

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
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='username']")))
				.sendKeys("Pavitha");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']//input[@name='password']")))
				.sendKeys("asdfg");
		driver.findElement(By.xpath("//div[@id='login']//input[@class='button']")).click();
	}

	@Test
	public void drag() {
		//driver.get("http://way2automation.com/way2auto_jquery/draggable.php");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//h2[contains(text(),'Droppable')]")).click();
//		WebElement from=driver.findElement(By.id("draggable"));
//		WebElement T0=driver.findElement(By.id("droppable"));
 int size = driver.findElements(By.tagName("iframe")).size();
System.out.println(size);	
//driver.switchTo().frame(0);
//		Actions action = new Actions(driver);
//action.dragAndDrop(from,T0).build().perform();

	}
	@Test(enabled=false) 
		
		public  void draggable() {
			
			System.out.println("Count total number of boxes from below page");
			
			List<WebElement>drag=driver.findElements(By.xpath("//div[@class='row']/div"));
			
			for (int i=1;i<=drag.size();i++) {
				List<WebElement>drag2=driver.findElements(By.xpath("//div[@class='container margin-top-20']//div["+i+"]//ul[1]//li[1]//a[1]"));

				for (int j=1;j<=7;j++) {
					List<WebElement>drag3=driver.findElements(By.xpath("//div[@class='container margin-top-20']//div["+i+"]//ul[1]//li["+j+"]//a[1]"));
					Iterator<WebElement> itr = drag3.iterator();
					while(itr.hasNext()) {
					    System.out.println(itr.next().getText());
					}
				}
				}
			}
		
	@Test(enabled = false)
	public void registration() {
		driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
		WebElement de = driver
				.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/form[1]/fieldset[9]/input[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", de);
		WebDriverWait wb = new WebDriverWait(driver, 100);
		wb.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/form[1]/fieldset[9]/input[1]"))).click();

		// ret.sendKeys("C:\\Users\\Papitha Venkatraman\\Downloads\\data.xlsx");

	}
}
