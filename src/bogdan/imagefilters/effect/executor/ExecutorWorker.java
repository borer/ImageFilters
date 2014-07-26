package bogdan.imagefilters.effect.executor;

import java.util.concurrent.Callable;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.bitmap.Bitmap;

public class ExecutorWorker implements Callable<Bitmap> {
	
	private Bitmap bitmap;
	private Effect effect;

	public ExecutorWorker(Bitmap originalBitmap, Effect effect) {
		super();
		this.bitmap = originalBitmap;
		this.effect = effect;
	}

	@Override
	public Bitmap call() throws Exception {
		return this.effect.applay(this.bitmap); 
	}
}