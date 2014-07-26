package bogdan.imagefilters.effect.filter;


import org.junit.Before;

import bogdan.imagefilters.effect.util.Pixel;

public abstract class FilterBaseTest {

	protected Pixel blackPixel;
	protected Pixel whitePixel;
	
	@Before
	public void setup(){
		this.blackPixel = new Pixel(0, 0, 0);
		this.whitePixel = new Pixel(255, 255, 255);
	}
}
