package RadixSortLsd;
import java.io.*;
import java.util.*;
public class LsdRadix {

	public static void main(String[] args) throws IOException {

        if (args.length !=0 && args[0].equals("f.txt") && args[1].equals("g.txt")) {
           readFile(args[0],args[1]);
        	
       }else{
            System.out.println("Enter the input text file location of your choice (Default = f.txt) :");
            Scanner sc= new Scanner(System.in);
            String iFileName = sc.nextLine();
        	
            System.out.println("Enter the output text file location of your choice (Default = g.txt) :");
            String oFileName = sc.nextLine();
            	
            readFile(iFileName,oFileName);
       }
    }

    public static void readFile(String inputF,String outputF){
        try {
            int k = maxWordLength(inputF); // make sure maximum word length is 21.
            int n = countLines(inputF);  // counting total number of words to be sorted in a file.
            char[][] s = new char[n][k];

            BufferedReader br = new BufferedReader(new FileReader(inputF));
            String word;
            int i = 0;
            while ((word = br.readLine()) != null) {
                char[] temp = word.toCharArray();
                for (int j = 0; j < k; j++) {
                    if (j < temp.length) {
                        s[i][j] = temp[j]; //reading each character in two dimensional array
                    } else {
                        s[i][j] = ' ';     // padding the string with blank characters if the length is less than 21
                    }
                }
                i++;
            }
            int[] pointerArr = new int[n];
            for (i = 0; i < n; i++) {   // pointer array of indices
            	pointerArr[i] = i;
            }
            lsdRadixStringSort(s, pointerArr, k);
            writeFile(s,pointerArr,outputF,n,k);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void lsdRadixStringSort(char[][] s, int[] pointerArr, int wordLen) {
        int l = s.length;
        int asciiByte = 256;   //extended ASCII code size
        int[] P = new int[l];

        for (int e = wordLen - 1; e >= 0; e--) {
            int[] count = new int[asciiByte + 1];
            for (int i = 0; i < l; i++) {          // compute frequency counts
                count[s[pointerArr[i]][e] + 1]++;
            }

            for (int j = 0; j < asciiByte; j++) {      // compute cumulates
                count[j + 1] += count[j];
            }
            for (int k = 0; k < l; k++) {
                P[count[s[pointerArr[k]][e]]++] = pointerArr[k]; //move data
            }
            for (int m = 0; m < l; m++) {     //copy back
            	pointerArr[m] = P[m];
            }
        }
    }

    private static int maxWordLength(String inputF) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(inputF));
        int n = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if(line.length() > 21){
                System.out.println("Program can not execute as it contains String with length greater than 21");
                System.exit(0);
            }else if(line.length() >= n){
                n = line.length();
            }
        }
        return n;
    }
		

	public static void writeFile(char[][] s, int[] pointerArr,String oFile,int n,int k){
		
		try {
			PrintWriter writer = new PrintWriter(oFile); // Empty the file before writing the sorted output
			writer.print("");
			writer.close();
            FileWriter file = new FileWriter(oFile, true);
            BufferedWriter output = new BufferedWriter(file);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    output.write(s[pointerArr[i]][j]);
                }
                output.newLine();
            }
            output.close();
        	
        } catch(IOException e){
            e.printStackTrace();
        }
    }
   

    public static int countLines(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int i = 0;
        String nLine;
        while ((nLine = br.readLine()) != null) {
            i++;
        }
        return i;
    }
		
}
       


