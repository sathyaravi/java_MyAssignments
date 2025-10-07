package week2day2;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potss";
		if (text1.length()==text2.length()) {
			
			char[] char1 = text1.toCharArray();
			char[] char2 = text2.toCharArray();
			Arrays.sort(char1);
			Arrays.sort(char2);
			if (Arrays.equals(char1,char2 )) {
				System.out.println("The given strings are anagram");
			}
			else {
				System.out.println("The given strings are not anagram");
			}
			
		}
		else {
			System.out.println("Lengths Mismatch.Not a Anagram");
			
		}

	}

}
