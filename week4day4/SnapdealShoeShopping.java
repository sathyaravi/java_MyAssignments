package week4day4.homework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapdealShoeShopping {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		
		//Mouse hover category to get sub categories
		WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(element).perform();
		
		driver.findElement(By.xpath("(//a[contains(@href,'sports-shoes')])[1]")).click();
		
		//Get the total count of  items and convert it into integer value
		
		String shoesCount = driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes')]//following-sibling::span")).getText();
		
		String  sportsShoes = shoesCount.replaceAll("[^0-9]","");
		
		System.out.println("Count of Sports shoes:"+Integer.parseInt(sportsShoes));
		
		//Choose Training shoes category
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']/parent::a")).click();
		
		//Sort the products low to high
		
		WebElement sortByLabel = driver.findElement(By.xpath("//span[contains(., 'Sort by')]"));
		sortByLabel.click();

		
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		Thread.sleep(2000);
		
		//To check if the items are sorted correctly
		
		

		List <WebElement> shoePrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List <Integer> priceList = new ArrayList<Integer>();
		
		for (WebElement price:shoePrice) {
			
			String txt = price.getText().replaceAll("[^0-9]","").trim();
			
			int price1  = Integer.parseInt(txt);
			
			priceList.add(price1);
			
		}
		
		System.out.println(priceList);
		
		boolean sorted = true;
		
		for(int i=0;i<priceList.size()-1;i++) {
					
			if(priceList.get(i)>priceList.get(i+1)) {
				
				sorted = false;
				break;
				
			}
		}
		
		if(sorted) {
			System.out.println("Sorted correctly : From low to high");
		}
		else {
			System.out.println("Not sorted properly");
		}
		
		//Selecting the price range
		
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("360");
		
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1020");
		
		
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn' )]")).click();
		
		Thread.sleep(2000);
		
		//choose the color
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		WebElement colorFilter = driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']"));
		
		act.scrollToElement(colorFilter).perform();
		
		Thread.sleep(3000);
		
		colorFilter.click();
		
		
		Thread.sleep(1000);
		
		
		//Verify all the price filters applied correctly
		List <WebElement> shoePriceVerify = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		
		for(int i=0;i<shoePriceVerify.size()-1;i++) {
			
			String price = shoePriceVerify.get(i).getText().replaceAll("[^0-9]","").trim();
			
			if((Integer.parseInt(price)>=360) && (Integer.parseInt(price)<=1020)) {
				
				System.out.println("Price Filters applied successfully ");
				
			}
			
			
		}
		//verify the color filter applied correctly
		
		List <WebElement> colorFilterVerify = driver.findElements(By.xpath("//p[@class='product-title']"));
		 	
		for(int i=0;i<colorFilterVerify.size()-1;i++) {
		 		
		 		String color = colorFilterVerify.get(i).getText().toLowerCase();
		 		
		 		if(color.contains("white") || color.contains("blue")) {
		 			
		 			System.out.println("Color Filters applied successfully");
		 		}
		 		
		 	}
			
		
		
		
		//Navigate to product
		
		WebElement productImage = driver.findElement(By.xpath("//img[@title='RICKENBAC Blue Training Shoes']"));

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
	    
    	File ScreenShot2 = driver.getScreenshotAs(OutputType.FILE);
    	
    	File target = new File("./screenshot_files/snapdealshoesample.png");
    	
    	FileUtils.copyFile(ScreenShot2, target);

		driver.close();
	
	}

}
