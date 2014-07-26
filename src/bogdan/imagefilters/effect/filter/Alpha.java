package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Alpha [-100, 100]
 * @author bogdan
 *
 */
public class Alpha extends AbstractFilter {
	
	private float p;

	public Alpha(int p){
		this.p = Utils.normalize(p, 0, 255, -100, 100);
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		rgba.setA( Math.round( this.p ) );
		
		return rgba;
	}

}
