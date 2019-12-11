import java.util.HashMap;
import java.util.Vector;

public class MultiThreadPalindrome implements Runnable {
	static HashMap<MultiThreadPalindrome, Integer> threadIDMap = new HashMap<MultiThreadPalindrome, Integer>();
	static Vector<Boolean> checkVector = new Vector<Boolean>();
	static public ThreadGroup group = new ThreadGroup("PalCheck");
	int threadID;
	static int divisions = 10;
	static int threadCount = divisions /2;
	static Thread finalThread;
	static int finishedThreadCount = 0;
	
	public static void main(String[] args) {
	
		for(int i = 1; i < threadCount + 1; i++) {
			MultiThreadPalindrome obj = new MultiThreadPalindrome();
			obj.threadID = i;
			Thread process = new Thread(obj);
			process.start();
			if (i == threadCount) {
				finalThread = process;
				}
			}
			
			
			//System.out.println(group.toString());
	//		threadIDMap.put(obj, 1);
	//		threadIDMap.put(obj1, 2);
	//		threadIDMap.put(obj2,  3);
	//		threadIDMap.put(obj3, 4);
	//		processAlpha.start();
	//		processBeta.start();
	//		processSigma.start();
	//		processDelta.setPriority(4);
	//		try {
	//			processDelta.sleep(1000);
	//		} catch (InterruptedException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		processDelta.start();
			
			
			
		}
	synchronized static void threadCount() {
		finishedThreadCount++;
		
	}
	static Character[] palindrome = new Character[] {'t', 'o', 'y', 'o', 't', 'a', 'r', 'a', 'c', 'e', 'c', 'a', 'r', 'a', 't', 'o', 'y', 'o', 't'};
	
	static Character[] newPalindrome = convertString(makeString());
	
	static String makeString() {
		StringBuilder newString = new StringBuilder(); 
		for(int i = 0; i < 1000000; i++) {
			newString.append("aaaaaaaaaaa");
		} 
		
		return newString.toString();
	}
	
	static Vector<Character> palVector1 = newVector(newPalindrome);
	int size = palindrome.length;
	int quarter = size / 4;
	int half = size / 2;
	static Vector<Character>  palVector = newVector(palindrome);
		
	public static Character[] convertString(String name) {
		
		Character[] arr = new Character[name.length()];
		for(int i = 0; i < name.length(); i++) {
			arr[i] = name.charAt(i);
		}
		return arr;
	}
		
		
	public static Vector<Character> newVector(Character[] thisVector) {
			
		
			Vector<Character> nVect = new Vector<Character>();
			for(int i = 0; i < thisVector.length; i++) {
				nVect.add(thisVector[i]);
			}
			
		return nVect;
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
			
			if(thisVector.get(i) != thisVector.get(thisVector.size() - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	static boolean check = true;
	
	@Override
	public void run() {
	
//		System.out.println(this.threadID);
//		System.out.println("Initialized"+threadID);
//		//System.out.println(checkQuadrant(palVector, threadID, 4));
		if(!checkQuadrant(palVector1, threadID, divisions)) {
			check = false;
		}
		//checkVector.add(checkQuadrant(palVector1, threadID, divisions));
		
		
		
//		System.out.println(checkVector);
//		System.out.println(checkVector.size());
		
		finishedThreadCount++;
		System.out.println(finishedThreadCount);
		if(finishedThreadCount == threadCount) {
			System.out.println(check);
			System.out.println(finishedThreadCount);
		}
		//System.out.println("Finished"+threadID);
		
		
		
	}
		
		
	}
	
	
	
	
	
	
	
	
	
	
