package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.util.Point;
import bogdan.imagefilters.effect.util.Utils;

/**
 * Expose [-100, 100]
 * @author bogdan
 *
 */
public class Expose implements Filter {

	private float p;
	
	public Expose(int p){
		this.p = Utils.normalize(p, -1, 1, -100, 100);
	}
	
	@Override
	public Bitmap apply(Bitmap original) {
		Point c0 = new Point(0, 0);
		Point c1 = new Point(0, 255* this.p);
		Point c2 = new Point(255 - (255 * this.p), 255);
		Point c3 = new Point(255, 255);
		
		Bitmap newBitmap = new Curves(c0, c1, c2, c3).apply(original);
		
		return newBitmap;
		
	}

}
