package palindrome;

import java.util.Scanner;


public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String org ,rev = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to check if it is palindrome");
        org = sc.nextLine();
         for(int i= org.length()- 1; i>=0; i--) {
        	 rev = rev + org.charAt(i);
         }
         if(org.equals(rev)) 
        	 System.out.println("Entered String is palindrome");
         else
        	 System.out.println("Entered string is not a palindrome");
	}

}
