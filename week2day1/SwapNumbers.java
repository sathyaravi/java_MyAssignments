package week2day1;

public class SwapNumbers {

	public static void main(String[] args) {

		// To Swap the numbers
		int x=15,y=20,temp=0;
		System.out.println("The value of x before swapping:"+x);
		System.out.println("The value of y before swapping:"+y);	
		//Swap the numbers using temp variable
		temp = x;
		x=y;
		y=temp;
		System.out.println("The value of x after swapping:"+x);
		System.out.println("The value of y after swapping:"+y );
		}
		

	}


