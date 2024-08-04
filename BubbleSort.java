
import java.time.Instant;

/**
 * this class produce bubble sort and use it in BenchmarkSorts.
 * the class extends AbstractSort and stores some values that will be used in BenchmarkSorts.
 * the source code comes from https://www.geeksforgeeks.org/bubble-sort-algorithm/
 */
public class BubbleSort extends AbstractSort{
	private int count;
	private long start;
	private long finish;
	private long timeElapsed;
	private int[] array;
	private int n;
	
	public static void main(String[] args){
		int[] arr = {100,20,30,50,40,60,80,90,70,10};
		int n = arr.length;
		BubbleSort b= new BubbleSort(arr);
		b.sort(arr, n);
		b.printSort(arr);


		// b.checkArr(arr);
	}
	
	public BubbleSort(int[] arr) {
	}
	
	// this code comes from https://www.geeksforgeeks.org/recursive-bubble-sort/
	// Iterative Bubble Sort
	 // A function to implement bubble sort 
	@Override
	void sort(int[] array, int n) {
		// Base case 
        if (n == 1) {
        	return;
        }
             
  
        
        // One pass of bubble sort. After 
        // this pass, the largest element 
        // is moved (or bubbled) to end. 
        for (int i=0; i<n-1; i++) {
            if (array[i] > array[i+1]) 
            { 
                // swap arr[i], arr[i+1] 
                int temp = array[i]; 
                array[i] = array[i+1]; 
                array[i+1] = temp;
//                System.out.print("\n"+getCount()+"\n");
                incrementCount();
            }
        }
        
  
          // Check if any recursion happens or not 
          // If any recursion is not happen then return 
         if (getCount() == 0) 
            return; 
  
        // Largest element is fixed, 
        // recur for remaining array 
        sort(array, n-1); 
		
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
	
	void printSort(int[] arr) {
		for(int i: arr) {
			System.out.print(i+"\t");
		}
	}
	


}
