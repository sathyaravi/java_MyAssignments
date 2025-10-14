package week3day2;

//Sub Class
public class Button extends WebElement{
	
	
	//Methods 
	public void submit() {
		
		System.out.println("Click the Submit button");

	}
	public static void main(String[] args) {
		
		Button buttonObj  = new Button(); //Object Creation
		buttonObj.Click();
		buttonObj.setText(); //access the method from base class
		buttonObj.submit();
		

	}

}
