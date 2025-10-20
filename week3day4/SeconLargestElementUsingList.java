package week3day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeconLargestElementUsingList {

	public static void main(String[] args) {

		List<Integer> Arr1 = new ArrayList<Integer>();
		Arr1.add(3);
		Arr1.add(2);
		Arr1.add(11);
		Arr1.add(4);
		Arr1.add(6);
		Arr1.add(7);
		
		System.out.println("List before sorting:"+Arr1);
		
		Collections.sort(Arr1);
		
		System.out.println("List after sorting:"+Arr1);
		
		int size = Arr1.size();
		//System.out.println();
		System.out.println("Second Largest Element in the list:"+Arr1.get(size-2));

	}

}
