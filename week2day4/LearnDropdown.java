package week2day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("John");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Doe");
		
		WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
        Select dataSource = new Select(dropdown);
        dataSource.selectByIndex(4);
        
        
        WebElement marketingDropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
        Select marketing = new Select(marketingDropdown);
        marketing.selectByVisibleText("Automobile");
        
        
        WebElement OwnershipDropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
        Select ownership = new Select(OwnershipDropdown);
        ownership.selectByValue("OWN_CCORP");
        
        driver.findElement(By.className("smallSubmit")).click();
        
        String title = driver.getTitle();
		System.out.println("The title of the page:"+title);
        
		
		

	}


	}


