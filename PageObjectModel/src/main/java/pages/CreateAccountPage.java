package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class CreateAccountPage extends BaseClass {
	
	public ViewAccount clickcreateAccountForm() {
		
		getDriver().findElement(By.linkText("Create Account")).click();
		
		getDriver().findElement(By.id("accountName")).sendKeys("TestLeaf New Account1");
		getDriver().findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		getDriver().findElement(By.id("numberEmployees")).sendKeys("100");
		getDriver().findElement(By.name("officeSiteName")).sendKeys("LeafTaps");
		getDriver().findElement(By.className("smallSubmit")).click();
		return new ViewAccount();

	}

}
