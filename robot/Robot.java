package robot;
public class Robot {

	private int posX = 0;
	private int posY = 0;
	private BoardBuild board = new BoardBuild(0, 0);
	public enum Dir{NORTH, EAST, SOUTH, WEST};
	private Dir direction;
	
	public Robot (int posX, int posY, String dir, BoardBuild bb) {
		//Set the board for this instance of robot
		this.setBoard(bb);
		System.out.println("BB X size. " + bb.getXAxis());
		System.out.println("BB Y size. " + bb.getYAxis());
		
		switch(dir.toLowerCase()){
		case "n":
			this.setDirection (Dir.NORTH);
			break;
		case "e":
			this.setDirection (Dir.EAST);
			break;
		case "s":
			this.setDirection (Dir.SOUTH);
			break;
		case "w":
			this.setDirection (Dir.WEST);
			break;
		default:
			System.out.println("Wrong direction when creating robot");
		}
		
		
		this.setPosX(posX);
		this.setPosY(posY);	
	
	}
	

	//Direction L will subtract from the direction and R will add to the Direction
	public void moveDir (String turn) {
		
		switch(turn.toLowerCase()) {
		case "l":
			this.turnLeft();
			break;
		case "r":
			this.turnRight();
			break;
		default: 
			System.out.println("Wrong direction in moveDir");
			
		}
		
	}
	
	public void turnLeft(){
		switch(this.getDirection()){
			case NORTH:
				this.setDirection(Dir.WEST);
				break;
			case EAST:
				this.setDirection(Dir.NORTH);
				break;
			case SOUTH:
				this.setDirection(Dir.EAST);
				break;
			case WEST:
				this.setDirection(Dir.SOUTH);
				break;
			default:
				System.out.println("Error in turnLeft method, Robot class");
		}
	}
	
	public void turnRight() {
		switch (this.getDirection()){
			case NORTH:
				this.setDirection(Dir.EAST);
				break;
			case EAST:
				this.setDirection(Dir.SOUTH);
				break;
			case SOUTH:
				this.setDirection(Dir.WEST);
				break;
			case WEST:
				this.setDirection(Dir.NORTH);
				break;
			default:
				System.out.println("Error in turnRight method, Robot class");
		}
	}
	
	public BoardBuild getBoard() {
		return board;
	}

	public void setBoard(BoardBuild board) {
		this.board = board;
	}

	public void moveStep () {
		int steps = 1;
		
		switch (this.getDirection()){
			case NORTH:
				this.setPosX(this.getPosX() - steps);
				break;
			case EAST:
				this.setPosY(this.getPosY() + steps);
				break;
			case SOUTH:
				this.setPosX(this.posX + steps);
				break;
			case WEST:
				this.setPosY(this.posY - steps);
				break;
			default:
				System.out.println("Error in moveStep. Robot class");
		}
		
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public void setPosX(int posX){
		//check if the move is within the board
		if (posX < 0) {
			System.out.println("Move invalid, robot would end up outside of board on position: " + posX + " on the x-axis");
		} else if (posX > this.board.getXAxis()){
			System.out.println("2Move invalid, robot would end up outside of board on position: " + posX + " on the x-axis");
		} else {
			this.posX = posX;
		}
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	public void setPosY(int posY){
		//check if the move is within the board
		if (posY < 0) {
			System.out.println("Move invalid, robot would end up outside of board on position: " + posY + " on the y-axis");
		} else if (posY > this.board.getYAxis()){
			System.out.println("2Move invalid, robot would end up outside of board on position: " + posY + " on the y-axis");
		} else {
			this.posY = posY;
		}
	}

	
	public Dir getDirection() {
		return direction;
	}

	public void setDirection(Dir direction) {
		this.direction = direction;
	}

	
}
