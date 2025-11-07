package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	// Thread-safe driver
    private static ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();

    public ChromeDriver getDriver() {
        return driver.get();
    }
	
	
	@BeforeMethod
	public void preCondition() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver chromeDriver = new ChromeDriver(options);
        driver.set(chromeDriver);
        chromeDriver.get("http://leaftaps.com/opentaps/");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		
	}
	
	
	@AfterMethod
	public void postCondition() {
		ChromeDriver chromeDriver = driver.get();
        if (chromeDriver != null) {
            chromeDriver.quit();
            driver.remove();

	}

}
	
}
