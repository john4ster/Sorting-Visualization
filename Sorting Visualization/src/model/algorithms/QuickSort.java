package model.algorithms;

import view.Visualization;

/* Quick Sort is a divide and conquer algorithm that picks an element as a pivot.
 * It uses this pivot and then puts smaller elements than the pivot on the left, and
 * larger elements on the right. It continues to do this recursively until the 
 * algorithm is sorted.
 */ 

public class QuickSort extends SortAlgorithm {

	public QuickSort(Visualization visual, int[] data) {
		super(visual, data);
	}
	
	public void runQuickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			runQuickSort(array, low, pivotIndex - 1);
			runQuickSort(array, pivotIndex + 1, high);
		}
	}
	
	public int partition(int[] array, int low, int high) {
		
		int pivot = array[high];
		
		int i = low - 1;
		
		for (int j = low; j<= high - 1; j++) {
			if (array[j] <= pivot) {
				i++;
				swap(array[i], array[j], i, j);
			}
		}
		swap(array[i+1], array[high], i+1, high);
		
		
		return (i + 1);
	}
	
	@Override
	public void runSort() {
		int low = 0;
		int high = data.length - 1;
		runQuickSort(data, low, high);
	}
	
}
