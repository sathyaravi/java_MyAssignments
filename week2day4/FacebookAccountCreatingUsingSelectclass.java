package week2day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookAccountCreatingUsingSelectclass {

	public static void main(String[] args) {
		//Launch the browser
	 	ChromeDriver driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        
        //Open the registration form and fill in the details
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Stacy12tlf");
        driver.findElement(By.name("lastname")).sendKeys("Doe");
        driver.findElement(By.name("reg_email__")).sendKeys("0123456789");
        driver.findElement(By.name("reg_passwd__")).sendKeys("abcdefg@123");
        WebElement bdate = driver.findElement(By.id("day"));
        Select birthDate = new Select(bdate);
        birthDate.selectByValue("8");
        
        WebElement bmonth = driver.findElement(By.id("month"));
        Select birthMonth = new Select(bmonth);
        birthMonth.selectByValue("8");
        
        WebElement bYear = driver.findElement(By.id("year"));
        Select birthYear = new Select(bYear);
        birthYear.selectByValue("1980");

        
        driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
        
        

        

	}

}
