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
    	int[] subArray = new int[d];
    	int count = 0;
    	//Generate a subArray using the getSubArray method with a start index of 0, incrementing to expediture.length - d - 1, and an end index of startindex + d - 1.
    	for(int startIndex = 0; startIndex < expenditure.length -d -1; startIndex++) {
    		
    		int endIndex = startIndex + d -1;
    		if(startIndex == 0) {
    		subArray = getSubArray(expenditure, startIndex, endIndex);
    		Arrays.sort(subArray);
    		}
    		else {
    			int oldValue = expenditure[startIndex - 1];
				int newValue = expenditure[endIndex];
				boolean oldValueRemoved = false;
				boolean newValueInserted = false;
				int temp = 0;
    			for(int i = 0; i < subArray.length; i++) {
    				if(oldValue == newValue) {
    					break;
    				}
    				else if(newValue < oldValue) {
    					if (!newValueInserted && subArray[i] > newValue) {
    						temp = subArray[i];
    						subArray[i] = newValue;
    						newValueInserted = true;
    					}
    					else if(newValueInserted && !oldValueRemoved) {
    						if(subArray[i] == oldValue) {
    							subArray[i] = temp;
    							oldValueRemoved = true;
    							break;
    						}else {
    							int curtemp = subArray[i];
    							subArray[i] = temp;
    							temp = curtemp;
    						}
    					}
    					
    				}
    				else if(newValue > oldValue) {
    					if(i == subArray.length - 1) {
    						subArray[i] = newValue;
    						newValueInserted = true;
    						break;
    					}
    					if(!oldValueRemoved && subArray[i] == oldValue) {
    						if(newValue < subArray[i + 1]) {
    							subArray[i] = newValue;
    							newValueInserted = true;
    							oldValueRemoved = true;
    							break;
    						}
    						subArray[i] = subArray[i + 1];
    						oldValueRemoved = true;
    					}
    					else if(oldValueRemoved && subArray[i + 1] > newValue) {
							subArray[i] = newValue;
							newValueInserted = true;
							break;
						}
    					else if(oldValueRemoved && !newValueInserted) {
    						subArray[i] = subArray[i + 1];
    					}
    					
    					
    				}
    					
    			}
    		}
    		//Find the median of the subArray
        	double m = getMedian(subArray);
        	//Determine if a notification should be sent for each entry(startindex + d) in the expenditure array and count the total number of notifications
        	if(expenditure[startIndex + d] > m) {
        		count++;
        	}
    	}
		return count;
    }
    static double getMedian(int[] arr) {
    	
    	if(arr.length % 2 == 0) {
    		double sum = arr[arr.length/2] + arr[arr.length/2 - 1];
    		return sum/2;
    	}
    	else {
    		return arr[(int) (arr.length/2)];
    	}
    	 	
    }
    static int[] getSubArray(int[] arr, int startIndex, int endIndex) {
    	//Initialize subArray with the new length which is the startIndex subtracted from the endIndex
    	int[] subArray = new int[endIndex - startIndex + 1];
    	//Start the for loop to populate the new array using the old array
    	//initialized at given beginning index, end at given ending index
    	for(int i = startIndex; i < endIndex + 1; i++) {
    		subArray[i - startIndex] = arr[i];
    	}
    	//Return the new array
    	return subArray;
    	
    }

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
