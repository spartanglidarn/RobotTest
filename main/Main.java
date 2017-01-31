package main;
import gui.Frame;
import robot.BoardBuild;
import robot.Robot;

public class Main {

	public static void main(String[] args) {


		//Build board and robot
		BoardBuild bb = new BoardBuild(1, 1);
		//Set default values for Robot
		Robot.setPosX(1);
		Robot.setPosY(1);
		Robot.setDirection("n");
		
		//Build GUI
		Frame gui = new Frame("testing");

	}

	
}
	
