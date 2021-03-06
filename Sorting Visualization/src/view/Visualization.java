package view;

import model.algorithms.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

/* This class is the visualization of the sorting algorithms. The visualization shows the 
 * array as a list of bars, with taller bars being larger numbers. So, once an array is
 * sorted, it will look like a staircase shape, from least to greatest.
 */

public class Visualization extends JPanel {

	int windowWidth;
	int windowHeight;
	int numElements; // Number of elements in the array
	Menu menu; //Menu for the user to select an algorithm
	SwingWorker algorithmThread; //Background thread that will run the algorithm
	int[] data; //Array to sort
	BubbleSort bubbleSort;
	MergeSort mergeSort;
	QuickSort quickSort;
	SelectionSort selectionSort;
	InsertionSort insertionSort;
	
	public Visualization(int width, int height) {
		//Initialize variables
		this.windowWidth = width;
		this.windowHeight = height;
		numElements = 100;
		//Create and randomize the array
		data = createArray();
		randomizeArray();
		//Create algorithm instances
		initializeAlgorithms();
		//Set up the menu to select and start the algorithms
		menu = new Menu(this);
		this.add(menu);
	}
	
	//Start the algorithm
	public void startVisualization() {
		//Set up the swing worker algorithmThread to run the algorithm
		algorithmThread = new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {
				//Runs whatever the current algorithm is on the algorithm thread
				getSelectedAlgorithm().runSort(); 
				return null;
			}
		};
		algorithmThread.execute();
	}
	
	//Creates the array
	public int[] createArray() {
		int[] array = new int[numElements];
		for (int i = 0; i < numElements; i++) {
			array[i] = i;
		}
		return array;
	}
	
	//Randomizes the array
	public void randomizeArray() {
		Random random = new Random();
		for (int i = 0; i < numElements; i++) {
			int randomIndex = random.nextInt(numElements);
			data[randomIndex] = i;
		}
		repaint();
	}
	
	//Initialize the algorithm instances
	public void initializeAlgorithms() {
		bubbleSort = new BubbleSort(this, data);
		mergeSort = new MergeSort(this, data);
		quickSort = new QuickSort(this, data);
		selectionSort = new SelectionSort(this, data);
		insertionSort = new InsertionSort(this, data);
	}
	
	//Decide which algorithm to run based on the combo box
	public SortAlgorithm getSelectedAlgorithm() {
		if (menu.getSelectedOption().equals("Bubble Sort")) {
			return bubbleSort;
		}
		else if (menu.getSelectedOption().equals("Merge Sort")){
			return mergeSort;
		}
		else if (menu.getSelectedOption().equals("Quick Sort")) {
			return quickSort;
		}
		else if (menu.getSelectedOption().equals("Selection Sort")){
			return selectionSort;
		}
		else {
			return insertionSort;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.setBackground(Color.BLACK);
		
		//Draw the visualization based on the array
		g.setColor(Color.WHITE);
		for (int i = 0; i < data.length; i++) {
			int barWidth = 10;
			int barHeight = data[i] * 5;
			int x = (barWidth * i);
			int y = windowHeight - barHeight;
			g.fillRect(x, y, barWidth, barHeight);
		}
	}
	
}
