package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;

/**
 * Fill [0..255]
 * @author bogdan
 *
 */
public class Fill extends AbstractFilter {
	
	private int r,g,b;
	
	public Fill(int r,int g,int b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		rgba.setR(this.r);
		rgba.setG(this.g);
		rgba.setB(this.b);
		
		return rgba;
	}

}
