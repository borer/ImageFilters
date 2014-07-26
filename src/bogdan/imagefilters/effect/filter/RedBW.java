package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

public class RedBW extends AbstractFilter {

	@Override
	public Pixel process(Pixel rgba) {
		int red = rgba.getR();
		int green = rgba.getG();
		int blue = rgba.getB();

		if (red > (green+100) && red > (blue+100)) {
			//rgba.setR(red+50);
			return rgba;
		} else {
			int value = Utils.getGreyValue(red, green, blue);
			rgba.setR(value);
			rgba.setG(value);
			rgba.setB(value);
		}

		return rgba;
	}
}
