package StringPermutation;
import java.util.*;


public class StringPermutationUsingHashTable {

	public boolean checkPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		Hashtable htable =new Hashtable<>();
		for(int i =0; i< s1.length();i++) {
			char ch = s1.charAt(i);
			if(htable.containsKey(ch)) {
				int val = (int) htable.get(ch) + 1;
				htable.put(ch, val);
				
			}else {
				htable.put(ch,1);
			}
		}
		
		for(int i =0; i<s2.length(); i++) {
			char ch = s2.charAt(i);
			if(htable.containsKey(ch)) {
				int val = (int)htable.get(ch) ;
				if (val == 0) {
					return false;
				}
				val --;
				htable.put(ch, val);
			}else {
				return false;
			}
		}
		Iterator iterator = htable.keySet().iterator();
		while(iterator.hasNext()) {
			Character c =(Character)iterator.next();
			if((int)htable.get(c)!= 0) {
				return false;
			}
			
		}
		return true;
		
	}
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter First String");
		String s1 = sc.nextLine();
		System.out.println("Enter Second String");
		String s2 = sc.nextLine();
		StringPermutationUsingHashTable p = new StringPermutationUsingHashTable();
		System.out.println(s1 +" and "+ s2 + " are permutation of each other? " + p.checkPermutation(s1, s2));
		
	}
}

