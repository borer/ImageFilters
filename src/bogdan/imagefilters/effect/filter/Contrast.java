package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Contrast [-100, 100]
 * @author bogdan
 *
 */
public class Contrast extends AbstractFilter {
	
	private float p;
	
	public Contrast(int p){
		this.p = Utils.normalize(p, 0, 2, -100, 100);
	}
	
	private float contrast(float y, float x){
		return (float) ((y - 0.5f) * x + 0.5f) ;
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		float value = this.contrast(( rgba.getR() / 255.0f ),this.p);
		rgba.setR( Math.round( 255 *  value) );
		value = this.contrast(( rgba.getG() / 255.0f ),this.p);
		rgba.setG( Math.round( 255 * value) );
		value = this.contrast(( rgba.getB() / 255.0f ),this.p);
		rgba.setB( Math.round( 255 * value) );
		
		return rgba;
		
	}

}
