package week3day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElementFromList {

	public static void main(String[] args) {
		
		List<Integer> Arr1 = new ArrayList<Integer>();
		
		Arr1.add(1);
		Arr1.add(2);
		Arr1.add(3);
		Arr1.add(4);
		Arr1.add(10);
		Arr1.add(6);
		Arr1.add(8);
		
		Collections.sort(Arr1);
		
		for(int i=0;i<Arr1.size()-1;i++) {
			
			int currentnum = Arr1.get(i);
			int nextnum = Arr1.get(i+1);
			if(currentnum+1 != nextnum) {
				
				int missing = currentnum + 1;
				
				while (missing < nextnum) {
					
				    System.out.println("Missing number: " + missing);
				    missing++;
				}
			}
		}
		
		 	
		

	}

}
