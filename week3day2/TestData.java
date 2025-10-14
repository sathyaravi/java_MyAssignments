package week3day2;

public class TestData {
	
	public void enterCredentials(String Username, String Password) {
		
		System.out.println("Enter Username:"+Username);
		System.out.println("Enter Password:"+Password);
	}
	
	public void navigateToHomePage() {
		
		System.out.println("Inside Home Page");

	}

	public static void main(String[] args) {
		
		TestData td = new TestData();
		td.enterCredentials("Loreen Leedy", "Mice@100");
		td.navigateToHomePage();

	}

}
