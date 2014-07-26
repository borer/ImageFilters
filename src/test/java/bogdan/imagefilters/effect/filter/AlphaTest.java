package bogdan.imagefilters.effect.filter;

import static bogdan.imagefilters.effect.filter.AssertUtil.assertPixels;

import org.junit.Test;

import bogdan.imagefilters.effect.filter.Alpha;
import bogdan.imagefilters.effect.util.Pixel;

public class AlphaTest extends FilterBaseTest{
	
	@Test
	public void checkAlphaBlackPixelWithZeros() {
		Pixel expected = new Pixel(0, 0, 0);
		expected.setA(128);
		Alpha alphaFilter = new Alpha(0);
		Pixel newPixel = alphaFilter.process(this.blackPixel);
		
		assertPixels(expected, newPixel);
	}
	
	@Test
	public void checkAlphaWhitePixelWithRandom() {
		Pixel expected = new Pixel(255, 255, 255);
		expected.setA(130);
		Alpha alphaFilter = new Alpha(2);
		Pixel newPixel = alphaFilter.process(this.whitePixel);
		
		assertPixels(expected, newPixel);
	}
}
