package bogdan.imagefilters.effect.bitmap;

import bogdan.imagefilters.effect.util.BufferCoordinates;

public class ChunkBitmap implements Bitmap {

	private int[] buffer;
	private int height;
	private int width;
	private BufferCoordinates chunk;
	
	public ChunkBitmap(int[] buffer, int height, int width, BufferCoordinates chunk) {
		super();
		this.buffer = buffer;
		this.height = height;
		this.width = width;
		this.chunk = chunk;
	}

	@Override
	public int[] getData() {
		return this.buffer;
	}

	@Override
	public void setData(int[] data) {
		this.buffer = data;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getDataStart() {
		return this.chunk.getStart();
	}

	@Override
	public int getDataEnd() {
		return this.chunk.getEnd();
	}
}
