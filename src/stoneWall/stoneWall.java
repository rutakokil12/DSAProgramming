package stoneWall;

import java.util.Scanner;
import java.util.Stack;

import oddOccurancesInArray.oddOccurancesInArray;

public class stoneWall {
	public int solution(int[] H) {
        // write your code in Java SE 8
        int N = H.length;
        int stones = 0;
        int stack_index =0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i<N;i++){
            while(stack_index >0 && stack.peek() > H[i]){
                stack.pop();
                stack_index = stack_index -1;
                
            }
            if(stack_index >0 && stack.peek() == H[i]){
                continue;
            }else {
                stones = stones +1;
                stack.push(H[i]);
                stack_index= stack_index+1;
            }
        }
        return stones;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter total number of elements(heights) for wall");
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int H[] = new int[N];
		System.out.println("Enter array of heights of the wall");
	    for(int i=0;i<N;i++) {
		 H[i] =scan.nextInt();
	 }
		
	    stoneWall sol = new stoneWall();
	    int numOfStones = sol.solution(H);
	    System.out.println("Minimum blocks required to build the stonewall \t" + numOfStones);
		

	}

}
