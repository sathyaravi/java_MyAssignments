package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC_002_LogOut extends BaseClass {
	
	@Test
	public void TC_002_logout() {
		
		LoginPage lp = new LoginPage();
		lp.enteruserName().enterPassword().loginButton()
		.clickLogoutButton();
		
	}

}
