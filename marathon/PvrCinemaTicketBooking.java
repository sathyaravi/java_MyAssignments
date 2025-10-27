package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PvrCinemaTicketBooking {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		
		ChromeDriver driver =  new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.cinemark.com/theatres");
		
		driver.manage().window().maximize();
		
		//Choose Theatre
		
		driver.findElement(By.xpath("//span[text()='Cinemark Cedar Hills 16']")).click();
		
		//choose the date
		driver.findElement(By.xpath("(//div[@class='showdate-date'])[2]")).click();
		
		Thread.sleep(1000);
		
		//Choose the movie time and checkout
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement sClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//h3[contains(text(),'Dollhouse')]/parent::a")));
		
		Actions act = new Actions(driver);
		
		act.scrollToElement(sClick).perform();
		
		sClick.click();
		
		String txt =  driver.getTitle();
		
		System.out.println(txt);
		
			
		
		WebElement sClick2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("(//div[@class='showtime']//a)[1]")));
		
		
		act.scrollToElement(sClick2).perform();
		
		sClick2.click();
		
		String seatMap = driver.getTitle();
		
		System.out.println(seatMap);

		driver.findElement(By.xpath("(//span[@class='seatDesignation'])[5]")).click();
		
		driver.findElement(By.xpath("//a[@class='qadd plusMinus']")).click();
		
		WebElement sClick3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.id("btnAddToCart")));
			
					
		act.scrollToElement(sClick3).perform();
		
		sClick3.click();
		
		WebElement sClick4 = wait.until(ExpectedConditions.elementToBeClickable(
			    By.cssSelector("a[data-test='ContinueToCheckoutSidebar']")));

		new Actions(driver).scrollToElement(sClick4).perform();
		sClick4.click();

		System.out.println("Clicked on 'Continue to Checkout'");
				
		String seatInfo = driver.findElement(By.xpath("//div[@class='col-xs-12 sub-description']")).getText();
		
		System.out.println("Seat number:"+seatInfo);
		
		String grandTotal = driver.findElement(By.xpath("//div[@id='SummaryTotal']")).getText();
		
		System.out.println("Grand Total:"+grandTotal);
		
		driver.quit();
		

	}

}
