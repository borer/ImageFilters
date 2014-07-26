package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;

/**
 * Adjust [No Range]
 * @author bogdan
 *
 */
public class Adjust extends AbstractFilter {

	private float pr,pg,pb;
	
	public Adjust(float pr,float pg,float pb){
		this.pr = pr;
		this.pg = pg;
		this.pb = pb;
	}
	
	@Override
	public Pixel process(Pixel rgba) {
		float value = rgba.getR() * (1+this.pr);
		rgba.setR( Math.round(value) );
		
		value = rgba.getG() * (1+this.pg);
		rgba.setG( Math.round(value) );
		
		value = rgba.getB() * (1+this.pb);
		rgba.setB( Math.round(value) );
		
		return rgba;
	}

}
