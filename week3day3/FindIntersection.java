package week3day3;

public class FindIntersection {

	public static void main(String[] args) {
		
		//Array Instantiation
		int A[] = {3,2,11,4,6,7};
		int B[] = {1,2,8,4,9,7};
		
		System.out.println("Matching Elements present in the arrays A and B:");
		//Comparing the elements from both arrays
		for(int i=0;i<=A.length-1;i++) {
			
			for(int j=0;j<=B.length-1;j++) {
				
				if(A[i]==B[j]) {
					
					System.out.println(A[i]);
				}
			}
		}

	}

}
