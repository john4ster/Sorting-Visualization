package model.algorithms;

import view.Visualization;

/* Selection Sort sorts an array by finding the smallest element to the right of the current
 * element and swapping the smallest element with the current element. The current element
 * starts at the beginning, and moves throughout the array.
 */

public class SelectionSort extends SortAlgorithm {

	public SelectionSort(Visualization visual, int[] data) {
		super(visual, data);
	}
	
	public void runSelectionSort() {
		int arrayLength = data.length;
		
		//Move throughout the array, i being the current smallest value's index
		for (int i = 0; i < arrayLength - 1; i++) {
			int currMin = i;
			//Look at the rest of the array and compare current element to each
			for (int j = i+1; j < arrayLength; j++) {
				//New currIndex is the smallest element found on the right
				if (data[j] < data[currMin]) {
					currMin = j;
				}
			}
			//Swap the smallest element with the currIndex element
			if (currMin != i) {
				swap(data[i], data[currMin], i, currMin);
			}
		}
	}
	
	@Override
	public void runSort() {
		runSelectionSort();
	}
	
}
