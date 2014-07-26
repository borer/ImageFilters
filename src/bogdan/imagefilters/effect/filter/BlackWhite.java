package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;

public class BlackWhite extends AbstractFilter {

	
	
	@Override
	public Pixel process(Pixel rgba) {
		
		/*float value = 0.2126f*rgba.getR() + 0.7152f*rgba.getG() + 0.0722f*rgba.getB();
		
		if (Math.round(value) < 128 ){
			rgba.setR( 255 );
			rgba.setG( 255 );
			rgba.setB( 255 );
		} else {
			rgba.setR( 0 );
			rgba.setG( 0 );
			rgba.setB( 0 );
		}*/
		
		int value = (int)Math.round(0.2126f*rgba.getR() 
				+ 0.7152f*rgba.getG() 
				+ 0.0722f*rgba.getB());
		
		rgba.setR( value );
		rgba.setG( value );
		rgba.setB( value );
		
		return rgba;
		
	}

}

