import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Solution to determine how many 3 people families can fit on remaining seats in the flight. 
//Given input string contains seats already booked.
public class CodilityTestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter First String");
		String s1 = sc.nextLine();
		int N =1;
		int countA =0;
		int countD =0;
		int countH =0;
		int countFamily = 0;
		
		if(s1.isEmpty()) {
			
			for(int j=1; j<=N;j++) {
				countFamily =countFamily +3;
			}
			System.out.println(countFamily);
		}else {
			System.out.println("in else ");
			
			List<String> resultArray = Arrays.asList(s1.split("\\s*,\\s*"));
			System.out.println(resultArray);
			List<String> intList = new ArrayList<String>();
			List<String> charList = new ArrayList<String>();
			for (int i =0; i<resultArray.size();i++) {
				System.out.println(resultArray.get(i));
				 String[] splitDiv = resultArray.get(i).split("(?<=\\d)(?=\\D)");
				
				 intList.add(splitDiv[0]);
				
				 charList.add(splitDiv[1]);
			 }
			 
			for (int j=1; j<=N;j++) {
				countA =0;
				countD =0;
				countH = 0;
				int seatFreq = Collections.frequency(intList, j);
				for(int c =0; c <charList.size();c++) {
					if(charList.get(c).contains("A") ||charList.get(c).contains("B") || charList.get(c).contains("C")) {
						 countA = countA + 1;
						 
					}else if(charList.get(c).contains("D") ||charList.get(c).contains("E") || charList.get(c).contains("F")||charList.get(c).contains("G")) {
						countD =countD +1;
					}else if(charList.get(c).contains("H") ||charList.get(c).contains("J") || charList.get(c).contains("K")) {
						countH = countH + 1;
					}
					
				}
				
				if(countA == 0) {
					countFamily = countFamily +1;
				}
				if(countD < 2) {
					countFamily = countFamily +1;
				}
				if(countH == 0) {
					countFamily = countFamily +1;
				}
				
			}
			System.out.println("no of families  "+countFamily);
			
		}
		
		 
		 
		
		
		
		

	}

}
