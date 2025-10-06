package week2day1;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		PrimeNumbers obj = new PrimeNumbers();
		obj.prime(6);
	}
	public void prime(int num) {
		
		if (num <= 1) {
			
			System.out.println("The given number is not a Prime number :"+num);
			return;
		}
		for (int i=2;i<=num/2;i++) {
			if (num % i == 0) {
			System.out.println("The given number is a Prime number:"+num);
			return;
		}
	}
	System.out.println("The given number is a Prime number: " + num);

}
}
