package bogdan.imagefilters.effect.util;

/**
 * Class that represents a point in 2D.
 * @author bogdan
 *
 */
public class Point {
	
	float x,y;
	
	public Point(){
		
	}
	
	public Point(float x,float y){
		this.x= x;
		this.y= y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
