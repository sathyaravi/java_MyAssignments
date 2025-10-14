package week3day2;

//Base Class
public class BasePage {
	
	//Methods
	
	public void findElement() {
		System.out.println("Inside Find Element method");
	}
	
	public void clickElement() {
		
		System.out.println("Inside Click Element method");
	}
	
	public void enterText() {
		
		System.out.println("Inside Text method");
	}
	
	public void performCommonTasks(){
		
		System.out.println("Inside Common Tasks method");

	}
	public static void main(String[] args) {
		
		BasePage baseObj = new BasePage();
		baseObj.clickElement();
		baseObj.clickElement();
		baseObj.enterText();
		baseObj.performCommonTasks();

	}

}
