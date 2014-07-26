package bogdan.imagefilters.effect.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.bitmap.Bitmap;

public class SingleThreadEffectExecutor implements EffectExecutor{
	
	private ExecutorService executor;
	private Future<Bitmap> futureBitmap;
	
	public SingleThreadEffectExecutor() {
		super();
		this.executor = Executors.newSingleThreadExecutor();
	}
	
	@Override
	public void execute(Effect effect, Bitmap image){
		ExecutorWorker effectWorker = new ExecutorWorker(image, effect);
		this.futureBitmap = this.executor.submit(effectWorker);
	}
	
	@Override
	public Bitmap getNewImage(){
		Bitmap newImage = null;
		
		try {
			newImage = this.futureBitmap.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} 
		
		return newImage;
	}
	
	@Override
	public boolean isDone() {
		if(futureBitmap.isDone()){
				return true;
		}
		
		return false;
	}
}
