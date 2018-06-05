package oddOccurancesInArray;

import java.util.*;

public class oddOccurancesInArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter total number of elements(odd number) in array");
		Scanner scan = new Scanner(System.in);
		int oddN = scan.nextInt();
		int array[] = new int[oddN];
	    System.out.println("Enter array elements: ");
	    for(int i=0;i<oddN;i++) {
		 array[i] =scan.nextInt();
	 }
	    oddOccurancesInArray sol = new oddOccurancesInArray();
	    int oddNum = sol.solution(array);
	    System.out.println("Number with Odd Occurance In Array \t" + oddNum);
	}

	public int solution(int[] A) {
		int oddNum = 0;
		int size = A.length;
		List<Integer> intList = new ArrayList<Integer>();
		for (int i : A)
		{
		    intList.add(i);
		}
		for(int i =0; i<size; i++) {
			int countOfSameValues = Collections.frequency(intList, A[i]);
			if(countOfSameValues > 1)
				continue;
			else
				  oddNum = A[i];
		}
		return oddNum;	
		
	}
	/*// Time: O(N)
	// Space: O(1)
	public static int solution(int[] A) {
		// write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];                      // as A xor B xor A xor B xor c = c as A xor A cancels itself.
		}
		return elem;
	}*/
	

	
}
