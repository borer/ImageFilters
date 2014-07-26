package bogdan.imagefilters.effect.layer;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Pixel;

public class Difference extends Layer {

	public Difference(Bitmap filterImage, LayerMergeMode mode) {
		super(filterImage, mode);
	}

	@Override
	public Pixel process(Pixel brgba, Pixel trgba) {
		Pixel newPixel = new Pixel();
		
		newPixel.setR( Math.abs( trgba.getR() - brgba.getR() ) );
		newPixel.setG( Math.abs( trgba.getG() - brgba.getG() ) );
		newPixel.setB( Math.abs( trgba.getB() - brgba.getB() ) );
		
		return newPixel;
	}

}
