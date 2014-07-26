package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;

/**
 * Invert the image colors.
 * @author bogdan
 *
 */
public class Invert extends AbstractFilter {
	
	@Override
	public Pixel process(Pixel rgba) {
		rgba.setR( 255 - rgba.getR() );
		rgba.setG( 255 - rgba.getG() );
		rgba.setB( 255 - rgba.getB() );
		
		return rgba;
	}

}
