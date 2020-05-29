
package Com.Sulekha.listingPage;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import freemarker.core.ReturnInstruction.Return;

public class ListingUser {

	// static WebDriver driver;

	static String india_city = "chennai";

	static By Get_Qte = By.xpath("//div[@class='span9 listing-wrap']/ol/li[1]/div/div[3]/button[2]");

	static By Savemob = By.xpath("//div[@class='span9 listing-wrap']/ol/li[1]/div/div[3]/button[1]");

	static By listcount = By.xpath("//div[@class='span9 listing-wrap']/ol/li");

	static By Tnc = By.xpath("//a[@class='tnc'][1]//parent::div[@class='head']");

	static By imagesload = By.id("listingtabcontent");

	static By filter = By.xpath("//a[@class='input sd-link f-icon'][contains(text(),'Default')]");

	static By filter_Review = By.xpath("//div[@class='sd-menu']/ul/li/a[contains(text(),'Review')]");

	static By View_More = By.xpath("//a[@class='btn-t pagination loadlist']");

	static By filter_localities = By
			.xpath("//div[@class='filter']/ul/li/div[@class='filter-panel sa-panel']//ul[@id='ul-localities']/li");

	static By need_1 = By.xpath("//div[@class='sl-menu']/div/ul//li[contains(text(),'')]");

	static By India_LCF_City = By
			.xpath("//div[@class='ch-city lcfch-city sdropdown']//a[@class='input sd-link f-icon']");

	static By Savefone_form_mobile = By.id("txtMobile");
	static By Savefone_form_name = By.id("txtName");
	static By Savefone_form_email = By.id("txtEmail");
 static By Save_button=By.xpath("//button[@id='btnSavetoPhonePopup']");
 
 
	public static void Site_url(WebDriver driver) {

		String url = "https://www.sulekha.com/business-productivity-tools-training/chennai";
		driver.get(url);
	}

	// SAVE TO PHONE
	public static WebElement Save_to_mobile(WebDriver driver) {

		return driver.findElement(Savemob);

	}

//GET QUOTE 
	public static WebElement GetQuote(WebDriver driver) {
		return driver.findElement(Get_Qte);
	}

	public static WebElement filters(WebDriver driver) {
		return driver.findElement(filter);

	}

	public static WebElement Listing_View(WebDriver driver) {
		String loc_1 = driver.findElement(View_More).toString();

		return driver.findElement(View_More);

	}

	public static WebElement Filter_locality(WebDriver driver) {
		List<WebElement>loca=driver.findElements(By.xpath("//div[@class='filter-panel sa-panel']/ul/li"));
		WebElement loc=driver.findElement(By.xpath("//div[@class='filter-panel sa-panel']/ul/li"));
		for (int i=0;i<loca.size();i++) {
			if(loca.get(i).getText().contains("Adyar")) {
				loc.click();
				System.out.println(loca);
				break;
			}
			
		}
		
		return loc;
	}

	public static List<WebElement> LCF_selection(WebDriver driver) {
		List<WebElement> ggg = driver.findElements(By.xpath("//div[@class='sl-menu']/div/ul/li"));
		for (WebElement webele : ggg) {

			if (webele.getText().contains("Quickbook")) {
				webele.click();
				System.out.println("Newly added attribute is listed ");
			}
		}
		return ggg;
	}

	public static WebElement Indiapage_City_lcf(WebDriver driver) {

		driver.findElement(By.xpath("//div[@class='ch-city lcfch-city sdropdown']//a[@class='input sd-link f-icon']"))
				.click();
		WebElement LCF_filter_City = driver.findElement(By.xpath("//div[@class='results-wrap']/ul/li[3]"));
		String City_select = LCF_filter_City.getText();
		if (City_select.equalsIgnoreCase(india_city)) {
			LCF_filter_City.click();
			System.out.println("City section on LCF -INDIA PAGE - Selected Chennai");
		} else {
			System.out.println("Chennai City is not selected");
		}

		return LCF_filter_City;
	}

	public static WebElement SAVE_TO_FONE(WebDriver driver) {

		driver.findElement(Savefone_form_mobile).sendKeys("9380835000");
		driver.findElement(Savefone_form_name).sendKeys("Sulekha");
		driver.findElement(Savefone_form_email).sendKeys("ypteamsulekha@gmail.com");
		driver.findElement(Save_button).click();
		//Redireted to OTP Page 
		
		return null;
		
	}

}
