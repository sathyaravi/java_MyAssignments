package week2day2;

public class ReverseOddPositionWords {

	public static void main(String[] args) {
		String test = "I am a Software tester";
		String[] splitWord = test.split(" ");
		for (int i=0;i<splitWord.length;i++) {
			if (i%2==1) {
				char[] chars = splitWord[i].toCharArray();
				for (int j=chars.length-1;j>=0;j--) {
					System.out.print(chars[j]);
				}
			
				}
			
			else {
				System.out.print(splitWord[i]);
			}
			System.out.print(" ");	
		}

	}

}
