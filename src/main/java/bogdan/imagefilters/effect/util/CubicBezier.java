package bogdan.imagefilters.effect.util;

/**
 * A Cubic Bezier curve implementation.
 * @author bogdan
 *
 */

public class CubicBezier {

	private Point C1,C2,C3,C4;
	private int tableSize;
	
	public CubicBezier(Point C1,Point C2,Point C3,Point C4){
		this.C1 = C1;
		this.C2 = C2;
		this.C3 = C3;
		this.C4 = C4;
		this.tableSize = 1024;
	}
	
	/**
	 * Creates a color table for 1024 points. To create the table \n
	 * 1024 bezier points are calculated with t = i/1024 in every \n
	 * loop iteration and map is created for [x] = y. This is then \n
	 * used to project a color RGB value (x) to another color RGB value (y).
	 * @return The array with the points
	 */
	public int[] generateColorTable(){
		int[] points = new int[this.tableSize]; 
		
		for(int pointNumber=0 ; pointNumber < 1024 ; pointNumber++){
			this.createPointInBuffer(pointNumber,points);
		}
		
		return points;
	}
	
	private void createPointInBuffer(float pointNumber, int[] buffer){
		float index = pointNumber/this.tableSize;
		Point point = this.getPoint(index);
		buffer[Math.round( point.getX() ) ] = Math.round( point.getY() );
	}
	
	private Point getPoint(float t){
		float x = this.calculatePointX(t);
		float y = this.calculatePointY(t);
		
		Point point = new Point();	
		point.setX(x);
		point.setY(y);
		
		return point;
	}
	
	private float calculatePointX(float t){
		return C1.getX()*B1(t) +
				C2.getX()*B2(t) +
				C3.getX()*B3(t) +
				C4.getX()*B4(t);
	}
	
	private float calculatePointY(float t){
		return C1.getY()*B1(t) +
				C2.getY()*B2(t) +
				C3.getY()*B3(t) +
				C4.getY()*B4(t);
	}
	
	private float B1(float t){
		return t*t*t;
	}
	
	private float B2(float t){
		return 3*t*t*(1-t);
	}
	
	private float B3(float t){
		return 3*t*(1-t)*(1-t);
	}
	
	private float B4(float t){
		return (1-t)*(1-t)*(1-t);
	}
}
