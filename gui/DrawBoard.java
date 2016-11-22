package gui;

import java.awt.Color;

import robot.BoardBuild;
import robot.Robot;

public class DrawBoard {
	
	public DrawBoard(BoardBuild bb, Robot rob, int x, int y){
		
		for (int i = 0 ; i < bb.getXAxis() ; i++) {
			
			for (int a = 0 ; a < bb.getYAxis() ; a++) {
				
				Square box = DrawSquare(rob, i, a);
				
				//boxPanel.add(box);
			}
			
		}
	}
	
	public Square DrawSquare(Robot rob, int x, int y){
				
		Square box;

		if (x == rob.getPosY() && y == rob.getPosX()){
			box = new Square(Color.black);
		} else {
			box = new Square(Color.white);
		}
		
		return box;	
	}
	

	
}
