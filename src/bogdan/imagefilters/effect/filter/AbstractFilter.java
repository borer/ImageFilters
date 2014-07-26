package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Color;
import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

public abstract class AbstractFilter implements Filter {

	public Bitmap apply(Bitmap originalImage) {
		int[] buffer = originalImage.getData();
		int bufferStart = originalImage.getDataStart();
		int bufferEnd = originalImage.getDataEnd();
		
		for(int i = bufferStart; i < bufferEnd ; i++){
			Pixel oldPixel = getPixelFromBuffer(i, buffer);
			Pixel newPixel = this.process(oldPixel);
			setPixelToBuffer(i, newPixel, buffer);
		}
		
		originalImage.setData(buffer);

		return originalImage;
	}
	
	private static Pixel getPixelFromBuffer(int position, int[] buffer){
		Pixel pixel = new Pixel();
		pixel.setR(Color.red(buffer[position]));
		pixel.setG(Color.green(buffer[position]));
		pixel.setB(Color.blue(buffer[position]));
		pixel.setA(Color.alpha(buffer[position]));
		
		return pixel;
	}
	
	private static void setPixelToBuffer(int position, Pixel pixel, int[] buffer){
		buffer[position] = Color.colorToInt(Utils.clamp(pixel.getR()),
				Utils.clamp(pixel.getG()),
				Utils.clamp(pixel.getB()),
				Utils.clamp(pixel.getA()) );		
	}
	
	public abstract Pixel process(Pixel rgba);
}
