package week3day2;

//Sub Class

public class TextField extends WebElement {
	
	
	//Methods 
	
	public void getText() {
		
		System.out.println("Get Text method");

	}

	public static void main(String[] args) {
		
		TextField tObj  = new TextField();//Object Creation
		tObj.Click(); //access the method from base class
		tObj.getText();
		tObj.setText();
		

	}

}
