package bogdan.imagefilters.effect.layer;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Pixel;

public class Multiply extends Layer {

	public Multiply(Bitmap filterImage, LayerMergeMode mode) {
		super(filterImage, mode);
	}

	@Override
	public Pixel process(Pixel brgba, Pixel trgba) {
		Pixel newPixel = new Pixel();
		
		newPixel.setR( Math.round((trgba.getR() * brgba.getR()) / 255.0f) );
		newPixel.setG( Math.round((trgba.getG() * brgba.getG()) / 255.0f) );
		newPixel.setB( Math.round((trgba.getB() * brgba.getB()) / 255.0f) );
		
		return newPixel;
	}

}
