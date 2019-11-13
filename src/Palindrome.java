
// Java implementation of the approach 
public class Palindrome { 
  
    // Function that returns true if 
    // str is a palindrome 
	static String tester(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				System.out.println("false");
			i++;
			j--;
		} 
		return str;
	}
    static boolean isPalindrome(String str) 
    { 
  
        // Pointers pointing to the beginning 
        // and the end of the string 
        int i = 0, j = str.length() - 1; 
  
        // While there are characters toc compare 
        while (i < j) { 
  
            // If there is a mismatch 
            if (str.charAt(i) != str.charAt(j)) 
                return false; 
  
            // Increment first pointer and 
            // decrement the other 
            i++; 
            j--; 
        } 
  
        // Given string is a palindrome 
        return true; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        String str = "racecar"; 
  
        System.out.println(tester(str));
//        if (isPalindrome(str)) 
//            System.out.print("Yes"); 
//        else
//            System.out.print("No"); 
    } 
} 