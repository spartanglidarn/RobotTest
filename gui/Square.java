package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Square extends JLabel{
	
	public Square(Color col){
		setPreferredSize(new Dimension(50, 50));
		setVisible(true);
		setOpaque(true);
		setBackground(col);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

}
