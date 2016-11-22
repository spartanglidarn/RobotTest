package robot;
public class Robot {

	private static int posX = 0;
	private static int posY = 0;
	public static enum Dir{NORTH, EAST, SOUTH, WEST};
	private static Dir direction;
	
	public Robot (int posX, int posY, String dir) {
		//Set the board for this instance of robot

		System.out.println("BB X size. " + BoardBuild.getXAxis());
		System.out.println("BB Y size. " + BoardBuild.getYAxis());
		
		switch(dir.toLowerCase()){
		case "n":
			setDirection (Dir.NORTH);
			break;
		case "e":
			setDirection (Dir.EAST);
			break;
		case "s":
			setDirection (Dir.SOUTH);
			break;
		case "w":
			setDirection (Dir.WEST);
			break;
		default:
			System.out.println("Wrong direction when creating robot");
		}
		
		
		setPosX(posX);
		setPosY(posY);	
	
	}
	

	//Direction L will subtract from the direction and R will add to the Direction
	public static void moveDir (String turn) {
		
		switch(turn.toLowerCase()) {
		case "l":
			turnLeft();
			break;
		case "r":
			turnRight();
			break;
		default: 
			System.out.println("Wrong direction in moveDir");
			break;
		}
		
	}
	
	public static void turnLeft(){
		switch(getDirection()){
			case NORTH:
				setDirection(Dir.WEST);
				break;
			case EAST:
				setDirection(Dir.NORTH);
				break;
			case SOUTH:
				setDirection(Dir.EAST);
				break;
			case WEST:
				setDirection(Dir.SOUTH);
				break;
			default:
				System.out.println("Error in turnLeft method, Robot class");
		}
	}
	
	public static void turnRight() {
		switch (getDirection()){
			case NORTH:
				setDirection(Dir.EAST);
				break;
			case EAST:
				setDirection(Dir.SOUTH);
				break;
			case SOUTH:
				setDirection(Dir.WEST);
				break;
			case WEST:
				setDirection(Dir.NORTH);
				break;
			default:
				System.out.println("Error in turnRight method, Robot class");
		}
	}
	


	public static void moveStep () {
		int steps = 1;
		
		switch (getDirection()){
			case NORTH:
				setPosX(getPosX() - steps);
				break;
			case EAST:
				setPosY(getPosY() + steps);
				break;
			case SOUTH:
				setPosX(getPosX() + steps);
				break;
			case WEST:
				setPosY(getPosY() - steps);
				break;
			default:
				System.out.println("Error in moveStep. Robot class");
		}
		
	}
	
	public static int getPosX(){
		return posX;
	}
	
	public static void setPosX(int posX){
		//check if the move is within the board
		if (posX < 0) {
			System.out.println("Move invalid, robot would end up outside of board on position: " + posX + " on the x-axis");
		} else if (posX > BoardBuild.getXAxis()){
			System.out.println("2Move invalid, robot would end up outside of board on position: " + posX + " on the x-axis");
		} else {
			Robot.posX = posX;
		}
	}
	
	public static int getPosY(){
		return posY;
	}
	
	public static void setPosY(int posY){
		//check if the move is within the board
		if (posY < 0) {
			System.out.println("Move invalid, robot would end up outside of board on position: " + posY + " on the y-axis");
		} else if (posY > BoardBuild.getYAxis()){
			System.out.println("2Move invalid, robot would end up outside of board on position: " + posY + " on the y-axis");
		} else {
			Robot.posY = posY;
		}
	}

	
	public static Dir getDirection() {
		return direction;
	}

	public static void setDirection(Dir direction) {
		Robot.direction = direction;
	}

	
}
