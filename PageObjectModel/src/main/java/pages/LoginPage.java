package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage enteruserName() {
		
		getDriver().findElement(By.id("username")).sendKeys("DemoSalesManager");
		return this;
		
	}
	
	public LoginPage enterPassword() {
		
		getDriver().findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	
	public WelcomePage loginButton() {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new WelcomePage();
	}

}
