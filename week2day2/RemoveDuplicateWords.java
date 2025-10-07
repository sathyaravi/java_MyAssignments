package week2day2;

public class RemoveDuplicateWords {

	public static void main(String[] args) {
		String text = "We learn Java basics as part of java sessions in java week1";
		int count = 0;
		String [] splittedWords = text.split(" ");
		
		for(int i=0;i<splittedWords.length;i++) {
			for(int j=i+1;j<splittedWords.length;j++) {
			if (splittedWords[i].equalsIgnoreCase(splittedWords[j])) {
				splittedWords[j]=" ";
				count+=1;
			}
			
		}
	}
	if (count>0) {
		for(int i=0;i<splittedWords.length;i++) {
			String word = splittedWords[i];
			System.out.print(word);
			System.out.print(" ");
		}
		
		
		
	}
		

}

}