package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame {
	
	public Frame (String sTxt) {
		
		setLayout (new GridLayout(2,1));
		getContentPane().setBackground(Color.lightGray);
		
		JTextArea textArea = new JTextArea(20, 60);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		JPanel btnPane = new JPanel();


		
		add(btnPane);
		add(scrollPane);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
	

	
}
