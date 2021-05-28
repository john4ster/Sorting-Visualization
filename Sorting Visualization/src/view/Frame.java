package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Frame extends JFrame {

	Visualization visual; //JPanel to display the visualization
	Menu menu; //Menu that lets the user select an algorithm
	
	public Frame(int width, int height) {
		
		//Create the frame
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Sorting Visualization");
		this.setLayout(new BorderLayout());
		
		//Create the visualization JPanel
		visual = new Visualization(width, height);
		visual.setPreferredSize(new Dimension(width, height));
		this.add(visual);
				
		//Make the frame visible
		this.pack();
		this.setVisible(true);
	}
	
}
