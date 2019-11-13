
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
        int x = 45; 
        System.out.println(n);
        //Interpolation Search
        int index2 = interpolationSearch(arr, x);
        if (index2 != -1) 
            System.out.println("Element found at index " + index2); 
         else
            System.out.println("Element not found.");
        //Jump Search
        int index = jumpSearch(arr, x);
        System.out.println("\nNumber " + x + 
        		" is at index " + index);
        
        //Binary Search
        int result = binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
		
        //Linear Search
		int result2 = search(arr, x);
		if (result2 == -1)
			System.out.println("Element is not present");
		else
			System.out.println("Element is present");
		
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
