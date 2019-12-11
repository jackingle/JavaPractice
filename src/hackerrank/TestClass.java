package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class TestClass {
	public static void main(String[] args) {
		int[] arr1 = new int[]{2, 3, 4, 2}; 
		int[] arr2 = new int[]{3, 4, 2, 3}; 
		int[] arr3 = new int[]{4, 2, 3, 6}; 
		int[] arr4 = new int[]{2, 3, 6, 8};
		
		HashMap<Integer, Integer> map1 = getSubMap(arr1, 0, arr1.length-1);
		HashMap<Integer, Integer> map2 = getSubMap(arr2, 0, arr2.length-1);
		HashMap<Integer, Integer> map3 = getSubMap(arr3, 0, arr3.length-1);
		HashMap<Integer, Integer> map4 = getSubMap(arr4, 0, arr4.length-1);
		
		double m = getMedian(map1, arr1.length);
		double m2 = getMedian(map2, arr2.length);
		double m3 = getMedian(map3, arr3.length);
		double m4 = getMedian(map4, arr4.length);
		
		System.out.println(m);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		
		
	}
	
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
	static double getMedian(HashMap<Integer, Integer> subMap, int windowLength) {
    	Set<Integer> keySet = subMap.keySet();
    	Integer[] sortedKeySet = new Integer[keySet.size()];
    	subMap.keySet().toArray(sortedKeySet);
	 	Arrays.sort(sortedKeySet);
	 	for(int i : sortedKeySet) {
	 		System.out.print(i+":"+subMap.get(i)+" ");
	 	}
	 	System.out.println();
	 	int loRange = 0, hiRange = 0;
	 	boolean hiRangeAssigned = false;
	 	int leftRangeIndex=windowLength/2-1;
	 	int rightRangeIndex=windowLength/2;
	 	for(int i = 0; i < sortedKeySet.length; i++) {
	 		int key = sortedKeySet[i];
	 		System.out.println("current key: "+key+",current range: "+loRange+"->"+hiRange+", range indices: "+leftRangeIndex+","+rightRangeIndex);
	 		if(!hiRangeAssigned) {
	 			hiRange = subMap.get(key) - 1;
	 			hiRangeAssigned = true;
	 		}
	 		else {
	 			System.out.println("hi"+hiRange+"lo"+loRange);
	 			loRange = hiRange + 1;
	 			hiRange = loRange + subMap.get(key) - 1;
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
	
	
	
}
