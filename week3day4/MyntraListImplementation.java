package week3day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;

public class MyntraListImplementation {

	public static void main(String[] args) throws InterruptedException {
		
		
		//to avoid resource loading issues
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-http2");
		
		
		//Launch the browser
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		driver.get("https://www.myntra.com/");
		
	
		//Search for bags		
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Bags");
		driver.findElement(By.xpath("//a[@class='desktop-submit']/span")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@class='product-brand']")));
		
		//apply  the filters
		
		String searchurl = driver.getCurrentUrl();
		
		System.out.println("Current url:"+searchurl);
		
		String filterParams = "f=Gender%3Amen%2Cmen%20women%3A%3ACategories%3ALaptop%20Bag";
		
		String filteredUrl = searchurl.contains("?") ? (searchurl+"&"+filterParams):(searchurl+"?"+filterParams);
		
		driver.get(filteredUrl);
		
		
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[@class='product-brand']")));

	
		//Get the total count of the items

		String total_count=driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		
		System.out.println(total_count);
		
		
		//Display the List of products brand
		
		List<WebElement> brand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		
		List<String> productBrand = new ArrayList<String>();
		for(WebElement product:brand) {
			
			productBrand.add(product.getText());
		}
		
		System.out.println(productBrand);
		
		//Display the List of product names
		
		List<WebElement> prodctName = driver.findElements(By.xpath("//h4[@class='product-product']"));
		
		List<String> prodct = new ArrayList<String>();
		for(WebElement product:prodctName) {
			
			prodct.add(product.getText());
		}
		
		System.out.println(prodct);
		
		//driver.quit();

	}

}
