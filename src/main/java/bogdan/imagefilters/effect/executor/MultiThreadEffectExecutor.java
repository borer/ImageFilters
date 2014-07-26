package bogdan.imagefilters.effect.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.bitmap.BitmapSplitter;

public class MultiThreadEffectExecutor implements EffectExecutor{
	
	private Effect effect;
	private Bitmap image;
	private int numberWorkers;
	private CompletionService<Bitmap> executor;
	private BitmapSplitter bitmapPartition;
	private List<Future<Bitmap>> futuresBitmaps;
		
	public MultiThreadEffectExecutor() {
		super();
		this.numberWorkers = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(numberWorkers);
		this.executor = new ExecutorCompletionService<Bitmap>(executor);
		this.bitmapPartition = new BitmapSplitter();
		//this.logger = LoggerFactory.getLogger(MultiThreadEffectExecutor.class);
	}
	
	@Override
	public void execute(Effect effect, Bitmap image){
		this.init(effect, image);
		List<Bitmap> bitmapChunks = bitmapPartition.splitBitmap(image, numberWorkers);
		
		for(Bitmap bitmap : bitmapChunks){
			this.executeWorker(bitmap);
		}
	}
	
	private void init(Effect effect, Bitmap image){
		this.effect = effect;
		this.image = image;
		this.futuresBitmaps = new ArrayList<Future<Bitmap>>();
	}
	
	private void executeWorker(Bitmap imageChunk){
		ExecutorWorker effectWorker = new ExecutorWorker(imageChunk, this.effect);
		Future<Bitmap> futureBitmap = this.executor.submit(effectWorker);
		this.futuresBitmaps.add(futureBitmap);
	}
	
	@Override
	public Bitmap getNewImage(){
		for(int i=0 ; i < this.futuresBitmaps.size() ; i++){
			try {
				this.waitUntillBitmapReady();
			} catch (Exception e) {
				e.printStackTrace();
				break;
			} 
		}
		
		return this.image;
	}
	
	private void waitUntillBitmapReady() throws Exception{
		Future<Bitmap> futureBitmap = this.executor.take();
		futureBitmap.get();
	}
	
	@Override
	public boolean isDone() {
		for(Future<Bitmap> futureBitmap : this.futuresBitmaps){
			if(!futureBitmap.isDone()) 
				return false;
		}

		return true;
	}
}
