package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Brighten [-100, 100]
 * @author bogdan
 *
 */
public class Brighten extends AbstractFilter {

	private float p;

	public Brighten(int p){
		this.p = Utils.normalize(p, -255, 255, -100, 100);
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		int value = Math.round( rgba.getR() + p );
		rgba.setR( value );
		value = Math.round( rgba.getR() + p );
		rgba.setG( value );
		value = Math.round( rgba.getR() + p );
		rgba.setB( value );
		
		return rgba;
	}

}
