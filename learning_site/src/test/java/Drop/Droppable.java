package Drop;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.thoughtworks.qdox.model.JavaExecutable;

public class Droppable {
 WebDriver driver;
	@Test
 public void set() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
		driver.get("https://letskodeit.teachable.com/p/practice");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement hover= driver.findElement(By.xpath("//button[@id='mousehover']"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(hover).perform();
		  WebElement hover_1= driver.findElement(By.xpath("//button[@id='mousehover']"));
		  actions.moveToElement(hover_1).build().perform();
	}
	}


