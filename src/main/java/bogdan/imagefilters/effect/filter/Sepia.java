package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;

public class Sepia extends AbstractFilter {
	
	@Override
	public Pixel process(Pixel rgba) {
		int r = rgba.getR();
		int g = rgba.getG();
		int b = rgba.getB();
		
		int value = (int) Math.round( (r * 0.393) + (g * 0.769) + (b * 0.189 ) );
		rgba.setR( value );
		value = (int) Math.round( (r * 0.349) + (g * 0.686) + (b * 0.168) );
		rgba.setG( value );
		value = (int) Math.round( (r * 0.272) + (g * 0.534) + (b * 0.131) );
		rgba.setB( value );
		
		return rgba;
	}

}
