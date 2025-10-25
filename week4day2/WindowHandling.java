package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		

		//Initialize web driver
		ChromeDriver driver = new ChromeDriver(options);
		//Load the url
		driver.get("http://leaftaps.com/opentaps/");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Account creation
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdFrom']/following-sibling::a")).click();
		
        Set <String> childWindow = driver.getWindowHandles();
               
        List <String> newWindow = new ArrayList<String>(childWindow);
        

        
        driver.switchTo().window(newWindow.get(1));

     

     // --- Add an explicit wait to allow contact table to load ---
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstContact = wait.until(ExpectedConditions.elementToBeClickable(
         By.xpath("//a[@class='linktext']")));

        firstContact.click();
              
        driver.switchTo().window(newWindow.get(0));
        
        
      
        driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following-sibling::a")).click();
        
        Set <String> childWindow2 = driver.getWindowHandles();
        
        List <String> newWindow2 = new ArrayList<String>(childWindow2);
        
        
        driver.switchTo().window(newWindow2.get(newWindow2.size()-1));
        
        
        for (String w : driver.getWindowHandles()) {
            driver.switchTo().window(w);
            System.out.println("Window Title: " + driver.getTitle());
        }
       
       
        WebElement secondContact = wait.until(ExpectedConditions.elementToBeClickable(
         By.xpath("((//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])//a)[2]")));
        
        
        Thread.sleep(2000);
        secondContact.click();
        
        driver.switchTo().window(newWindow2.get(0));
        
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        
        // Accept the alert
        driver.switchTo().alert().accept();

        // Verify title
        String title = driver.getTitle();
        if (title.contains("View Contact")) {
            System.out.println("✅ Merge successful. Title verified: " + title);
        } else {
            System.out.println("❌ Merge failed. Current title: " + title);
        }

        driver.quit();
        

	}

}
