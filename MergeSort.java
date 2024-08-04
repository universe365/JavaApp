
import java.time.Instant;

/**
 * This class produce merge sort from https://www.geeksforgeeks.org/merge-sort/
 * 
 */
public class MergeSort extends AbstractSort{
	
	private int count;
	private long start;
	private long finish;
	private long timeElapsed;
	private int[] array;
	private int n;
	
	
	public static void main(String[] args) {
//		int arr[] = { 12, 11, 13, 5, 6, 7,12, 11, 13, 5, 6, 7,12, 11, 13, 5, 6, 7,12, 11, 13, 5, 6, 7,12, 11, 13, 5, 6, 7,12, 11, 13, 5, 6, 7 };
//
//        System.out.println("Given array is");
//        printArray(arr);
//
//        MergeSort ob = new MergeSort(arr);
//
//        System.out.println("\nSorted array is");
//        printArray(arr);
	}
	
	public MergeSort(int[] array) {
		this.array = array;
		n= array.length;
//		System.out.println("count:"+getCount()+", time:"+getTime());
	}

	 // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
    	incrementCount();
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
            
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            
        }
        
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

	

	@Override
	void sort(int[] array, int n) {
		sort(array, 0, n-1);
	}

	@Override
	void startSort() {
		count =0;
		start= Instant.now().getNano();
		System.out.print("start:"+start);
		
	}

	@Override
	void endSort() {
		finish= Instant.now().getNano();
		timeElapsed= finish-start;
		System.out.print("\tfinish:"+ finish);
		System.out.println("\ttime elapsed: "+ timeElapsed);
		
	}

	@Override
	void incrementCount() {
		count++;
	}

	@Override
	int getCount() {
		return count;
	}

	@Override
	long getTime() {
		return timeElapsed;
	}

}
