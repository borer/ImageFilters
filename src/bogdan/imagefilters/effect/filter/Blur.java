package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Blur ['simple', 'gaussian']
 * @author bogdan
 *
 */
public class Blur implements Filter {

	static final public int BLUR_SIMPLE =1;
	static final public int GAUSSIAN =2;
	
	private int blurType;
	
	private static final float[][] kernel_gaussian = { 
		{1/273f, 4/273f, 7/273f, 4/273f, 1/273f},
        {4/273f, 16/273f, 26/273f, 16/273f, 4/273f},
        {7/273f, 26/273f, 41/273f, 26/273f, 7/273f},
        {4/273f, 16/273f, 26/273f, 16/273f, 4/273f},             
        {1/273f, 4/273f, 7/273f, 4/273f, 1/273f}
	};
	
	private static final float[][] kernel_simple = { 
		{1/9f, 1/9f, 1/9f} ,
		{1/9f, 1/9f, 1/9f} ,
		{1/9f, 1/9f, 1/9f} 
	};
	
	
	public Blur(int typeBlur){
		this.blurType = typeBlur;
	}

	@Override
	public Bitmap apply(Bitmap original) {
		int h = original.getHeight();
		int w = original.getWidth();
		int[] buffer = original.getData();
		int[] newBuffer;
		
		if(this.blurType == Blur.BLUR_SIMPLE){
			newBuffer = Utils.convolve(buffer, h, w, kernel_simple);
		} else {
			newBuffer = Utils.convolve(buffer, h, w, kernel_gaussian);
		}
		
		original.setData(newBuffer);
		return original;		
	}

}
