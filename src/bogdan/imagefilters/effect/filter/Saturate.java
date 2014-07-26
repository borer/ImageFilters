package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Saturate [ -100, 100]
 * @author bogdan
 *
 */
public class Saturate extends AbstractFilter {

	private float p;

	public Saturate(int p){
		this.p = Utils.normalize(p, 0, 2, -100, 100);
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		float avg = ( rgba.getR() + rgba.getG() + rgba.getB() ) /3;
		
		int value = Math.round( avg + this.p *(rgba.getR() - avg) );
		rgba.setR(value);
		value = Math.round( avg + this.p *(rgba.getG() - avg) );
		rgba.setG(value);
		value = Math.round( avg + this.p *(rgba.getB() - avg) );
		rgba.setB(value);
		
		return rgba;
	}

}
