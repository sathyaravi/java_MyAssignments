package stepdefinition;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccount extends BaseClass {
	
	@Given("click on the login button")
	public void click_on_the_login_button() {
		
		driver.findElement(By.className("decorativeSubmit")).click();
	
	}
	@Given("Navigate to the next page and click on the accounts tab")
	public void navigate_to_the_next_page() {
		
		String pageTitle = driver.getTitle();
		System.out.println("Current Page Title:"+pageTitle);
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("TestLeaf Account1");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("100");
		driver.findElement(By.name("officeSiteName")).sendKeys("LeafTaps");
		
	}
	@When("Click on the create account button")
	public void click_on_accountCreateButton() {
		driver.findElement(By.className("smallSubmit")).click();
		
	}
	
	@Then("Navigate to the account details page")
	public void Navigate_to_accountDetailsPage() {
		String title = driver.getTitle();
		System.out.println("Page Title after account creation:"+title);

	}
}
