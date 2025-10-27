package week4day4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AmazonShopping {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		//to avoid resource loading issues
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-http2");
				
				
		//Launch the browser
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
				
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		        
		driver.get(" https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//Retrieve the first product price
		
		String firstProductprice=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		
		System.out.println("Price of the first product:"+firstProductprice);
		
		//Retrieve the rating of that product
		String ratings = driver.findElement(By.xpath("(//a[contains(@aria-label,'out of 5 stars')])[1]")).getDomAttribute("aria-label");
		String[] reviews = ratings.split(",");
		System.out.println("Ratings of the first product: " + reviews[0]);
		Thread.sleep(500);
		
		//Navigate to the first product page
		driver.findElement(By.xpath("(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]")).click();
		
		Set <String> newWindow = driver.getWindowHandles();
		
        List <String> childWindow = new ArrayList<String>(newWindow);
        
        
        driver.switchTo().window(childWindow.get(1));
        
        Thread.sleep(2000);
        
		//Save the screenshot
    	File ScreenShot = driver.getScreenshotAs(OutputType.FILE);
    	
    	File target = new File("./screenshot_files/amazonshoppingsample.png");
    	
    	FileUtils.copyFile(ScreenShot, target);
		
    	//Add to cart
    	WebElement sClick=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
    	
    	Actions act = new Actions(driver);
    	
    	act.scrollToElement(sClick).perform();
    	
    	
    	String cartSubtotal = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
    	
    	System.out.println("The Cart subtotal:"+cartSubtotal);
    	
    	
    	//Verify if the added product price is equal to the first retrieved product price
    	
    	if (firstProductprice.equals(cartSubtotal)) {
    		
    		System.out.println("the product added successfully to the cart");
    	}
    	else {
    		System.out.println("Error in adding the product to the cart");
    	}
    	driver.close();
    	
    	driver.quit();
		
				

	}

}
