import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
	 static int makeAnagram(String a, String b) {

	    	int result = 0;
	    	
	    	//abc
	    	//cde
	    	//Use a for loop that compares the a string to the b string, one char at a time
	    	//If the chars don't match, increment the result, go to the next comparison
	    	for (int i = 0; i < a.length(); i++) {
	    		if(b.length()==0 ) {
	    			result+=a.length()-i;
	    			break;
	    		}
	    		for(int j = 0; j < b.length(); j ++) {
	    			//If the match happens at 0, the substring is the right string
	    			//If the match happens at b.length - 1, the substring is the left string
	    			//In the general case, make two substrings L and R which are 
	    			//L = substring(0, j-1), R = substring(j+1, b.length-1)
	    			if(a.charAt(i) == b.charAt(j)) {
	    				if(j == 0) {
	        				b = b.substring(1);
	        				break;
	        			}
	    				else if(j == b.length() - 1) {
	    					b = b.substring(0, j);
	    					break;
	    				}
	    				else {
	    				String L = b.substring(0, j);	
	    				String R = b.substring(j+1, b.length());
	    				System.out.println("--"+L);
	    				System.out.println("--"+R);
	    				b = L + R;
	    				break;
	    				}
	    			}
	    			if(j == b.length() - 1 && a.charAt(i) != b.charAt(j)) {
	    				result++;
//	    				System.out.println(a);
//	    				System.out.println(b);
	    				
	    				System.out.println(i+" "+j+ " "+b.length());
	    			}
	    			
	    			
	    			
	    		}
	    	}
	    	System.out.println("A length "+a.length());
	    	System.out.println("B length "+b.length());
	    	result += b.length();
	    	return result;
	    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
