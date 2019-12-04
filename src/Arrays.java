
public class Arrays {
	public static int[] num;
	public static String a[] = new String[6]; {
	a[0] = "a";
	a[1] = "b";
	a[2] = "c";
	a[3] = "d";
	a[4] = "e";
	a[5] = "f";
	}
	public static int[] b = new int[6]; {
	b[0] = 1;
	b[1] = 2;
	b[2] = 3;
	b[3] = 4;
	b[4] = 5;
	b[5] = 6;
	}
	int c[][] = new int[3][3]; {
		c[0][0] = 1;
		c[0][1] = 2;
		c[0][2] = 3;
		 
		c[1][0] = 4;
		c[1][1] = 5;
		c[1][2] = 6;
		
		c[2][0] = 7;
		c[2][1] = 8;
		c[2][2] = 9;
	}
	int d[][] = new int[10][10]; {
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 10; j++) {
			System.out.printf("X ", d[i][j]);
		}
		System.out.println();
	}
}
	public static int[] e = new int[6]; {
		e[0] = 1;
		e[1] = 2;
		e[2] = 3;
		e[3] = 4;
		e[4] = 5;
		e[5] = 6;
		}
//	public Arrays(int[] x) {
//		for(int i=0; i < x.length; i++) {
//			System.out.println(x[i] + "a ");
//		}
//	}
	//SORTING ALGORITHMS
static class SelectionSort {
	public void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min])
					min = j;
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	public void printArray(int[] arr) {
		
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");
		System.out.println();
	}
}
public static int[] reverseArray(int[] arr) {
	for (int i : arr)
		System.out.print(i + " ");
	System.out.println();
	for(int i = 0; i < arr.length/2; i++) {
		System.out.println(arr[i] + " " + arr[arr.length - 1 - i]);
		int temp = arr[i];
		arr[i] = arr[arr.length - 1 - i];
		arr[arr.length - 1 - i] = temp;
		System.out.println(arr[i] + " " + arr[arr.length - 1 - i]);
	}
	System.out.println();
	for (int i : arr)
		System.out.print(i + " ");
	System.out.println("Oh hi Mark");
	return arr;
}
	
	//SEARCH ALGORITHMS
	
	public static int interpolationSearch(int[] arr, int x) {
		int lo = 0, hi = (arr.length - 1); 
		while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
			if (lo == hi) {
				if (arr[lo] == x) return lo;
				return -1;
			}
			int pos = lo + (((hi-lo) /
					(arr[hi]-arr[lo]))*(x - arr[lo]));
			if (arr[pos] == x)
				return pos;
			if (arr[pos] < x)
				lo = pos + 1;
			else hi = pos - 1;
		}
		return -1;
	}
	
	public static int jumpSearch(int[] arr, int x) {
		int n = arr.length;
		int step = (int)Math.floor(Math.sqrt(n));
		int prev = 0;
		while (arr[Math.min(step,  n)-1] < x) {
			prev = step;
			step += (int)Math.floor(Math.sqrt(n));
			if (prev >= n)
				return -1;
		}
		while (arr[prev] < x) {
			prev++;
			if (prev == Math.min(step, n))
				return -1;
		}
		if (arr[prev] == x)
			return prev;
		return -1;
	}
	
	public static int binarySearch(int arr[], int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);
			return binarySearch(arr, mid + 1, r, x);
		}
		return -1;
	}
	int iBinarySearch(int arr[], int x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == x)
            	return m;
  
            // If x greater, ignore left half 
            if (arr[m] > x)
            	l = m + 1;
  
            // If x is smaller, ignore right half 
            else
            	r = m - 1;
        } 
  
        // if we reach here, then element was 
        // not present 
         return -1;
    } 
	

	public static int search(int arr[], int x) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(arr[i] == x)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        
        int arr[] = { 2, 3, 4, 10, 40, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55 }; 
        int n = arr.length; 
        int x = 1; 
        System.out.println(x + " is the number we are looking for in the array");
        System.out.println(n + " is the array length" + "\n");
        
        System.out.println("Selection Sort" + "\n");
        //Selection Sort
        SelectionSort ob = new SelectionSort();
        ob.selectionSort(arr);
        ob.printArray(arr);
        System.out.println("REVERSED ARRAY");
        
        arr = Arrays.reverseArray(arr);
        for(int i : arr)
        	System.out.print(i+" ");
        System.out.println();
        
        System.out.println("Interpolation Search");
        //Interpolation Search
        int index2 = interpolationSearch(arr, x);
        if (index2 != -1) 
            System.out.println("Element found at index " + index2); 
         else
            System.out.println("Element not found.");
        System.out.println();
        
        System.out.println("Jump Search");
        //Jump Search
        int index = jumpSearch(arr, x);
        System.out.println("Number " + x + 
        		" is at index " + index);
        System.out.println();
        
        System.out.println("Binary Search");
        //Binary Search
        int result = binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
		System.out.println();
        
        System.out.println("Linear Search");
        //Linear Search
		int result2 = search(arr, x);
		if (result2 == -1)
			System.out.println("Element is not present");
		else
			System.out.println("Element is present");
		System.out.println();
//		String a[] = new String[6]; {
//			a[0] = "a";
//			a[1] = "b";
//			a[2] = "c";
//			a[3] = "d";
//			a[4] = "e";
//			a[5] = "f";
//			}
//		
//		for(int i=0; i < a.length; i++) {
//			System.out.println(a[i] + " ");
//		}
	}
	

}
