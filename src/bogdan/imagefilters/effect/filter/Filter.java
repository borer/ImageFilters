package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.bitmap.Bitmap;

/**
 * Interface that all effect must implement.
 * Some implemented by extending the abstract class AbstractEffect,other by implementing this interface.
 * @author bogdan
 *
 */
public interface Filter {
	
	public Bitmap apply(Bitmap original);

}
