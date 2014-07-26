package bogdan.imagefilters.effect.executor;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.bitmap.Bitmap;

/**
 * Defines an interface that every execution strategy has to implement.
 * @author bogdan
 *
 */
public interface EffectExecutor {

	/**
	 * Applies an effect on a given image.
	 * @param effect
	 * @param image
	 */
	public void execute(Effect effect, Bitmap image);
	
	/**
	 * Blocking method that return the processed image once all filters have been applied.
	 * WARNING : can take a long to return on big images.
	 * @return the new "after effect" image
	 */
	public Bitmap getNewImage();
	
	/**
	 * Check if the executor is done applying the effect on the image.
	 * This method is not blocking.
	 * @return true if the executor has the image ready.
	 */
	public boolean isDone();
}
