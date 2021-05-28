package model.algorithms;
import view.Visualization;

/* Bubble Sort is an algorithm that goes through an array and compares two items
 * next to each other to see which one is out of order. If they are out of order,
 * the two values are swapped. It continues doing this throughout the array, allowing
 * larger values to "bubble up" through the array. It continues to iterate through
 * the array until the array is fully sorted. 
 */

public class BubbleSort extends SortAlgorithm {
	
	public BubbleSort(Visualization visual, int[] data) {
		super(visual, data);
	}
	
	//Run the bubble sort
	public void runBubbleSort() {
		//Makes sure it goes through all necessary cycles to sort the array
		for (int i = 0; i < data.length - 1; i++) { 
			//For loop for each cycle
			for (int j = 0; j < data.length - 1; j++) {
				int a = data[j];
				int b = data[j + 1];
				if (a > b) { //If a is greater than b, swap them
						swap(a, b, j, j+1);
				}
			}
		}
	}

	@Override
	public void runSort() {
		runBubbleSort();
	} 
	
	//Method to return the array to be used in the visualization
	public int[] getArray() {
		return data;
	}
}
