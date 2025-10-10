package week2day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLeadUsingXpath {

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
		driver.findElement(By.linkText("Leads")).click();
		
		//Create the Lead
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf12");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Stacy");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("William");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Stacy");
		
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automation");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("Stacy123@test.com");
		
		WebElement stateDropdown = driver.findElement(By.name("generalStateProvinceGeoId"));
        Select stdropdown = new Select(stateDropdown);
        stdropdown.selectByVisibleText("New York");
        
        driver.findElement(By.className("smallSubmit")).click();
        
        //Edit the lead
        
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
        
        driver.findElement(By.id("updateLeadForm_description")).clear();
        
        driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Lead Form updated newly");
        
        driver.findElement(By.className("smallSubmit")).click();
        
        String title = driver.getTitle();
        System.out.println("Lead updated successfully. Page title: " + title);
        
  
		
		driver.close();

	}

}
