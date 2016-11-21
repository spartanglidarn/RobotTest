package robot;
public class BoardBuild {
	
	private String xy[][];
	private int xAxis;
	private int yAxis;
	
	public BoardBuild (int x, int y) {
		this.setXAxis(x);
		this.setYAxis(y);
		
		this.xy = new String [x][y];
		
		for (int i = 0 ; i < x ; i++) {
			
			for (int a = 0 ; a < y ; a++) {
				xy[i][a] =  i + ":" + a;
			}
			
		}
		
	}
	
	public String[][] getBoard () {
		return this.xy;
	}
	
	public int getXAxis() {
		return this.xAxis;
	}
	
	public void setXAxis(int x){
		this.xAxis = x;
	}
	
	public int getYAxis() {
		return this.yAxis;
	}
	
	public void setYAxis(int y) {
		this.yAxis = y;
	}
}
