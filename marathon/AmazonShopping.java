package marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonShopping {

	public static void main(String[] args) throws InterruptedException {
		//to avoid resource loading issues
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-http2");
		
		
		//Launch the browser
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        
        

		driver.get(" https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys",Keys.ENTER);
		
		String totalNumber = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']/span")).getText();
		
		System.out.println("Total Number of bags:"+totalNumber);
		
		Thread.sleep(1000);
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Safari']"))).click();


		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='American Tourister']"))).click();
		// Click the "Sort by" dropdown
		WebElement sortDropdown = wait.until(ExpectedConditions.elementToBeClickable(
		    By.id("a-autoid-0-announce")
		));
		sortDropdown.click();

		// Click "Newest Arrivals" from dropdown
		WebElement newestArrivals = wait.until(ExpectedConditions.elementToBeClickable(
		    By.id("s-result-sort-select_4")
		));
		newestArrivals.click();
		
		driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']")).click();
		
		Set <String> childWindow = driver.getWindowHandles();
        
        List <String> newWindow = new ArrayList<String>(childWindow);
        
       
        driver.switchTo().window(newWindow.get(1));

        
        String productTitle = driver.findElement(By.id("productTitle")).getText();
        
        System.out.println(productTitle);
        
        String totalPrice = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
        
        
        System.out.println("Total Price of the bag:"+totalPrice);
        
        
      
        String discountPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
        
        
        System.out.println("Discounted Price of the bag:"+discountPrice);
        
        driver.close();
        
        
        
        

	}

}
