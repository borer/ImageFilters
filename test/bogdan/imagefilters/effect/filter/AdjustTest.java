package bogdan.imagefilters.effect.filter;

import static bogdan.imagefilters.effect.filter.AssertUtil.*;

import org.junit.Test;

import bogdan.imagefilters.effect.filter.Adjust;
import bogdan.imagefilters.effect.util.Pixel;

public class AdjustTest extends FilterBaseTest{

	@Test
	public void checkAdjustBlackPixelWithZeros() {
		Pixel expected = new Pixel(0, 0, 0);
		Adjust adjustFilter = new Adjust(0, 0, 0);
		Pixel newPixel = adjustFilter.process(this.blackPixel);
		
		assertPixels(expected, newPixel);
	}
	
	@Test
	public void checkWhitePixelWithRandomValues() {
		Pixel expected = new Pixel(383, 306, 383);
		Adjust adjustFilter = new Adjust(0.5f, 0.2f, 0.5f);
		Pixel newPixel = adjustFilter.process(this.whitePixel);
		
		assertPixels(expected, newPixel);
	}
}
