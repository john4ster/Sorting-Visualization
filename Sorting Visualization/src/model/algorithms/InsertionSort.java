package model.algorithms;

import view.Visualization;

/* Insertion Sort has a sorted part and unsorted part. It looks at the first value in the
 * unsorted part, and puts it in the appropriate spot in the sorted part. It continues to do
 * this until the whole array is sorted.
 */

public class InsertionSort extends SortAlgorithm {

	public InsertionSort(Visualization visual, int[] data) {
		super(visual, data);
	}
	
	public void runInsertionSort() {
		int arrayLength = data.length;
		for (int i = 1; i < arrayLength; i++) {
			//Select value that will be inserted
			int insertValue = data[i];
			//Where the value will be inserted
			int insertPosition = i - 1;
			
			//Figure out where the correct position to insert the new value is
			while (insertPosition >= 0 && data[insertPosition] > insertValue) {
				data[insertPosition + 1] = data[insertPosition];
				insertPosition--;
				updateVisual(); //Update the visualization
			}
			//Insert the number at the insert position
			data[insertPosition + 1] = insertValue;
		}
	}
	
	@Override
	public void runSort() {
		runInsertionSort();
	}

}
