package bogdan.imagefilters.effect.layer;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Pixel;

public class Screen extends Layer {

	/*
	 *  apply(bottom, top, function(b, t)
            {
                b.r = 255 - (((255 - t.r) * (255 - b.r)) / 255);
                b.g = 255 - (((255 - t.g) * (255 - b.g)) / 255);
                b.b = 255 - (((255 - t.b) * (255 - b.b)) / 255);
            });
	 * */
	
	public Screen(Bitmap filterImage, LayerMergeMode mode) {
		super(filterImage, mode);
	}

	@Override
	public Pixel process(Pixel brgba, Pixel trgba) {
		Pixel newPixel = new Pixel();
		
		int aux = (int)Math.round(( 255 - (((255 - trgba.getR() ) * ( 255 - brgba.getR() )) / 255) ));		
		newPixel.setR( aux );
		
		aux = (int)Math.round(( 255 - (((255 - trgba.getG() ) * ( 255 - brgba.getG() )) / 255) ));
		newPixel.setG( aux );
		
		aux = (int)Math.round(( 255 - (((255 - trgba.getB() ) * ( 255 - brgba.getB() )) / 255) ));
		newPixel.setB( aux );
		
		return newPixel;
	}

}
