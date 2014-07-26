package bogdan.imagefilters.effect.filter;

import static org.junit.Assert.assertEquals;
import bogdan.imagefilters.effect.util.Pixel;

public class AssertUtil {
	
	public static void assertPixels(Pixel expected, Pixel actual){
		assertEquals(expected.getR(), actual.getR());
		assertEquals(expected.getG(), actual.getG());
		assertEquals(expected.getB(), actual.getB());
		assertEquals(expected.getA(), actual.getA());
	}

}
