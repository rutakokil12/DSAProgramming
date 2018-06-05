package CyclicRotationOfArray;

import java.util.Arrays;
import java.util.Scanner;

public class cyclicRotation {
	
	public void solution(int[] array, int k) {
		
		int size = array.length;
		if(size == 0) {
			System.out.println("Result array after "+ k +" rotations =  " + Arrays.toString(array) );
		}
		else {
			for(int i = 0; i<k; i++) {
				int temp = array[size-1];
				for(int j =size-1; j>0; j--) {
					array[j] = array[j-1];
				}
				array[0] = temp;
			}
			System.out.println("Result array after "+ k +" rotations =  " + Arrays.toString(array) );

		}
		

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter total number of elements in array");
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int array[] = new int[n];
	    System.out.println("Enter array elements: ");
	    for(int i=0;i<n;i++) {
		 array[i] =scan.nextInt();
	 }
	    System.out.println("Enter number of times array to be rotated");
		int k = scan.nextInt();
		int result[] = new int[n];
		cyclicRotation sol = new cyclicRotation();
		sol.solution(array, k);
        
	}

}
