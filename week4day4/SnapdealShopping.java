package week4day4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
public class SnapdealShopping {

	public static void main(String[] args) throws IOException {
		
		
		//to avoid resource loading issues
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-http2");
						
						
		//Launch the browser
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
						
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
				        
		driver.get("https://www.snapdeal.com/");
		
		
				
		WebElement mouseHover = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
				
		Actions act = new Actions(driver);
				
		act.moveToElement(mouseHover).perform(); 
		
		
		driver.findElement(By.xpath("(//a[contains(@class,'rightMenuLink')]//span[text()='Sports Shoes'])[1]")).click();
		
		
		// Capture the count of sports shoes
		String countText = driver.findElement(By.xpath("//span[contains(@class, 'category-count')]")).getText();

		// Extract only the number using regex
		String totalCount = countText.replaceAll("[^0-9]", "");
		System.out.println("Total count: " + totalCount);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']/parent::a")).click();
		
		// Click the "Sort by" label first
		WebElement sortByLabel = driver.findElement(By.xpath("//span[contains(., 'Sort by')]"));
		sortByLabel.click();

		// Then wait for and click "Price Low To High"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		WebElement priceLowToHigh = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//li[@data-sorttype='plth']")
		));
		priceLowToHigh.click();;
		
		//get the first product price
		
		String firstProductprice = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]")).getText();
		
		String fprice =  firstProductprice.replaceAll("[^0-9]", "");
		
		int product1 = Integer.parseInt(fprice);
		

		//get the second product price
		
	
		String secondProductprice = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]")).getText();
		
		String sprice =  secondProductprice.replaceAll("[^0-9]", "");
		
		int product2 = Integer.parseInt(sprice);
		
		if (product1<product2) {
			
			System.out.println("Items sorted correctly");
			
		}
		
		//Applying the Price filter
		
		WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='fromVal']")));

		fromInput.click(); // Focus the field
		fromInput.clear(); // Clear existing text
		fromInput.sendKeys("370", Keys.ENTER);
		
		
		WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='toVal']")));

		toInput.click();  // Focus the field
		toInput.clear(); // Clear existing text
		toInput.sendKeys("800", Keys.ENTER);
						
		
		WebElement productImage = driver.findElement(By.xpath("//img[@title='RICKENBAC Gray Training Shoes']"));

		act.moveToElement(productImage).perform();

		//View the product using quick view button

		WebElement quickViewBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'quick-view-bar')]")));

		quickViewBtn.click();
		
  
        
		// Wait for the Quick View modal to appear 
		WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='payBlkBig']")));

		String productPrice = priceElement.getText();
		String pPrice = productPrice.replaceAll("[^0-9]", "");
		System.out.println("Product Price: " + pPrice);

		String productDiscount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		String pDis = productDiscount.replaceAll("[^0-9]", "");
		System.out.println("Product Discount: " + pDis);
	    
    	File ScreenShot1 = driver.getScreenshotAs(OutputType.FILE);
    	
    	File target = new File("./screenshot_files/snapdealsample.png");
    	
    	FileUtils.copyFile(ScreenShot1, target);

		driver.close();

	}

}
