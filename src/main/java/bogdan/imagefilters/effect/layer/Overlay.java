package bogdan.imagefilters.effect.layer;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Pixel;

public class Overlay extends Layer {

	/*
	 * var c = function(b, t) {
                return (b > 128) ? 255 - 2 * (255 - t) * (255 - b) / 255: (b * t * 2) / 255;
            };

            apply(bottom, top, function(b, t)
            {
                b.r = c(b.r, t.r);
                b.g = c(b.g, t.g);
                b.b = c(b.b, t.b)
            });
	 * */
	
	public Overlay(Bitmap filterImage, LayerMergeMode mode) {
		super(filterImage, mode);
	}

	@Override
	public Pixel process(Pixel brgba, Pixel trgba) {
		Pixel newPixel = new Pixel();
		int value;
		
		value = this.c(brgba.getR() ,trgba.getR());
		newPixel.setR( value );
		
		value = this.c(brgba.getG() ,trgba.getG());
		newPixel.setG( value );
		
		value = this.c(brgba.getB() ,trgba.getB());
		newPixel.setB( value );
		
		return newPixel;
	}
	
	private int c(int b,int t){
		
		if (b > 128){
			return (int)Math.round( (255 - 2 * (255 - t) * (255 - b) / 255) );
		} else {
			return (int)Math.round( ((b * t * 2) / 255) );
		}
		
		//return (b > 128) ? 255 - 2 * (255 - t) * (255 - b) / 255: (b * t * 2) / 255;
	}

}
