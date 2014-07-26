package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.CubicBezier;
import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Point;

public class Curves extends AbstractFilter {
	
	private int[] points;
	
	public Curves(Point s,Point c1,Point c2,Point e){
		CubicBezier bezierFun = new CubicBezier(s, c1, c2, e);
		this.points = bezierFun.generateColorTable();
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		rgba.setR( this.points[rgba.getR()] );
		rgba.setG( this.points[rgba.getG()] );
		rgba.setB( this.points[rgba.getB()] );
		
		return rgba;
		
	}

}
