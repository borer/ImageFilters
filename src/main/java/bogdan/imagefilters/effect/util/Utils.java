package bogdan.imagefilters.effect.util;

public class Utils {
	
	/**
	 * Projects a value in the source range into the corresponding value 
	 * in the destination range.
	 * @param val
	 * @param dmin
	 * @param dmax
	 * @param smin
	 * @param smax
	 * @return
	 */
	static public float normalize(int val,int dmin,int dmax,int smin,int smax){
		
		float sdist= Utils.dist(smin,smax);
		float ddist= Utils.dist(dmin,dmax);
		float ratio= ddist / sdist;
		val = Utils.clamp(val,smin,smax);
		
		return dmin+(val-smin)*ratio;
	}
	
	/**
	 * Calculates the absolute distance between two values.
	 * @param x1 Value 1
	 * @param x2 Value 2
	 * @return The absolute distance.
	 */
	static public float dist(int x1,int x2){
		
		return (float) Math.sqrt(Math.pow(x2 - x1, 2));
	}
	
	/**
	 * Ensures a value is between min and max.If it is not ,then put it in the limits.
	 * @param val Value to check
	 * @param min Lower limit
	 * @param max upper limit
	 * @return The value ,or if it is bigger the upper limit.
	 * If the value is smaller than the lower limit
	 * return the lower limit.
	 */
	static public int clamp(int val ,int min,int max){
		
		return Math.min(max, Math.max(min, val));
	}
	
	/**
	 * Ensures a value is between min and max. Min is 0 and max is 255. 
	 * @param val Value to check.
	 * @return The value or 0 or 255.
	 */
	static public int clamp(int val){
		return Utils.clamp(val,0,255);
	}
	
	/**
	 * 
	 * Performs a kerner convolution manipulation on the data
	 * buffer. This is mostly used in masks i.e blurring or 
	 * sharpening. It is a *very* intensive operation and will
	 * be slow on big images! 
	 * It creates a temporary data buffer where it writes the
	 * new data. We can't modify the original buffer in-place 
	 * because each new pixel value depends on the original
	 * neighbouring values of that pixel (i.e the values residing)
	 * inside the kernel.
	 */
	
	static public int[] convolve(int[] bufferData ,int h ,int w,float[][] kernel){
		
		int[] tempData = new int[bufferData.length];
		int kh = kernel.length / 2;
		int kw = kernel[0].length / 2;
		
		int i=0,j=0,n=0,m=0;
		
		for (i = 0; i < h; i++) {
            for (j = 0; j < w; j++) {
            	
                int outIndex = (i*w) + (j);
                int r = 0, g = 0, b = 0;
                
                for (n = -kh; n <= kh; n++) {
                    for (m = -kw; m <= kw; m++) {
                        if (i + n >= 0 && i + n < h) {
                            if (j + m >= 0 && j + m < w) {
                            	
                            	float f = kernel[n + kh][m + kw] ;
                                //Can be optimized
                            	//if (f == 0) {continue;}
                                
                                int inIndex = ((i+n)*w) + ((j+m));
                                r += Math.round( Color.red( bufferData[inIndex] ) * f );
                                g += Math.round( Color.green( bufferData[inIndex] ) * f );
                                b += Math.round( Color.blue( bufferData[inIndex]) * f );
                            }
                        }
                    }
                }
                
                tempData[outIndex] = Color.colorToInt(Utils.clamp(r),
						Utils.clamp(g), Utils.clamp(b),255);
            }
		}
		
		return tempData;
	}
	
	/**
	 * Linear interpolation.
	 * @param t the interpolation parameter
	 * @param a the lower interpolation range
	 * @param b the upper interpolation range
	 * @return the interpolated value
	 */
	public static int lerp(float t, int a, int b) {
		return (int)(a + t * (b - a));
	}

	/**
	 * Linear interpolation of ARGB values.
	 * @param t the interpolation parameter
	 * @param rgb1 the lower interpolation range
	 * @param rgb2 the upper interpolation range
	 * @return the interpolated value
	 */
	public static int mixColors(float t, int rgb1, int rgb2) {
		int a1 = (rgb1 >> 24) & 0xff;
		int r1 = (rgb1 >> 16) & 0xff;
		int g1 = (rgb1 >> 8) & 0xff;
		int b1 = rgb1 & 0xff;
		int a2 = (rgb2 >> 24) & 0xff;
		int r2 = (rgb2 >> 16) & 0xff;
		int g2 = (rgb2 >> 8) & 0xff;
		int b2 = rgb2 & 0xff;
		a1 = lerp(t, a1, a2);
		r1 = lerp(t, r1, r2);
		g1 = lerp(t, g1, g2);
		b1 = lerp(t, b1, b2);
		return (a1 << 24) | (r1 << 16) | (g1 << 8) | b1;
	}
	
	public static int brightness(int rgb) {
		int r = (rgb >> 16) & 0xff;
		int g = (rgb >> 8) & 0xff;
		int b = rgb & 0xff;
		return (r+g+b)/3;
	}
	
	public static int brightness(Pixel p) {
		return (p.getR()+p.getG()+p.getB())/3;
	}
	
	public static int getGreyValue(int r, int g, int b){
		return Math.round(0.2126f * r + 0.7152f	* g + 0.0722f * b);
	}
}
