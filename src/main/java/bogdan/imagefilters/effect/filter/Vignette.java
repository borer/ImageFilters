package bogdan.imagefilters.effect.filter;
/*package org.bogdan.filters.effects;

import org.bogdan.filters.utils.Bitmap;

public class Vignette implements SpecialAbstractEffect {

	@Override
	public Bitmap apply(Bitmap original) {
		float radius = (float) (original.getW() / 1.5);
		RadialGradient gradient = new RadialGradient(original.getW() / 2,
				original.getH() / 2, radius, Color.TRANSPARENT, Color.BLACK,
				Shader.TileMode.CLAMP);

		Canvas canvas = new Canvas(image);
		canvas.drawARGB(1, 0, 0, 0);

		final Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.BLACK);
		paint.setShader(gradient);

		final Rect rect = new Rect(0, 0, original.getW(), original.getH());
		final RectF rectf = new RectF(rect);

		canvas.drawRect(rectf, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(original, rect, rect, paint);
	}

}

 *Clearly Shader.TitleMode.CLAMP is a linear function. 
 *What you should do instead is use 
 *RadialGradient(float x, float y, float radius, int[] colors, float[] positions, Shader.TileMode tile)
 * to define 10 or more points on the image with exponentially decreasing color values
 *  (black to transparent).
 */
