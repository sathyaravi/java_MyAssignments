package week3day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ButtonInteraction {

	public static void main(String[] args) {
		
		//Instantiate and launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		
		String pageTitle = driver.getTitle();
		
		if (pageTitle.equals("Dashboard")) {
		
			System.out.println("Page Title verified:"+pageTitle);
		}
		
		
		//navigate back to the previous page
		driver.navigate().back();
		
		//verify the Confirm button is disabled
		WebElement buttonConfirm=driver.findElement(By.xpath("//span[text()='Disabled']/parent::button"));
		boolean isEnabled = buttonConfirm.isEnabled();
		System.out.println("Confirm if the button is disabled:"+isEnabled);
		
		//Find the position of the button with text submit
		
		WebElement submitButtonPosition = driver.findElement(By.xpath("//span[text()='Submit']/parent::button"));
		System.out.println(submitButtonPosition.getLocation());
		
		
		//Find the color of the save button
		WebElement saveButtoncolor = driver.findElement(By.xpath("//span[contains(text(),'Save')]/parent::button"));
		System.out.println(saveButtoncolor.getCssValue("background-color"));
		
		//Find the height and width of the save button
		
		WebElement saveButton = driver.findElement(By.xpath("//span[contains(text(),'Save')]/parent::button"));
		int height = saveButton.getSize().getHeight();
		int width = saveButton.getSize().getWidth();
		
		System.out.println("The height of the save button:"+height);
		
		System.out.println("The width of the save button:"+width);
		
		
		driver.close();
		
		
		////
		/////
		///
		///
		///

}

}