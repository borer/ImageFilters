package bogdan.imagefilters.effect.filter;


import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Gamma [-100, 100]
 * @author bogdan
 *
 */
public class Gamma extends AbstractFilter {
	
	private float p;
	
	public Gamma(int p){
		this.p = Utils.normalize(p, 0, 2, -100, 100);
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		rgba.setR( (int)Math.round( Math.pow(rgba.getR(), this.p) ) );
		rgba.setG( (int)Math.round( Math.pow(rgba.getG(), this.p) ) );
		rgba.setB( (int)Math.round( Math.pow(rgba.getB(), this.p) ) );
		
		return rgba;
	}

}
