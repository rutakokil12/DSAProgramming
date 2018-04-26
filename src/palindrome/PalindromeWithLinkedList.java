package palindrome;
import java.util.*;
public class PalindromeWithLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to be checked for palindrome");
		String org = sc.nextLine();
		List<Character>orgList = new LinkedList<>();
		for(char ch:org.toCharArray()) {
			orgList.add(ch);
		}
		ListIterator<Character> frwrd = orgList.listIterator();
		ListIterator<Character>rev = orgList.listIterator(orgList.size());
		boolean flag = true;
		while(frwrd.hasNext() && rev.hasPrevious()) {
			if(frwrd.next()!= rev.previous()) {
				flag = false;
				break;
			}
				
		}
		if(flag) {
			System.out.println("String is palindrome");
		}else {
			System.out.println("String is not palindrome");
		}

	}

}
