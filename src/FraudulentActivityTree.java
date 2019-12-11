
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
    	LinkedList<Integer, Integer> subTable = new LinkedList<Integer, Integer>();
    	
    	int count = 0;
    	
for(int startIndex = 0; startIndex < expenditure.length -d -1; startIndex++) {
    		
    		int endIndex = startIndex + d -1;
    		if(startIndex == 0) {
    		subTable = getSubLinkedList(expenditure, startIndex, endIndex);
    		Collections.sort(subTable);
    		}
    		else {
    			Integer oldValue = expenditure[startIndex - 1];
    			Integer newValue = expenditure[endIndex];
    			//subTable.remove(oldValue);
    			subTable = removeOldValue(subTable, oldValue);
    			subTable = insertNewValue(subTable, newValue);
    			
    		}
    		//Find the median of the subTable
        	double m = getMedian(subTable);
        	//Determine if a notification should be sent for each entry(startindex + d) in the expenditure array and count the total number of notifications
        	if(expenditure[startIndex + d] > m) {
        		count++;
        	}
    	}
		return count;
    }
    
    //Comparator<Integer, Integer> comparator = Collections.sort();
    int binarySearch(LinkedList<Integer, Integer> thisList, int x) {
    	int left = 0, right = thisList.size() - 1;
    	while (left <= right) {
    		int mid = left + (right - 1) / 2;
    		
    		if(thisList.get(mid) == x)
    			return mid;
    		
    		if(thisList.get(mid) > x)
    			left = mid + 1;
    		
    		else
    			right = mid - 1;
    	}
		return -1;
    }
    
static LinkedList<Integer, Integer> removeOldValue(LinkedList<Integer, Integer> thisList, int x) {
    	
    	int left = 0, right = thisList.size() - 1;
    	while(left <= right) {
    		int mid = left + (right - 1) / 2;
    		
    		if(thisList.get(mid) == x) {
    			thisList.remove(mid);
    			System.out.println("Removing");
    			break;
    		}
			if(thisList.get(mid) > x) {
				right = mid - 1;
    			System.out.println("Move left");
			}
			else {
				left = mid + 1;
				System.out.println("Move right");
			}
    	}
    	return thisList;
    }
static LinkedList<Integer, Integer> insertNewValue(LinkedList<Integer, Integer> thisList, int x) {
	
	int left = 0, right = thisList.size() - 1;
	while(left <= right) {
		int mid = left + (right - 1) / 2;
		
		if(thisList.get(mid) == x) {
			thisList.add(mid, x);
			
			break;
		}
		if(thisList.get(mid) <= x && thisList.get(mid + 1) >= x) {
			thisList.add(mid, x);
			break;
		}
		if(thisList.get(mid) >= x && thisList.get(mid - 1) <= x) {
			thisList.add(mid - 1, x);
			break;
		}
		if(thisList.get(thisList.size() - 1) <= x) {
			thisList.add(x);
		}
		if(thisList.get(mid) > x) {
			right = mid - 1;
		}
		
		else {
			left = mid + 1;
		}
	}
	return thisList;
}
    
    static double getMedian(LinkedList<Integer, Integer> subTable) {
    	
    	if(subTable.size() % 2 == 0) {
    		double sum = subTable.get(subTable.size()/2) + subTable.get(subTable.size()/2 - 1);
    		return sum/2;
    	}
    	else {
    		return subTable.get((int) Math.floor(subTable.size()/2));
    	}
    	 	
    }
    static LinkedList<Integer, Integer> getSubLinkedList(int[] arr, int startIndex, int endIndex) {
    	//Initialize subTable LinkedList
    	LinkedList<Integer, Integer> subTable = new LinkedList<Integer, Integer>();
  
    	//Start the for loop to populate the new LinkedList using the old array
    	//initialized at given beginning index, end at given ending index
    	for(int i = startIndex; i < endIndex + 1; i++) {
    		subTable.add(arr[i]);
    	}
    	//Return the new LinkedList
    	return subTable;
    	
    	
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
