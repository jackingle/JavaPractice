import java.util.Vector;

public class MultiThreadPalindrome implements Runnable {
	
	public static void main(String[] args) {
		MultiThreadPalindrome obj = new MultiThreadPalindrome();
		
		
		System.out.println(obj.size);
		System.out.println(obj.quarter);
		System.out.println(obj.half);
	}
	Character[] palindrome = new Character[] {'t', 'o', 'y', 'o', 't', 'a', 'r', 'a', 'c', 'e', 'c', 'a', 'r', 'a', 't', 'o', 'y', 'o', 't'};
	Thread processAlpha = new Thread();
	Thread processBeta = new Thread();
	int size = palindrome.length;
	int quarter = size / 4;
	int half = size / 2;
	
	
public static Vector<Character> newVector(Character[] thisVector) {
		
	
		Vector<Character> nVect = new Vector<Character>();
		for(int i = 0; i < thisVector.length; i++) {
			nVect.add(thisVector[i]);
		}
		
	return nVect;
	}

public boolean oddCheckOutsideQuarters(Vector<Character> thisVector) {
	int j = thisVector.size();
	int segmentLength = thisVector.size() / 4;
	//i goes from 0 to 3rd index, j goes from 19 to 16th index
	for(int i = 0; i < (segmentLength); i++) {
		
		if (thisVector.get(i) == thisVector.get(j)) {
			
			j--;
			if(i == segmentLength && thisVector.get(segmentLength) == thisVector.get(j)) {
				return true;
			}
		}	
	}
	
	
	return false;
}
public boolean oddCheckInsideQuarters(Vector<Character> thisVector) {
	int segmentLength = thisVector.size() / 4;
	int j = thisVector.size() - segmentLength;
	
	//i goes from 4th to 7th index, j goes from 15th to 11th index
	for(int i = segmentLength; i < segmentLength * 2; i++) {
		
		if (thisVector.get(i) == thisVector.get(j)) {
			
			j--;
			if(i == segmentLength * 2 - 1 && thisVector.get((segmentLength * 2) - 1) == thisVector.get(j)) {
				return true;
			}
		}
	}
	
	return false;
}
public boolean oddCheckLastQuarter(Vector<Character> thisVector) {
	int segmentLength = thisVector.size() / 4;
	int j = thisVector.size() - segmentLength * 2;
	//i is 8, j is 10
	for(int i = segmentLength * 2; i < thisVector.size() / 2; i++) {
		j--;
		
		if(i = segmentLength * 2 && )
		
	}
	
	
	
	return false;
	
	
}

public boolean threadCheck(Vector<Character> thisVector, int pos) {
	
	
	
	return false;
}


//19, 1, 4
public int checkSegmentStartPosition(int vectorLength, int threadID, int divisions) {
	int numOfOperations = vectorLength / divisions; // 4
	int startIndex = (threadID - 1) * numOfOperations; // 0
	// 3 - 1 * 4 == 8
	//i == 8 
	return startIndex;
}

public boolean checkQuadrant(Vector<Character> thisVector, int threadID, int divisions) {
	
	int startIndex = checkSegmentStartPosition(thisVector.size(), threadID, divisions);
	
	for(int i = startIndex; i < startIndex + (thisVector.size() / divisions) && i < thisVector.size() / 2; i++) {
		
		if(i == thisVector.size() - i && thisVector.get(i) == thisVector.get(thisVector.size() - i)) {
			return true;
		}
	}
	
	return false;
}


@Override
public void run() {
	// TODO Auto-generated method stub
	
}
	
	
}
