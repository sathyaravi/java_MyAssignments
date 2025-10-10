package week2day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountUsingSelectClass {

	public static void main(String[] args) {
		
		//Instantiate and launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Log into the portal
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		
		//Create the account
		driver.findElement(By.partialLinkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("Test Group1");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester2");
		
		WebElement industryDropdown = driver.findElement(By.name("industryEnumId"));
        Select inddropdown = new Select(industryDropdown);
        inddropdown.selectByValue("IND_SOFTWARE");
        
        WebElement OwnershipDropdown = driver.findElement(By.name("ownershipEnumId"));
        Select ownership = new Select(OwnershipDropdown);
        ownership.selectByVisibleText("S-Corporation");
        
        
        
        WebElement sourceSelect= driver.findElement(By.id("dataSourceId"));
        Select sOwnership = new Select(sourceSelect);
        sOwnership.selectByValue("LEAD_EMPLOYEE");
        
		WebElement mCampaigndropdown = driver.findElement(By.id("marketingCampaignId"));
        Select marketingCamp = new Select(mCampaigndropdown);
        marketingCamp.selectByIndex(6);
        
        
        WebElement stateDropdown = driver.findElement(By.name("generalStateProvinceGeoId"));
        Select stdropdown = new Select(stateDropdown);
        stdropdown.selectByValue("TX");
        
        driver.findElement(By.className("smallSubmit")).click();
        
        String title = driver.getTitle();
		System.out.println("The title of the page:"+title);
        
		
        driver.quit();

	}

}
