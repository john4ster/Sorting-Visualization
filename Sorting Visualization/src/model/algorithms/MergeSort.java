package model.algorithms;

import view.Visualization;

/* Merge Sort is a divide and conquer algorithm. It divides an array into two smaller
 * arrays. It does this recursively until it cannot break the arrays down any further
 * (so until it has a bunch of arrays with one element). It then uses a merge function
 * to merge all the arrays back up, until they make up one array.
 */

public class MergeSort extends SortAlgorithm {
	
	public MergeSort(Visualization visual, int[] data) {
		super(visual, data);
	}

	public void runMergeSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		}
		
		//Find the midpoint
		int midpoint = (leftIndex + (rightIndex - 1)) / 2;
		//Break down the two halves recursively until it can't anymore
		runMergeSort(array, leftIndex, midpoint);
		runMergeSort(array, midpoint + 1, rightIndex);
		
		//Merge the arrays
		merge(array, leftIndex, midpoint, rightIndex);
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        visual.repaint();
	}
	
	public void merge(int[] array, int left, int midpoint, int right) {
		
		//Get the sizes of the sub arrays to be merged
		int leftSize = midpoint - left + 1;
		int rightSize = right - midpoint;
		
		//Create temporary arrays
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		
		//Copy data into temporary arrays
		for (int i = 0; i < leftSize; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArray[j] = array[midpoint + 1 + j];
        
        //Merge the temporary arrays
        //Indexes to move throughout the left and right arrays
        int leftIndex = 0;
        int rightIndex = 0;
        
        //Initial index of merged array
        int k = left;
        
        while (leftIndex < leftSize && rightIndex < rightSize) {
        	if (leftArray[leftIndex] < rightArray[rightIndex]) {
        		array[k] = leftArray[leftIndex];
        		leftIndex++;
        	}
        	else {
        		array[k] = rightArray[rightIndex];
        		rightIndex++;
        	}
        	k++;
        }
        
        //Copy remaining elements of left array if there are any
        while (leftIndex < leftSize) {
        	array[k] = leftArray[leftIndex];
        	leftIndex++;
        	k++;
        }
        
        //Copy remaining elements of right array if there are any
        while (rightIndex < rightSize) {
        	array[k] = rightArray[rightIndex];
        	rightIndex++;
        	k++;
        }
	}
	
	@Override
	public void runSort() {
		int leftIndex = 0; //Leftmost index of the array
		int rightIndex = data.length - 1; //Rightmost index of the array
		runMergeSort(data, leftIndex, rightIndex);
	}
}
