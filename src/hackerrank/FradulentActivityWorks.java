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
    	ArrayList<Integer> subArray = new ArrayList<Integer>();
    	
    	int count = 0;
    	//Generate a subArray using the getSubArray method with a start index of 0, incrementing to expediture.length - d - 1, and an end index of startindex + d - 1.
    	for(int startIndex = 0; startIndex < expenditure.length -d -1; startIndex++) {
    		
    		int endIndex = startIndex + d -1;
    		if(startIndex == 0) {
    		subArray = getSubArrayList(expenditure, startIndex, endIndex);
    		Collections.sort(subArray);
    		}
    		else {
    			Integer oldValue = expenditure[startIndex - 1];
    			Integer newValue = expenditure[endIndex];
    			//subArray.remove(oldValue);
    			subArray = removeOldValue(subArray, oldValue);
    			subArray = insertNewValue(subArray, newValue);
    			
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
    public Integer c(Integer a, Integer b) {
    	return a - b;
    }
    //Comparator<Integer> comparator = Collections.sort();
    int binarySearch(ArrayList<Integer> thisList, int x) {
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
    
static ArrayList<Integer> removeOldValue(ArrayList<Integer> thisList, int x) {
    	
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
static ArrayList<Integer> insertNewValue(ArrayList<Integer> thisList, int x) {
	
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
    
    static double getMedian(ArrayList<Integer> subArray) {
    	
    	if(subArray.size() % 2 == 0) {
    		double sum = subArray.get(subArray.size()/2) + subArray.get(subArray.size()/2 - 1);
    		return sum/2;
    	}
    	else {
    		return subArray.get((int) Math.floor(subArray.size()/2));
    	}
    	 	
    }
    static ArrayList<Integer> getSubArrayList(int[] arr, int startIndex, int endIndex) {
    	//Initialize subArray ArrayList
    	ArrayList<Integer> subArray = new ArrayList<Integer>();
  
    	//Start the for loop to populate the new ArrayList using the old array
    	//initialized at given beginning index, end at given ending index
    	for(int i = startIndex; i < endIndex + 1; i++) {
    		subArray.add(arr[i]);
    	}
    	//Return the new ArrayList
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
