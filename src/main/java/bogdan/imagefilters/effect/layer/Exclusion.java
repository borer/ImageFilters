package bogdan.imagefilters.effect.layer;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Pixel;

public class Exclusion extends Layer {

	/*
	 * exclusion: function(bottom, top)
        {
            apply(bottom, top, function(b, t)
            {
                b.r = 128 - 2 * (b.r - 128) * (t.r - 128) / 255;
                b.g = 128 - 2 * (b.g - 128) * (t.g - 128) / 255;
                b.b = 128 - 2 * (b.b - 128) * (t.b - 128) / 255;
            });
        },
	 * */
	
	public Exclusion(Bitmap filterImage, LayerMergeMode mode) {
		super(filterImage, mode);
	}

	@Override
	public Pixel process(Pixel brgba, Pixel trgba) {
		Pixel newPixel = new Pixel();
		int value;
		
		value = (int)Math.round( ( 128 - 2 * (brgba.getR() - 128) * (trgba.getR() - 128) / 255 ) );
		newPixel.setR( value );
		
		value = (int)Math.round( ( 128 - 2 * (brgba.getG() - 128) * (trgba.getG() - 128) / 255 ) );
		newPixel.setG( value );
		
		value = (int)Math.round( ( 128 - 2 * (brgba.getB() - 128) * (trgba.getB() - 128) / 255 ) );
		newPixel.setB( value );
		
		return newPixel;				
	}

}
