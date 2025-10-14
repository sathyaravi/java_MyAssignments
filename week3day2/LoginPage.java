package week3day2;

//Sub Class
public class LoginPage extends BasePage{
	
	
	@Override
	public void performCommonTasks() {
		System.out.println("Inside Login Page Common Tasks method");
	}

	public static void main(String[] args) {
		
		LoginPage logObj = new LoginPage();
		logObj.performCommonTasks();

	}

}
