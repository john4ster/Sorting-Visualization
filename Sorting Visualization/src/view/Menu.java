package view;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//Menu class to allow the user to select an algorithm

public class Menu extends JPanel {

	JComboBox selectAlgorithm; //Combo box for the user to select an algorithm
	JButton start; //Button to start the algorithm
	JButton randomize; //Button to randomize the array
	Visualization visual; //Variable used to communicate with the visualization
	
	public Menu(Visualization visual) {
		//Initialize visual to communicate with the visualization
		this.visual = visual;
		//Initialize and add the combo box, start button, and randomize button
		String [] algorithms = {"Bubble Sort", "Merge Sort", "Quick Sort"};
		selectAlgorithm = new JComboBox(algorithms);
		this.add(selectAlgorithm);
		start = new JButton("Start");
		start.addActionListener(buttonPressed);
		this.add(start);
		randomize = new JButton("Randomize");
		randomize.addActionListener(buttonPressed);
		this.add(randomize);
		//Set background
		this.setBackground(Color.BLACK);
	}
	
	//Get the selected option so the visualization can decide which algorithm to use
	public String getSelectedOption() {
		return (String) selectAlgorithm.getSelectedItem();
	}
	
	//When the button is pressed, start the visualization
	ActionListener buttonPressed = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == start) {
				visual.startVisualization();
			}
			else if (e.getSource() == randomize) {
				visual.randomizeArray();
			}
		}
	};
	
}
