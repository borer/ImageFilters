package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Utils;

public class Sharpen implements Filter {
	
	private static final float[][] kernel = {
		{0.0f, -0.2f,  0.0f},
        {-0.2f, 1.8f, -0.2f},
        {0.0f, -0.2f,  0.0f}				
	};
	
	@Override
	public Bitmap apply(Bitmap original) {
		int h = original.getHeight();
		int w = original.getWidth();
		int[] buffer = original.getData();
		
		int[] newBuffer = Utils.convolve(buffer, h, w, kernel);
		
		original.setData(newBuffer);
		
		return original;
	}
}
