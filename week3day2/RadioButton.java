package week3day2;

//Sub Class

public class RadioButton extends Button {
	
	
	//Methods 
	public void selectRadioButton() {
		
		System.out.println("Radio button is selected");
	}

	public static void main(String[] args) {
		
		RadioButton radButton = new RadioButton();//Object Creation
		
		radButton.Click();//access the method from base class
		radButton.selectRadioButton();
		radButton.submit();//access the method from base class
		

	}

}
