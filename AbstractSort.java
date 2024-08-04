

abstract class AbstractSort {
	
	

	public AbstractSort() {
		
	}
	
	abstract void sort(int[] array, int n);
	
	abstract void startSort();
	
	/**
	 * called after the sort ends and it should compute the elapsed time of the sort
	 */
	abstract void endSort();
	/**
	 * called whenever the critical operation that selected is executed and it should increment the critical operation counter
	 */
	abstract void incrementCount();
	/**
	 * 
	 * @return return the final value of the counter
	 */
	abstract int getCount();
	/**
	 * 
	 * @return the elapsed time
	 */
	abstract long getTime();

}
