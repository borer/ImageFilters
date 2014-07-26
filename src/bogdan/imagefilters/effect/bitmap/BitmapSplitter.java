package bogdan.imagefilters.effect.bitmap;

import java.util.ArrayList;
import java.util.List;

import bogdan.imagefilters.effect.util.BufferCoordinates;

/***
 * Partition an image in chunks so can be processed in parallel.
 * 
 * @author bogdan
 * 
 */
public class BitmapSplitter {

	private Bitmap image;
	private int bufferSize;
	private int numberChunks;
	private List<BufferCoordinates> dataChunks;

	/***
	 * Constructs a list of small bitmap from the original bitmap
	 * 
	 * @return
	 */
	public List<Bitmap> splitBitmap(Bitmap image, int numberChunks) {
		this.initialize(image, numberChunks);
		this.calculateBufferCoordinates();
		List<Bitmap> chunks = this.makeBitmapChunks();

		return chunks;
	}
	
	private void initialize(Bitmap image, int numberChunks){
		this.bufferSize = image.getData().length;
		this.numberChunks = numberChunks;
		this.image = image;
		this.dataChunks = new ArrayList<BufferCoordinates>();
	}

	/***
	 * Call these method in order to get a list with all the chunks that the
	 * image can be divided.
	 * 
	 * @return
	 */
	private void calculateBufferCoordinates() {
		int sizeEachChunk = this.bufferSize / this.numberChunks;

		for (int i = 0; i < this.numberChunks; i++) {
			BufferCoordinates chunk = createDataChunk(i, sizeEachChunk);
			this.dataChunks.add(chunk);
		}
	}

	private BufferCoordinates createDataChunk(int numberChunk, int sizeChunk) {
		int chunkStart = numberChunk * sizeChunk;
		int chunkEnd = chunkStart + (sizeChunk - 1);

		if (isLastChunk(numberChunk)) {
			chunkEnd = (this.bufferSize - 1);// last chunk must have all the
												// remaing size
		}

		BufferCoordinates chunk = new BufferCoordinates(chunkStart,chunkEnd);
		return chunk;
	}

	private boolean isLastChunk(int numberChunk) {
		return ((numberChunk + 1) == this.numberChunks);
	}

	private List<Bitmap> makeBitmapChunks() {
		List<Bitmap> bitmapChunks = new ArrayList<Bitmap>();

		for (BufferCoordinates chunk : this.dataChunks) {
			Bitmap bitmapChunk = this.createBitmapChunk(chunk);
			bitmapChunks.add(bitmapChunk);
		}

		return bitmapChunks;
	}
	
	private Bitmap createBitmapChunk(BufferCoordinates chunk){
		Bitmap bitmapChunk = new ChunkBitmap(
				this.image.getData(),
				this.image.getHeight(),
				this.image.getWidth(),
				chunk);
		
		return bitmapChunk;
	}

}