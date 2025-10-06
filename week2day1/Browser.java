package week2day1;

public class Browser {
	
	
	
	public String launchBrowser(String browserName) {
		
		System.out.println(browserName + " launched successfully");
		return browserName;
		
	}
	
	public void loadurl() {
		System.out.println("Application url loaded successfully");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Browser obj = new Browser();
		obj.launchBrowser("Chrome");
		obj.loadurl();
	}

}

