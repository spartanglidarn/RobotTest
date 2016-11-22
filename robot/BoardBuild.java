package robot;
public class BoardBuild {
	
	private static String xy[][];
	private static int xAxis;
	private static int yAxis;
	
	public BoardBuild (int x, int y) {
		setXAxis(x);
		setYAxis(y);
		
		xy = new String [x][y];
		
		for (int i = 0 ; i < x ; i++) {
			
			for (int a = 0 ; a < y ; a++) {
				xy[i][a] =  i + ":" + a;
			}
			
		}
		
	}
	
	public static String[][] getBoard () {
		return xy;
	}
	
	public static int getXAxis() {
		return xAxis;
	}
	
	public static void setXAxis(int x){
		xAxis = x;
	}
	
	public static int getYAxis() {
		return yAxis;
	}
	
	public static void setYAxis(int y) {
		yAxis = y;
	}
}
