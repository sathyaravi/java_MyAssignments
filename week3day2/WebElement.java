package week3day2;
//Base Class
public class WebElement {
	
	//Methods
	public void Click() {
		
		System.out.println("WebElement is clicked");

	}
	
	public void setText() {
		
		System.out.println("Fill in the text");

	}
	public static void main(String[] args) {
		
		WebElement wbobj = new WebElement();//Object Creation
		wbobj.Click();
		wbobj.setText();

	}

}
