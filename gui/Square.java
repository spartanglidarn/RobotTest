package gui;

import java.awt.Rectangle;

import javax.swing.JPanel;
import gui.Frame;

public class Square extends JPanel{
	
	public static Rectangle addSquare(){
		Rectangle rect = new Rectangle(10, 10, 20, 20);
		return rect;
		//Frame.add(rect);
	}

}
