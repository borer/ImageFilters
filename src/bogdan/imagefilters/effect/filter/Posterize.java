package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Posterize [1, 255]
 * @author bogdan
 *
 */
public class Posterize extends AbstractFilter {
	int p,step;
	
	public Posterize(int p){
		this.p = Utils.clamp(p,1,255);
		this.step = (int) Math.round( Math.floor( 255 / this.p ) );
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		int value =  (int) Math.round( Math.floor( rgba.getR() / this.step ) * step );
		rgba.setR(value);
		value =  (int) Math.round( Math.floor( rgba.getG() / this.step ) * step );
		rgba.setG(value);
		value =  (int) Math.round( Math.floor( rgba.getB() / this.step ) * step );
		rgba.setB(value);
		
		return rgba;
	}

}
