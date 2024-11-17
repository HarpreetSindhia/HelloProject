package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAutomation {
	
	String productName = "Boult Newly Launched Q Over Ear Bluetooth Headphones with 70H Playtime, 40mm Bass Drivers, Zen™ ENC Mic, Type-C Fast Charging, 4 EQ Modes, Bluetooth 5.4, AUX Option, IPX5 Wireless Headphones (Black)";
	
	@Test
	public void automate()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("boult audio headphones");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='boult audio headphones wireless']")));
		driver.findElement(By.xpath("//div[@aria-label='boult audio headphones wireless']")).click();
		
		List<WebElement> allProducts =	driver.findElements(By.xpath("//div[@class='puisg-col-inner']//h2"));
		
		WebElement targetProduct =	allProducts.stream().filter(y -> y.findElement(By.xpath(".//span")).getText().equalsIgnoreCase(productName)).findFirst()
		.orElse(null);
		
		if(targetProduct!= null)
			
			targetProduct.findElement(By.xpath("//button[@class='a-button-text']")).click();
		
		//WebElement targetProduct1 =	driver.findElement(By.xpath("//a[@href='/Boult-Launched-Bluetooth-Headphones-Playtime/dp/B0DFHFH16K/ref=sr_1_3?crid=2DHGEVLDL8Q93&amp;dib=eyJ2IjoiMSJ9.9dHa-AbpJDknN2oexsBFu4QVnS6adBZ06PKKp3M2ywHr681RiVQ3X41gyW0irYHgIv-Y87gAMN5FqnbvVtX4G7INZcffVZDaYneikFpC52d7ChDGw3i_uFAt70-bAra4-1X3pvCggluAhHiFu0DdtHTLCrJSEbh52fOhJCyC-kEEj0ajrbh04CsVoj7RFe_QAzSXYY5anxfn_gQuoYo3KzlIk7Eu8pcGcLCIhN5j5nQ.YZavkucjJUWktAyCGdgqHTVpAK2PNSSCrMnK3xIYrRc&amp;dib_tag=se&amp;keywords=boult+audio+headphones+wireless&amp;nsdOptOutParam=true&amp;qid=1729345956&amp;sprefix=boult+audio+headphones%2Caps%2C225&amp;sr=8-3']"));
		//js.executeScript("arguments[0].scrollIntoView(true);", targetProduct );
		//js.executeScript("arguments[0].click();", targetProduct);
		//driver.findElement(By.xpath("//input[@name='submit.add-to-cart']")).click();
		//driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")).click();
				
		
		
		
		
		
		
	}

}
