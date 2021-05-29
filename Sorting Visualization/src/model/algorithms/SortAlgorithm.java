package model.algorithms;

import view.Visualization;

// Abstract class that all the sorting algorithms inherit from

public abstract class SortAlgorithm {

	Visualization visual; //Visualization class to communicate with the visualization
	int[] data; //Array to sort
	
	SortAlgorithm(Visualization visual, int[] data) {
		this.visual = visual;
		this.data = data;
	}
	
	//Method that will call each individual sorting algorithm's sort method
	public void runSort() {};
	
	//Method to swap two elements in an array
	public void swap(int a, int b, int firstIndex, int secondIndex) {
		data[firstIndex] = b;
		data[secondIndex] = a;
		
		//Update the visualization
		updateVisual();
	};
	
	//Pauses this thread so the visualization can catch up
	public void updateVisual() {
		//Make this thread sleep so the user can see each swap in the visualization
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		visual.repaint();
	}
	
}
