package week3day2;

//Sub Class
public class CheckBoxButton extends Button {
	
	//Methods 
	public void clickCheckButton() {
		
		System.out.println("Validating the Check Button");

	}

	public static void main(String[] args) {
		
		CheckBoxButton cButton = new CheckBoxButton();//Object Creation
		cButton.Click();//access the method from base class
		cButton.submit();//access the method from base class
		cButton.clickCheckButton();

	}

}
