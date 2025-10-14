package week3day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AdvancedXpath {

	public static void main(String[] args) throws InterruptedException {
		
		//Instantiating and launching the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Log into the portal
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		
		//parent to child
		driver.findElement(By.xpath("//a/img")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		//Create the lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		
		//grand parent to grand child
		driver.findElement(By.xpath("//div[@class='fieldgroup-body']//input")).sendKeys("ABC CORP");
		
		//Elder to Younger cousin		
		driver.findElement(By.xpath("//span[text()='First name']/following :: input")).sendKeys("Ted");
		
		
		driver.findElement(By.xpath("//span[text()='Last name']/following :: input")).sendKeys("Lasso");
		
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Testing");
		
		
		
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Test Automation");
		
		
		driver.findElement(By.xpath("//span[text()='Important Note']/following :: textarea")).sendKeys("Test Automation - Advanced xpath");
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("Ted123@test.com");
		
		WebElement stateDropdown = driver.findElement(By.name("generalStateProvinceGeoId"));
        Select stdropdown = new Select(stateDropdown);
        stdropdown.selectByVisibleText("New York");
        
        
        
        driver.findElement(By.className("smallSubmit")).click();
        
      //Navigate to Lead tab
      		driver.findElement(By.linkText("Leads")).click();
      		driver.findElement(By.linkText("Find Leads")).click();
      		driver.findElement(By.xpath("//span[text()='Phone']")).click();
      		
      		
      		//Input the phone number to find the lead
      		
      		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("777");
      		
      		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
      		Thread.sleep(2000);
      		//Capture the first lead from the resulting lead
      		WebElement firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
      		String leadID = firstLead.getText();
      		System.out.println("First Lead from the resulting table:"+leadID);
      		
      		firstLead.click();
      		
      		//Delete the Lead
      		driver.findElement(By.xpath("//a[text()='Delete']")).click();
      		Thread.sleep(2000);
      		//Find the lead again
      		
      		driver.findElement(By.linkText("Find Leads")).click();
      		
      		//Enter the captured Lead
      		
      		driver.findElement(By.name("id")).sendKeys(leadID);
      		
      		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
      		Thread.sleep(2000);
      		
      		//Verify the deletion message
      		WebElement resultingText = driver.findElement(By.xpath("//div[@id='ext-gen437']"));
      		String message = resultingText.getText();
      		System.out.println("Result message: " + message);

      		if (message.equals("No records to display")) {
      		    System.out.println("Lead deleted Successfully");
      		} else {
      		    System.out.println("Lead still exists");
      		}
      		driver.quit();
        
	}

}
