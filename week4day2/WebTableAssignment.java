package week4day2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebTableAssignment {

	public static void main(String[] args) {
		
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--guest");
				

				//Initialize web driver
				ChromeDriver driver = new ChromeDriver(options);
				//Load the url
				driver.get("https://finance.yahoo.com/");
				//Maximize the browser window
				driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

				
				driver.findElement(By.linkText("Markets")).click();
				driver.findElement(By.linkText("Crypto")).click();
				
				String pageTitle = driver.getTitle();
				System.out.println("Title of the page:"+pageTitle);
				
				List<WebElement> currencyName=driver.findElements(By.xpath("//div[contains(@class,'leftAlignHeader') and contains(@class,'companyName')]"));
				
				for(WebElement currency:currencyName) {
					
					System.out.println(currency.getText());
				}

	}

}
