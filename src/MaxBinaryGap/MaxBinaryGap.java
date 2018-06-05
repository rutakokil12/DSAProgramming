package MaxBinaryGap;

import java.util.Scanner;

public class MaxBinaryGap {
	public int solution(int N) {
        // write your code in Java SE 8
        if(N < 1)
            return -1;    
        int res = 0;
        int gapLen = 0;
        boolean binGapStart = false;
        boolean gapZeroes = false;           
        while(N >= 1) {
            if(N%2 == 1) {
                binGapStart = binGapStart && gapZeroes;              
                if(binGapStart) {
                    res = (res > gapLen)? res:gapLen;
                    gapZeroes = false;
                    gapLen = 0;
                }
                else
                    binGapStart = true;
            }
            else{
                gapZeroes = binGapStart;
                if(gapZeroes)
                    gapLen++;
            }           
            N = N/2;
        }       
        return res;       
           
       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxBinaryGap bg = new MaxBinaryGap();
        System.out.println("Enter integer number\t");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String binary = Integer.toBinaryString(num);
        System.out.println("Integer converted to binary to identify maximum binary gap\t" +binary);
        int r= bg.solution(num);
        System.out.println("Maximum Binary Gap\t" + r);
        
	}

}
