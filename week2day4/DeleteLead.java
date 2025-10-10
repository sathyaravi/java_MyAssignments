package week2day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		//Instantiate and Launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		ChromeDriver driver = new ChromeDriver(options);
		//maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Log in to the portal
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
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
