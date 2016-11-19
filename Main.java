
public class Main {

	public static void main(String[] args) {

		//Take in the size of the matrix from the user and convert it to a string
		String matrixSize ="7 6";
		String [] msArr = matrixSize.split(" ");
		int x = Integer.parseInt(msArr[0]);
		int y = Integer.parseInt(msArr[1]);
		
		//First position
		String firstPos = "3 3 N";
		String [] fpArr = firstPos.split(" ");
		int fpX = Integer.parseInt(fpArr[0]);
		int fpY = Integer.parseInt(fpArr[1]);
		
		//Build board and robot
		BoardBuild bb = new BoardBuild(x, y);
		Robot rob = new Robot(fpX , fpY , fpArr[2]);
		
		//movement directions
		String movement = "LGGRGRGRGG";
		String [] movArr = movement.split("");
		
		//send the directions to robot
		for (String a : movArr){
			switch(a.toLowerCase()) {
				case "l":
					rob.moveDir(a);
					break;
				case "r":
					rob.moveDir(a);
				case "g":
					rob.moveStep();
					break;
				default: 
					System.out.println("Wrong movment in main");
			}		
		}
		
		//get the robots position
		int robX = rob.getPosX();
		int robY = rob.getPosY();
		
		//get the size of the board
		System.out.println(bb.getBoard());
		
		//print out the robots position
		System.out.println("Position X: " + robX);
		System.out.println("Position Y: " + robY);
		
	}

}
	
