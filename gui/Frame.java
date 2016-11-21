package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import robot.BoardBuild;
import robot.Robot;

public class Frame extends JFrame {

	
	public Frame (String sTxt, BoardBuild bb, Robot rob) {
		
		boolean alive = true;
		
		setLayout (new GridLayout(2,1));
		setSize(200, 200);
		getContentPane().setBackground(Color.lightGray);
		
		JTextArea textArea = new JTextArea(10, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		int boardX = bb.getXAxis();
		int boardY = bb.getYAxis();
		String[][] board = bb.getBoard();
		
		//create panels to put swing objects in
		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new GridLayout(boardX, boardY));
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(3, 1));
		
		JPanel txtPanel = new JPanel();
		txtPanel.setLayout(new GridLayout(3, 2));
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 1));
		
		//create the matrix based on how the board is built.
		while (alive) {
			for (int i = 0 ; i < bb.getXAxis() ; i++) {
				
				for (int a = 0 ; a < bb.getYAxis() ; a++) {
					Square box;
					if (a == rob.getPosY() && i == rob.getPosX()){
						box = new Square(Color.black);
					} else {
						box = new Square(Color.white);
					}
					boxPanel.add(box);
				}
				
			}
			this.getContentPane().validate();
			this.getContentPane().repaint();
		}
		JLabel lSize = new JLabel("Size:");
		JTextField tfSize = new JTextField();
		JLabel lFirstPos = new JLabel("First position:");
		JTextField tfFirstPos = new JTextField();
		JLabel lWalk = new JLabel("Walk:");
		JTextField tfWalk = new JTextField();
		
		//JButton sendBtn = new JButton("Send!");
		Send sendBtn2 = new Send(textArea);
		
		btnPanel.add(sendBtn2);
		
		txtPanel.add(lSize);
		txtPanel.add(tfSize);
		txtPanel.add(lFirstPos);
		txtPanel.add(tfFirstPos);
		txtPanel.add(lWalk);
		txtPanel.add(tfWalk);
		
		bottomPanel.add(txtPanel);
		bottomPanel.add(scrollPane);
		bottomPanel.add(btnPanel);
		
		
		add(boxPanel);
		add(bottomPanel);

		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

			
	}
	
	
}
