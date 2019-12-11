
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	HashMap<Integer, Integer> subMap = new HashMap<Integer, Integer>();
    	int count = 0;
    	
for(int startIndex = 0; startIndex < expenditure.length -d -1; startIndex++) {
    		
    		int endIndex = startIndex + d -1;
    		if(startIndex == 0) {
    		subMap = getSubMap(expenditure, startIndex, endIndex);
//    		Collections.sort(subMap);
    		}
    		else {
    			Integer oldValue = expenditure[startIndex - 1];
    			Integer newValue = expenditure[endIndex];
    			//subMap.remove(oldValue);
    			subMap = removeOldValue(subMap, oldValue);
    			subMap = insertNewValue(subMap, newValue);
    			
    		}
    		//Find the median of the subMap
        	double m = getMedian(subMap, d);
        	//Determine if a notification should be sent for each entry(startindex + d) in the expenditure array and count the total number of notifications
        	if(expenditure[startIndex + d] >= 2 * m) {
        		count++;
        	}
    	}
		return count;
    }
//    void sort(HashMap<Integer, Integer> thisMap) {
//    	int n = arr.length;
//    	
//    	// The output character array that will have sorted arr 
//        int count[] = new int[256];
//  
//        // Create a count array to store count of inidividul 
//        // characters and initialize count array as 0 
//        
//        for (int i=0; i<256; ++i) 
//            count[i] = 0; 
//  
//        // store count of each character 
//        for (int i=0; i<n; ++i) 
//            ++count[arr[i]]; 
//  
//        // Change count[i] so that count[i] now contains actual 
//        // position of this character in output array 
//        for (int i=1; i<=255; ++i) 
//            count[i] += count[i-1]; 
//  
//        // Build the output character array 
//        // To make it stable we are operating in reverse order. 
//        for (int i = n-1; i>=0; i--) 
//        { 
//            output[count[arr[i]]-1] = arr[i]; 
//            --count[arr[i]]; 
//        } 
//  
//        // Copy the output array to arr, so that arr now 
//        // contains sorted characters 
//        for (int i = 0; i<n; ++i) 
//            arr[i] = output[i]; 
//    }
    
    static HashMap<Integer, Integer> getSubMap(int[] arr, int startIndex, int endIndex) {
    	//Initialize subMap HashMap
    	HashMap<Integer, Integer> subMap = new HashMap<Integer, Integer>();
  
    	//Start the for loop to populate the new HashMap using the old array
    	//initialized at given beginning index, end at given ending index
    	for(int i = startIndex; i < endIndex + 1; i++) {
    		if(subMap.containsKey(arr[i])) {
    		subMap.put(arr[i], subMap.get(arr[i])+1);
    		}
    		else {
    			subMap.put(arr[i], 1);
    		}
    	}
    	//Return the new HashMap
    	return subMap;
    	
    	
    }
//    int binarySearch(HashMap<Integer, Integer> thisMap, int x) {
//    	int left = 0, right = thisMap.size() - 1;
//    	while (left <= right) {
//    		int mid = left + (right - 1) / 2;
//    		
//    		if(thisMap.get(mid) == x)
//    			return mid;
//    		
//    		if(thisMap.get(mid) > x)
//    			left = mid + 1;
//    		
//    		else
//    			right = mid - 1;
//    	}
//		return -1;
//    }
    
static HashMap<Integer, Integer> removeOldValue(HashMap<Integer, Integer> thisMap, int x) {
    	
		if(thisMap.get(x)>1) {
			thisMap.put(x, thisMap.get(x) - 1);
		}else {
			thisMap.remove(x);
		}
    	return thisMap;
    }
static HashMap<Integer, Integer> insertNewValue(HashMap<Integer, Integer> thisMap, int x) {
	
	if(thisMap.containsKey(x)) {
			thisMap.put(x, thisMap.get(x) + 1);
		}
		else {
			thisMap.put(x, 1);
		}
	return thisMap;
}
    
    static double getMedian(HashMap<Integer, Integer> subMap, int windowLength) {
    	Set<Integer> keySet = subMap.keySet();
    	Integer[] sortedKeySet = new Integer[keySet.size()];
    	subMap.keySet().toArray(sortedKeySet);
	 	Arrays.sort(sortedKeySet);
	 	
	 	int loRange = 0, hiRange = 0;
	 	boolean hiRangeAssigned = false;
	 	int leftRangeIndex=windowLength/2-1;
	 	int rightRangeIndex=windowLength/2;
	 	for(int i = 0; i < sortedKeySet.length; i++) {
	 		int key = sortedKeySet[i];
	 		if(!hiRangeAssigned) {
	 			hiRange = subMap.get(key) - 1;
	 			hiRangeAssigned = true;
	 		}
	 		else {
	 			loRange = hiRange + 1;
	 			hiRange += subMap.get(key);
	 		}
	 		if(windowLength % 2 == 0) {
	 			if(leftRangeIndex>=loRange && leftRangeIndex <= hiRange) {
	 				if(rightRangeIndex >=loRange && rightRangeIndex <=hiRange) {
	 					return key;
	 				}else {
	 					return ((double)(key + sortedKeySet[i+1])) / 2;
	 				}
	 			}
 			}	
 			
	 		else {
	 			if(rightRangeIndex >= loRange && rightRangeIndex <= hiRange && hiRangeAssigned) {
	 				
	 				return key;
	 		
	 			}
	 		}
	 	}
	 	
	 	return -1;
    }
//    static HashMap<Integer, Integer> getSubHashMap(int[] arr, int startIndex, int endIndex) {
//    	//Initialize subMap HashMap
//    	HashMap<Integer, Integer> subMap = new HashMap<Integer, Integer>();
//  
//    	//Start the for loop to populate the new HashMap using the old array
//    	//initialized at given beginning index, end at given ending index
//    	for(int i = startIndex; i < endIndex + 1; i++) {
//    		subMap.add(arr[i]);
//    	}
//    	//Return the new HashMap
//    	return subMap;
//    	
//    	
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
