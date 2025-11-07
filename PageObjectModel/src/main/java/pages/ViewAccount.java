package pages;

import base.BaseClass;

public class ViewAccount extends BaseClass {

	public void viewAccountPage() {
		
		String title = getDriver().getTitle();
		System.out.println("Current Page of the Title:"+title);

	}
}
