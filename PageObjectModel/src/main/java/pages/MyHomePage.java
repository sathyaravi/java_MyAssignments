package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class MyHomePage extends BaseClass{

	public CreateAccountPage clickcreateAccount() {
		
		getDriver().findElement(By.linkText("Accounts")).click();
		
		return new CreateAccountPage();

	}

	
}
