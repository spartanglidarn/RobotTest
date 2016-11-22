package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import robot.BoardBuild;
import robot.Robot;

public class Frame extends JFrame implements ActionListener{
	
	//send button
	private JButton sendBtn = new JButton("Send!");
	
	//text area that is put in a scroll pane
	private JTextArea textArea = new JTextArea(10, 40);
	private JScrollPane scrollPane = new JScrollPane(textArea);
	
	// Panels that holds the elements
	private JPanel boxPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel txtPanel = new JPanel();
	private JPanel btnPanel = new JPanel();
	
	// Text fields that take size, first position and walk commands
	private JLabel lSize = new JLabel("Size:");
	private JTextField tfSize = new JTextField();
	private JLabel lFirstPos = new JLabel("First position:");
	private JTextField tfFirstPos = new JTextField();
	private JLabel lWalk = new JLabel("Walk:");
	private JTextField tfWalk = new JTextField();
	
	public Frame (String sTxt) {
		
		//Set frame layout, size and bg color
		setLayout (new GridLayout(2,1));
		setSize(200, 200);
		getContentPane().setBackground(Color.lightGray);
		
		//Set layouts for the panels 
		//boxPanel.setLayout(new GridLayout(BoardBuild.getXAxis(), BoardBuild.getYAxis()));
		bottomPanel.setLayout(new GridLayout(3, 1));
		txtPanel.setLayout(new GridLayout(3, 2));
		btnPanel.setLayout(new GridLayout(1, 1));
		
		//Draw the matrix
		drawMatrix();
		
		//add send button
		sendBtn.addActionListener(this);
		btnPanel.add(sendBtn);
		
		//add to text panel
		txtPanel.add(lSize);
		txtPanel.add(tfSize);
		txtPanel.add(lFirstPos);
		txtPanel.add(tfFirstPos);
		txtPanel.add(lWalk);
		txtPanel.add(tfWalk);
		
		//add to bottom panel
		bottomPanel.add(txtPanel);
		bottomPanel.add(scrollPane);
		bottomPanel.add(btnPanel);
		
		//add to the frame
		add(boxPanel);
		add(bottomPanel);

		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
	
	public void actionPerformed (ActionEvent e){
		if (e.getSource() == sendBtn){
			//Take in the size of the matrix from the user and convert it to a string den set the matrix size
			String userSize = tfSize.getText();
			String [] userSizeArr = userSize.split(" ");
			int x = Integer.parseInt(userSizeArr[0]);
			int y = Integer.parseInt(userSizeArr[1]);
			
			BoardBuild.setXAxis(x);
			BoardBuild.setYAxis(y);
			
			//First position
			String firstPos = tfFirstPos.getText();
			String [] fpArr = firstPos.split(" ");
			int fpX = Integer.parseInt(fpArr[0]);
			int fpY = Integer.parseInt(fpArr[1]);
			fpX -= 1;
			fpY -= 1;
			
			Robot.setPosX(fpX);
			Robot.setPosY(fpY);
			Robot.setDirection(fpArr[2]);
			//Movement
			
			//movement directions
			String movement = tfWalk.getText();
			String [] movArr = movement.split("");
			
			//send the directions to robot
			for (String a : movArr){
				switch(a.toLowerCase()) {
					case "l":
					case "r":
						Robot.moveDir(a);
						break;
					case "g":
						Robot.moveStep();
						break;
					default: 
						System.out.println("Error: Wrong movment in main");
						break;
				}		
			}

			
			//re-draw the matrix
			drawMatrix();
			this.getContentPane().validate();
			this.getContentPane().repaint();
			
			textArea.append("Robot position x: "+ (Robot.getPosX()+1) +"\n");
			textArea.append("Robot position y: " + (Robot.getPosY()+1) + "\n");
			textArea.append("Robot direction: " + Robot.getDirection() + "\n");
			textArea.append("------------------------------------------\n");
			
		}
	}
	
	public void drawMatrix(){
		//remove everything in boxPanel
		boxPanel.removeAll();
		//build a new grid
		boxPanel.setLayout(new GridLayout(BoardBuild.getXAxis(), BoardBuild.getYAxis()));
		//fill the grid with new boxes
		for (int i = 0 ; i < BoardBuild.getXAxis() ; i++) {
			for (int a = 0 ; a < BoardBuild.getYAxis() ; a++) {
				Square box;
				if (a == Robot.getPosY() && i == Robot.getPosX()){
					box = new Square(Color.black);
				} else {
					box = new Square(Color.white);
				}
				boxPanel.add(box);
			}
			
		}
		
	}
	
}
