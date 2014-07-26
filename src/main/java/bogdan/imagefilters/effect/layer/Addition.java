package bogdan.imagefilters.effect.layer;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Pixel;

public class Addition extends Layer {
	
	public Addition(Bitmap filterImage, LayerMergeMode mode){
		super(filterImage, mode);
	}

	/*
	 * apply(bottom, top, function(b, t)
            {
                b.r += t.r;
                b.g += t.g;
                b.b += t.b;
            });
	 * */
	
	@Override
	public Pixel process(Pixel brgba, Pixel trgba) {
		Pixel newPixel = new Pixel();
		
		newPixel.setR( brgba.getR() + trgba.getR() );
		newPixel.setG( brgba.getG() + trgba.getG() );
		newPixel.setB( brgba.getB() + trgba.getB() );
		
		return newPixel;
	}

}
