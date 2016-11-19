
public class Robot {
	
	// 1 = north
	// 2 = east
	// 3 = south
	// 4 = west
	private int dir = 0;
	private int posX = 0;
	private int posY = 0;
	
	
	public Robot (int posX, int posY, String dir) {
		
		switch(dir.toLowerCase()){
		case "n":
			this.setDir(1);
			break;
		case "e":
			this.setDir(2);
			break;
		case "s":
			this.setDir(3);
			break;
		case "w":
			this.setDir(4);
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
			this.setDir(getDir() - 1);
			break;
		case "r":
			this.setDir(getDir() + 1);
			break;
		default: 
			System.out.println("Wrong direction in moveDir");
			
		}
		
		//If you go to the right when you are pointing to west(4) you will point to North(1)
		if (this.getDir() > 4) {
			this.setDir(1);
		//If you go to the left when you are pointing to North(1) you will point to West(4)
		} else if (this.getDir() < 1) {
			this.setDir(4);
		}
		
	}
	
	public void moveStep () {
		int steps = 1;
		
		//If direction is set to north, remove value from x
		if (this.getDir() == 1) {
			this.setPosX(this.getPosX() - steps);
			//If direction is east, add value to y
		} else if (this.getDir() == 2) {
			this.setPosY(this.getPosY() + steps);
			//If direction is south, add value to x
		} else if (this.getDir() == 3) {
			this.setPosX(this.posX + steps);
			//If direction is west, remove value from y
		} else if (this.getDir() == 4) {
			this.setPosY(this.posY - steps);
		} else {
			System.out.println("Wrong direction!!!!");
		}
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public void setPosX(int posX){
		this.posX = posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	public void setPosY(int posY){
		this.posY = posY;
	}
	
	public int getDir() {
		return this.dir;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
	
}