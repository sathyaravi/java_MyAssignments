package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class WelcomePage extends BaseClass {
	
	public MyHomePage clickCRMSFA() {
		
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();

	}
	public LoginPage clickLogoutButton() {
		getDriver().findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		return new LoginPage();

	}

}
