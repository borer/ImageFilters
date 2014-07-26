package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;

/**
 * Subtract [0, 255]
 * @author bogdan
 *
 */
public class Substract extends AbstractFilter {
	
	private int r,g,b;
	
	public Substract(int r ,int g,int b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		rgba.setR( rgba.getR() - this.r );
		rgba.setG( rgba.getG() - this.g );
		rgba.setB( rgba.getB() - this.b );
		
		return rgba;
	}
}
