package week4day4;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bigbasketshopping {

	    public static void main(String[] args) throws IOException, InterruptedException {

	        // To avoid resource loading issues
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-http2");

	        // Launch the browser
	        ChromeDriver driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));

	        driver.get("https://www.instacart.com/");

	        // Click Costco link
	        driver.findElement(By.xpath("//a[contains(@href,'costco')]")).click();

	        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));

	        
	        try {
	            WebDriverWait shortWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
	            WebElement closePopup = shortWait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//button[contains(@aria-label,'Close') or contains(text(),'×') or contains(text(),'close') or contains(@class,'close')]")
	            ));
	            closePopup.click();
	            System.out.println("Popup closed successfully.");
	        } catch (TimeoutException e) {
	            System.out.println("No popup appeared — continuing.");
	        }

	        // Continue with next steps
	        WebElement pantryLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'pantry')]")));
	        pantryLink.click();

	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//a[contains(@href,'pasta-grains')]")).click();
	        driver.findElement(By.xpath("//a[contains(text(),'Rice')]")).click();
	        driver.findElement(By.xpath("//button[contains(@aria-label,'Basmati Rice')]")).click();
	        driver.findElement(By.xpath("//button[contains(@aria-label,'View Cart')]")).click();
	        driver.findElement(By.xpath("//h3[contains(text(),'Basmati Rice')]")).click();

	        String quantityAdded = driver.findElement(By.xpath("(//span[@id='selected-text'])[1]")).getText();
	        String quantityCount = quantityAdded.replaceAll("[^0-9]", "");
	        System.out.println("Total count: " + quantityCount);
	        System.out.println("Item added to the cart successfully");

	        File Screenshot = driver.getScreenshotAs(OutputType.FILE);
	        File target = new File("./screenshot_files/instacartshoppingsample.png");
	        FileUtils.copyFile(Screenshot, target);

	        WebElement priceElement = driver.findElement(By.xpath("//span[@class='e-0']"));
	        String priceText = priceElement.getText();
	        System.out.println("Current Price: " + priceText);

	        driver.quit();
	    }
	}


