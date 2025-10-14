package week3day2;

public class LoginTestData extends TestData{
	
	public void enterUsername(String Username) {
		System.out.println("Username:"+Username);

	}
	
	public void enterPassword(String Password) {
		
		System.out.println("Password:"+Password);

	}

	public static void main(String[] args) {
		
		LoginTestData obj = new LoginTestData();
		obj.enterCredentials("John Doe", "Welcome@123");
		obj.navigateToHomePage();
		obj.enterUsername("Stacy");
		obj.enterPassword("Hello@123");

	}

}
