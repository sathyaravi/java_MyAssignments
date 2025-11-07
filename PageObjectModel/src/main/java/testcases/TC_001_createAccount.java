package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_001_createAccount extends BaseClass {
	
	@Test
	public void TC_001_createAccount_1() {
		
		LoginPage lp = new LoginPage();
		lp.enteruserName().enterPassword().loginButton()
		.clickCRMSFA()
		.clickcreateAccount()
		.clickcreateAccountForm()
		.viewAccountPage();
		
	}
	
	
	
	

}
