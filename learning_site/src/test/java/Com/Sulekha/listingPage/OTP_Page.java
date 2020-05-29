package Com.Sulekha.listingPage;


import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class OTP_Page {

	
	static String user_mob = "9380835000";

	@Test
	public static String otpscreen(WebDriver driver) throws InterruptedException {
		
			
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open();");
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> Parentid = ids.iterator();
		String Pid = Parentid.next();
		String Cid = Parentid.next();
		driver.switchTo().window(Cid);
		Thread.sleep(4000);
		driver.get("https://lsapi.sulekha.com/api/otp/get/" + user_mob);
		WebElement OTPPage = driver.findElement(By.cssSelector("html>body"));
		String otp = OTPPage.getText().replaceAll("[^0-9]", "");
		Thread.sleep(3000);
	driver.switchTo().window(Pid);
		System.out.println(otp);
		return otp;
	}
}