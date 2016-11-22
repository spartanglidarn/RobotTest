package main;
import gui.Frame;
import robot.BoardBuild;
import robot.Robot;

public class Main {

	public static void main(String[] args) {

		//Take in the size of the matrix from the user and convert it to a string
		String matrixSize ="9 9";
		String [] msArr = matrixSize.split(" ");
		int x = Integer.parseInt(msArr[0]);
		int y = Integer.parseInt(msArr[1]);
		
		//First position
		String firstPos = "3 3 N";
		String [] fpArr = firstPos.split(" ");
		int fpX = Integer.parseInt(fpArr[0]);
		int fpY = Integer.parseInt(fpArr[1]);
		fpX -= 1;
		fpY -= 1;
		
		//Build board and robot
		BoardBuild bb = new BoardBuild(x, y);
		Robot rob = new Robot(fpX , fpY , fpArr[2]);
		
		//Build GUI
		Frame gui = new Frame("testing");
	
		
		//movement directions
		String movement = "LGGRGRGRGGRG";
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

	}

	
}
	
