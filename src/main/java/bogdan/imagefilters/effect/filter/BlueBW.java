package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

public class BlueBW extends AbstractFilter {

	@Override
	public Pixel process(Pixel rgba) {
		int red = rgba.getR();
		int green = rgba.getG();
		int blue = rgba.getB();

		if (blue > (red+100) && blue > (green+100) ) {
			return rgba;
		} else if((blue - green) < 100 && green > (red+40)) {
			return rgba;
		}
		else {
			int valueGrey = Utils.getGreyValue(red, green, blue);
			rgba.setR(valueGrey);
			rgba.setG(valueGrey);
			rgba.setB(valueGrey);
		}

		return rgba;
	}

}
