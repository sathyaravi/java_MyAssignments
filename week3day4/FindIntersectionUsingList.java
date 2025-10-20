package week3day4;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionUsingList {

	public static void main(String[] args) {
		
		List<Integer> Arr1 = new ArrayList<Integer>();
		Arr1.add(3);
		Arr1.add(2);
		Arr1.add(11);
		Arr1.add(4);
		Arr1.add(6);
		Arr1.add(7);
		//System.out.println(Arr1);
		
		List<Integer> Arr2 = new ArrayList<Integer>();
		Arr2.add(1);
		Arr2.add(2);
		Arr2.add(8);
		Arr2.add(4);
		Arr2.add(9);
		Arr2.add(7);
		//System.out.println(Arr2);
		List<Integer> IntersectionList = new ArrayList<Integer>();
		for(int i=0;i<Arr1.size();i++) {
			
			for(int j=0;j<Arr2.size();j++) {
				
				int n1 = Arr1.get(i);
				int n2 = Arr2.get(j);
				if(n1==n2 && !IntersectionList.contains(n1)) {
					
					IntersectionList.add(n1);
					
					
				}
			}
			
		}
		System.out.println("Intersection between two lists found:"+IntersectionList);
	}

}
