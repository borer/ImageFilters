package bogdan.imagefilters.effect.bitmap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SimpleBitmap implements Bitmap {

	private int[] buffer;
	private int height;
	private int width;
	
	public SimpleBitmap(String filename){
		try {
			BufferedImage image = ImageIO.read(new File(filename));
			this.constructBitmapFromBufferImage(image);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SimpleBitmap(BufferedImage image){
		this.constructBitmapFromBufferImage(image);
	}
	
	private SimpleBitmap(int[] data, int height, int width){
		this.buffer =data;
		this.height =height;
		this.width =width;
	}
	
	private void constructBitmapFromBufferImage(BufferedImage image){
		this.height = image.getHeight();
		this.width = image.getWidth();
		this.buffer = new int[this.width * this.height];
		
		image.getRGB(0, 0, this.width, this.height, this.buffer, 0, this.width);
	}
	
	/**
	 * Creates a copy of this bitmap.Can be expensive since it requires 
	 * memory and computation.
	 * @return
	 */
	public SimpleBitmap duplicate(){
		int[] newBuffer = this.duplicateBuffer();
		SimpleBitmap newBitmap = new SimpleBitmap(newBuffer, height, width);
		
		return newBitmap;
	}
	
	private int[] duplicateBuffer(){
		int[] newBuffer = new int[this.buffer.length];
		for(int i=0 ; i<this.buffer.length ; i++){
			newBuffer[i] = this.buffer[i];
		}
		
		return newBuffer;
	}
	
	public void writeToFile(String filename){
		try {
			ImageIO.write( this.getBufferedImage() , "jpg", new File(filename));
		} catch (IOException e) {
			String errorMsg = String.format("Unable to write to filename %s \n", filename);
			System.out.print(errorMsg);
			e.printStackTrace();
		}
	}
	
	private BufferedImage getBufferedImage(){
		
		BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		
		image.setRGB(0, 0, this.width, this.height, this.buffer, 0, this.width);
		
		return image;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Bitmap)) 
			return false;
		
		Bitmap otherBitmap = (Bitmap) obj;
		if(!this.isSameDimensionAs(otherBitmap))
			return false;
		
		if(!this.isSameContentAs(otherBitmap.getData()))
			return false;
		
		return true;
	};
	
	private boolean isSameDimensionAs(Bitmap other){
		if(this.width != other.getWidth())
			return false;
		if(this.height != other.getHeight())
			return false;
		
		return true;
	}
	
	private boolean isSameContentAs(int[] otherBitmapBuffer){
		if(this.buffer.length != otherBitmapBuffer.length)
			return false;
		
		for(int i=0 ; i < this.buffer.length ; i++){
			if(this.buffer[i] != otherBitmapBuffer[i])
				return false;
		}
		
		return true;
	}

	@Override
	public int[] getData() {
		return this.buffer;
	}

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
		return 0;
	}

	@Override
	public int getDataEnd() {
		return this.buffer.length;
	}
}
